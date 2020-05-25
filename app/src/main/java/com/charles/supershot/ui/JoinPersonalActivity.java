package com.charles.supershot.ui;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import com.charles.supershot.R;
import com.charles.supershot.common.Const;
import com.charles.supershot.rest.DefaultRestClient;
import com.charles.supershot.rest.api.AuthService;
import com.charles.supershot.rest.model.Join;
import com.charles.supershot.rest.model.UserData;
import com.charles.supershot.ui.adapter.AdapterSpinner;
import com.charles.supershot.utils.LogUtils;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Multipart;

public class JoinPersonalActivity extends BaseActivity {
    private static final String TAG = JoinPersonalActivity.class.getSimpleName();

    @BindView(R.id.iv_profile)
    ImageView iv_profile;

    @BindView(R.id.et_id)
    EditText et_id;

    @BindView(R.id.tv_id_check)
    TextView tv_id_check;

    @BindView(R.id.tv_id_warn)
    TextView tv_id_warn;

    @BindView(R.id.et_name)
    EditText et_name;

    @BindView(R.id.et_phone)
    EditText et_phone;

    @BindView(R.id.tv_phone_check)
    TextView tv_phone_check;

    @BindView(R.id.et_verify)
    EditText et_verify;

    @BindView(R.id.spinner)
    Spinner spinner;

    @BindView(R.id.spinner_grade)
    Spinner spinner_grade;

    @BindView(R.id.et_recommend)
    EditText et_recommend;

    @BindView(R.id.iv_service)
    ImageView iv_service;

    @BindView(R.id.tv_service_2)
    TextView tv_service_2;

    @BindView(R.id.iv_private)
    ImageView iv_private;

    @BindView(R.id.tv_private_2)
    TextView tv_private_2;

    @BindView(R.id.iv_location)
    ImageView iv_location;

    @BindView(R.id.tv_location_2)
    TextView tv_location_2;


    @BindView(R.id.cv_confirm)
    CardView cv_confirm;

    private boolean isServiceChecked = false;
    private boolean isPrivateChecked = false;
    private boolean isLocationChecked = false;

    AdapterSpinner adapterSpinner;
    AdapterSpinner adapterSpinnerGrade;

    private final int CAMERA_CODE = 1111;
    private final int GALLERY_CODE = 1112;

    private File tempFile;
    private Uri photoUri;
    private String currentPhotoPath;//실제 사진 파일 경로
    String mImageCaptureName;//이미지 이름

    private int mSelectItem;
    private Bitmap bitmap;

