package com.charles.supershot.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.charles.supershot.R;
import com.charles.supershot.rest.DefaultRestClient;
import com.charles.supershot.rest.api.UserService;
import com.charles.supershot.rest.model.FriendInfo;
import com.charles.supershot.rest.model.Rounder;
import com.charles.supershot.rest.model.User;
import com.charles.supershot.rest.model.UserInfo;
import com.charles.supershot.ui.adapter.RowRounder;
import com.charles.supershot.utils.LogUtils;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SettingRounderActivity extends BaseActivity {
    private static final String TAG = SettingRounderActivity.class.getSimpleName();

    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;

    private int REQUEST_RESULT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_rounder);


        ButterKnife.bind(this);

        findViews();
        attachEvents();
    }

    @Override
    protected void findViews() {
        getMyInfo();
    }

    @Override
    protected void attachEvents() {
    }

    @OnClick(R.id.ll_add_rounder)
    void onClickAddRounder() {
        Intent intent = new Intent(getApplicationContext(), AddRounderActivity.class);
        startActivityForResult(intent, REQUEST_RESULT);
        callActivity(AddRounderActivity.class, false);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            List<Rounder> list = data.getParcelableArrayListExtra("rounders");
        }
    }


    void getMyInfo(){
        showSpinner();

        SharedPreferences prefr = getApplicationContext().getSharedPreferences("token", MODE_PRIVATE);
        String token = prefr.getString("token", "");
        String userSeq = prefr.getString("userSeq", "");
        Log.d("BEARER_TOKEN", token);

        UserService service = new DefaultRestClient<UserService>(getBaseContext()).getClient(UserService.class);
        Call<UserInfo> call = service.userInfo(token, userSeq);
        call.enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                LogUtils.err(TAG, response.raw().toString());

                Log.d(TAG, response.raw().toString());

                if (200 == response.raw().code())
                {
                    User user = response.body().getData();
                    RowRounder n_layout = new RowRounder(getApplicationContext());
                    LinearLayout con = (LinearLayout) findViewById(R.id.rounder_ll);
                    con.addView(n_layout);

                    CardView row = con.findViewById(R.id.box_of_row);
                    CircleImageView iv_profile = con.findViewById(R.id.iv_profile);
                    TextView tv_name = con.findViewById(R.id.tv_name);
                    TextView tv_score_number = con.findViewById(R.id.tv_score_number);
                    LinearLayout ll_handy = con.findViewById(R.id.ll_handy);
                    TextView tv_name_desc = con.findViewById(R.id.tv_name_desc);

                    Glide.with(getApplicationContext())
                            .load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQAxf_kMdZ91tOIpu23R83XOmjR14iXWnA_qf4U4TcBKD34-kOP&usqp=CAU")
                            .fitCenter()
                            .into(iv_profile);
                    tv_name.setText(user.getName());
                    tv_name_desc.setText(getResources().getString(R.string.ss_string_300) + " " + user.getHandicap());
                    tv_score_number.setText("72");
                    // box_of_row iv_profile tv_name tv_score_number tv_name_desc ll_handy
                }
                else
                {
                }
                closeSpinner();
            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {
                closeSpinner();
                Log.d(TAG, t.toString());
            }

        });
    }

    class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
        private Context context;
        private List<FriendInfo> list;
        private LayoutInflater inflater;
        private ItemClickListener itemClickListener;
        private int selectedKey = -1;

        Adapter(Context context){
            this.context = context;
            inflater = LayoutInflater.from(context);
            list = new ArrayList<>();
        }

        public void add(FriendInfo item) {
            list.add(item);
            notifyItemInserted(list.size() - 1);
        }

        public void addAll(List<FriendInfo> list) {
            for (FriendInfo item : list) {
                add(item);
            }
        }

        @Override
        public Adapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.row_rounder, parent, false);
            Adapter.Holder viewHolder = new Adapter.Holder(view, viewType);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(Adapter.Holder holder, int position) {
            FriendInfo item = getItem(position);

            /**
             * CardView row;
             *             CircleImageView iv_profile;
             *             TextView tv_name;
             *             TextView tv_name_desc;
             *             LinearLayout ll_handy;
             *             TextView tv_score_number;
             *             TextView tv_score_desc;
             */

            Glide.with(getApplicationContext())
                    //.load(item.getUser().getProfileImage())
                    .load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQAxf_kMdZ91tOIpu23R83XOmjR14iXWnA_qf4U4TcBKD34-kOP&usqp=CAU")
                    .fitCenter()
                    .into(holder.iv_profile);

            holder.tv_name.setText(item.getName());
            holder.tv_name_desc.setText(getResources().getString(R.string.ss_string_300) + " " + item.getHandicap());
            holder.tv_score_number.setText(item.getRecentTotalScore() + "");


            /*holder.row.setOnClickListener(v->{

            });*/
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public FriendInfo getItem(int id) {
            return list.get(id);
        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        public void clear() {
            this.list.clear();
            notifyDataSetChanged();
        }

        class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
            CardView row;
            CircleImageView iv_profile;
            TextView tv_name;
            TextView tv_name_desc;
            LinearLayout ll_handy;
            TextView tv_score_number;
            TextView tv_score_desc;

            public Holder(View view, int viewType) {
                super(view);
                ButterKnife.bind(view);
                initialViews(viewType);
            }

            private void initialViews(int type) {
                row = itemView.findViewById(R.id.box_of_row);
                iv_profile = itemView.findViewById(R.id.iv_profile);
                tv_name = itemView.findViewById(R.id.tv_name);
                tv_name_desc = itemView.findViewById(R.id.tv_name_desc);
                ll_handy = itemView.findViewById(R.id.ll_handy);
                tv_score_desc = itemView.findViewById(R.id.tv_score_desc);
            }

            @Override
            public void onClick(View view) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(view, getAdapterPosition());
                }
            }
        }
    }

    interface ItemClickListener { void onItemClick(View view, int position); }
}