    private boolean isValidCheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_personal);
        ButterKnife.bind(this);

        findViews();
        attachEvents();
    }

    @Override
    protected void findViews() {
        ArrayList<String> gender = new ArrayList<>();
        gender.add(getResources().getString(R.string.ss_string_011));
        gender.add(getResources().getString(R.string.ss_string_139));
        gender.add(getResources().getString(R.string.ss_string_140));

        adapterSpinner = new AdapterSpinner(this, gender);
        spinner.setAdapter(adapterSpinner);

        ArrayList<String> grade = new ArrayList<>();
        grade.add(getResources().getString(R.string.ss_string_012));
        grade.add(getResources().getString(R.string.ss_string_141));
        grade.add(getResources().getString(R.string.ss_string_142));

        adapterSpinnerGrade = new AdapterSpinner(this, grade);
        spinner_grade.setAdapter(adapterSpinnerGrade);
    }

    @Override
    protected void attachEvents() {
        iv_service.setOnClickListener(v->{
            if (isServiceChecked)
            {
                iv_service.setImageResource(R.drawable.btn_check_off);
                isServiceChecked = false;
            }
            else
            {
                iv_service.setImageResource(R.drawable.btn_check_on);
                isServiceChecked = true;
            }
        });

        tv_service_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callActivity(ServiceAgreeActivity.class, false);
            }
        });

        iv_private.setOnClickListener(v->{
            if (isPrivateChecked)
            {
                iv_private.setImageResource(R.drawable.btn_check_off);
                isPrivateChecked = false;
            }
            else
            {
                iv_private.setImageResource(R.drawable.btn_check_on);
                isPrivateChecked = true;
            }
        });

        tv_private_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callActivity(ServiceAgreeActivity.class, false);
            }
        });

        iv_location.setOnClickListener(v->{
            if (isLocationChecked)
            {
                iv_location.setImageResource(R.drawable.btn_check_off);
                isLocationChecked = false;
            }
            else
            {
                iv_location.setImageResource(R.drawable.btn_check_on);
                isLocationChecked = true;
            }
        });

        tv_location_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //callActivity(ServiceAgreeActivity.class, false);
            }
        });

        cv_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(),(String)spinner.getItemAtPosition(position)+"이 선택되었습니다.",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        spinner_grade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(),(String)spinner_grade.getItemAtPosition(position)+"이 선택되었습니다.",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });


    }

    @OnClick(R.id.iv_back)
    void onClickBack() {
        finish();
    }

    @OnClick(R.id.iv_profile)
    void onClickPhoto() {
        showPicDialog();
    }

    @OnClick(R.id.tv_id_check)
    void onClickCheckId() {
        validId();
    }

    private void validId() {
        showSpinner();
        //tv_id_warn.setVisibility(View.GONE);

        HashMap<String, Object> query = new HashMap<>();
        query.put("userId", et_id.getText().toString());

        AuthService service =
                new DefaultRestClient<AuthService>(getBaseContext())
                        .getClient(AuthService.class);
        Call<JsonObject> call = service.validid(query);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                LogUtils.err(TAG, response.raw().toString());

                Log.d(TAG, response.raw().toString());
                if (200 == response.raw().code()) {
                    // 사용 가능
                    isValidCheck = true;
                    tv_id_warn.setVisibility(View.VISIBLE);
                    tv_id_warn.setText(getResources().getString(R.string.ss_string_146));
                } else {
                    // 사용 불가
                    isValidCheck = false;
                    tv_id_warn.setVisibility(View.VISIBLE);
                    tv_id_warn.setText(getResources().getString(R.string.ss_string_005));
                }

                closeSpinner();
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                closeSpinner();
                Log.d(TAG, t.toString());
            }
        });

        closeSpinner();
    }

    @Multipart
    private void signup() {
        showSpinner();

        HashMap<String, Object> query = new HashMap<>();

        if (!isServiceChecked || !isPrivateChecked || !isLocationChecked) {
            toast(getResources().getString(R.string.ss_string_145));
            closeSpinner();
            return;
        }

        if (!isValidCheck) {
            toast(getResources().getString(R.string.ss_string_144));
            closeSpinner();
            return;
        }

        if (spinner.getSelectedItemPosition() == 0) {
            toast(getResources().getString(R.string.ss_string_011));
            closeSpinner();
            return;
        } else if (spinner.getSelectedItemPosition() == 1) {
            query.put("gender", "male");
        } else if (spinner.getSelectedItemPosition() == 2) {
            query.put("gender", "femail");
        }

        if (spinner_grade.getSelectedItemPosition() == 0) {
            toast(getResources().getString(R.string.ss_string_012));
            closeSpinner();
            return;
        } else if (spinner_grade.getSelectedItemPosition() == 1) {
            query.put("grade", "ama");
        } else if (spinner_grade.getSelectedItemPosition() == 2) {
            query.put("grade", "pro");
        }

        String device_id = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        query.put("deviceToken", "");
        query.put("deviceType", "A");
        query.put("deviceUid", device_id);
        query.put("userId", et_id.getText().toString());
        query.put("email", "seo1108@gmail.com");
        query.put("handicap", 0);
        query.put("name", et_name.getText().toString());
        query.put("phone", et_phone.getText().toString());
        query.put("inviteId", et_recommend.getText().toString());
        query.put("noti", false);
        query.put("notiEmail", false);
        query.put("notiPush", false);
        query.put("notiSms", false);
        query.put("password", "");

        // 임시 카카오 값값
        query.put("snsId", "1322456930");
        query.put("snsType", "kakao");


        MultipartBody.Part uploadFile = null;
        File photoFile = SaveBitmapToFileCache(bitmap);

        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), photoFile);
        uploadFile = MultipartBody.Part.createFormData("file", photoFile.getName(), requestFile);

        try {
            AuthService service =
                    new DefaultRestClient<AuthService>(getBaseContext())
                            .getClient(AuthService.class);
            Call<Join> call = service.signup(uploadFile, query);
            call.enqueue(new Callback<Join>() {
                @Override
                public void onResponse(Call<Join> call, Response<Join> response) {
                    LogUtils.err(TAG, response.raw().toString());

                    Log.d(TAG, response.raw().toString());
                    if (200 == response.raw().code()) {
                        Join data = response.body();

                        SharedPreferences prefr = getApplicationContext().getSharedPreferences("sns", MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefr.edit();
                        editor.putString("snsId", data.getData().getSnsId());
                        editor.putString("snsType", data.getData().getSnsType());
                        editor.commit();

                        Log.d("SSSSSSSSSSSSSSSSSSSS", prefr.getString("snsId", ""));
                        Log.d("SSSSSSSSSSSSSSSSSSSS", prefr.getString("snsType", ""));

                        //회원가입 성공
                        callActivity(JoinConfirmActivity.class, false);
                    } else {

                    }

                    closeSpinner();
                }

                @Override
                public void onFailure(Call<Join> call, Throwable t) {
                    closeSpinner();
                    Log.d(TAG, t.toString());
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
            closeSpinner();
        }
    }



    private void showPicDialog() {
        mSelectItem = -1;
        final CharSequence[] oItems = {"사진 촬영하기", "앨범에서 사진찾기"};

        AlertDialog.Builder oDialog = new AlertDialog.Builder(this,
                android.R.style.Theme_DeviceDefault_Light_Dialog_Alert);

        oDialog.setTitle("사진 선택")
                .setSingleChoiceItems(oItems, -1, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        mSelectItem = which;
                    }
                })
                .setNeutralButton("선택", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        if (mSelectItem == 0) {
                            // 사진촬영하기
                            //selectPhoto();
                            checkCameraPermission();
                        } else if (mSelectItem == 1) {
                            // 앨범에서 사진찾기
                            selectGallery();
                        }
                    }
                })
                .show();
    }

    private void checkCameraPermission() {
        int permssionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);

        if (permssionCheck!= PackageManager.PERMISSION_GRANTED) {

            //Toast.makeText(this,"권한 승인이 필요합니다",Toast.LENGTH_LONG).show();

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {
                //toast("need CAMARA permission");
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        CAMERA_CODE);
                //toast("need CAMARA permission");
            }
        } else {
            takePhoto();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case CAMERA_CODE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    //Toast.makeText(this,"승인이 허가되어 있습니다.",Toast.LENGTH_LONG).show();
                    takePhoto();
                } else {
                    toast("permission not accepted");
                }
                return;
            }

        }
    }

    private void selectGallery() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                //toast("need WRITE_EXTERNAL_STORAGE permission");
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        CAMERA_CODE);
                //toast("need WRITE_EXTERNAL_STORAGE permission");
            }


        } else {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            startActivityForResult(intent, GALLERY_CODE);
        }

    }

    private void takePhoto() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        try {
            tempFile = createImageFile();
        } catch (IOException e) {
            toast("image processing error");
            finish();
            e.printStackTrace();
        }
        if (tempFile != null) {
            Uri photoUri = FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".provider", tempFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
            startActivityForResult(intent, CAMERA_CODE);
        }
    }

    private File createImageFile() throws IOException {
        File dir = new File(getApplicationContext().getExternalFilesDir(null) + "/path/");
        //File dir = new File(Environment.getExternalStorageDirectory() + "/path/");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        mImageCaptureName = timeStamp + ".png";
        File storageDir = new File(getApplicationContext().getExternalFilesDir(null).getAbsolutePath() + "/path/" + mImageCaptureName);
        //File storageDir = new File(Environment.getExternalStorageDirectory().getAbsoluteFile() + "/path/" + mImageCaptureName);
        currentPhotoPath = storageDir.getAbsolutePath();
        return storageDir;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode)
            {
                case GALLERY_CODE:
                    sendPicture(data.getData()); //갤러리에서 가져오기
                    break;
                case CAMERA_CODE:
                    getPictureForPhoto(); //카메라에서 가져오기
                    break; default:
                break;
            }
        }
    }

    private void sendPicture(Uri imgUri) {
        String imagePath = getRealPathFromURI(imgUri); // path 경로
        ExifInterface exif = null;
        try {
            exif = new ExifInterface(imagePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int exifOrientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
        int exifDegree = exifOrientationToDegrees(exifOrientation);
        bitmap = BitmapFactory.decodeFile(imagePath);//경로를 통해 비트맵으로 전환
        iv_profile.setImageBitmap(rotate(bitmap, exifDegree));//이미지 뷰에 비트맵 넣기
        iv_profile.setVisibility(View.VISIBLE);
    }

    private void getPictureForPhoto() {
        bitmap = BitmapFactory.decodeFile(currentPhotoPath);
        ExifInterface exif = null;
        try {
            exif = new ExifInterface(currentPhotoPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int exifOrientation;
        int exifDegree;
        if (exif != null) {
            exifOrientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            exifDegree = exifOrientationToDegrees(exifOrientation);
        } else {
            exifDegree = 0;
        }
        iv_profile.setImageBitmap(rotate(bitmap, exifDegree));//이미지 뷰에 비트맵 넣기
        iv_profile.setVisibility(View.VISIBLE);
    }



    private int exifOrientationToDegrees(int exifOrientation) {
        if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_90) {
            return 90;
        } else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_180) {
            return 180;
        } else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_270) {
            return 270;
        }

        return 0;
    }

    private Bitmap rotate(Bitmap src, float degree) {
        // Matrix 객체 생성
        Matrix matrix = new Matrix();
        // 회전 각도 셋팅
        matrix.postRotate(degree);
        // 이미지와 Matrix 를 셋팅해서 Bitmap 객체 생성
        return Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), matrix, true);
    }

    private String getRealPathFromURI(Uri contentUri) {
        int column_index=0;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if(cursor.moveToFirst()) {
            column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        }

        return cursor.getString(column_index);
    }


    private File SaveBitmapToFileCache(Bitmap bitmap) {
        File dir = new File(getApplicationContext().getExternalFilesDir(null) + "/path/");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        mImageCaptureName = timeStamp + ".png";
        String filename = getApplicationContext().getExternalFilesDir(null).getAbsolutePath() + "/path/" + mImageCaptureName;

        File fileCacheItem = new File(filename);
        OutputStream out = null;

        try
        {
            fileCacheItem.createNewFile();
            out = new FileOutputStream(fileCacheItem);

            //bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            bitmap.compress(Bitmap.CompressFormat.JPEG, Const.BITMAP_QUALITY, out);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                out.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return fileCacheItem;
    }
}
