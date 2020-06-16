package com.charles.supershot.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.charles.supershot.R;
import com.charles.supershot.rest.DefaultRestClient;
import com.charles.supershot.rest.api.UserService;
import com.charles.supershot.rest.model.AddFriend;
import com.charles.supershot.rest.model.FriendInfo;
import com.charles.supershot.rest.model.Rounder;
import com.charles.supershot.ui.listener.PaginationScrollListener;
import com.charles.supershot.utils.LogUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddRounderActivity extends BaseActivity {
    private static final String TAG = SettingTeamActivity.class.getSimpleName();

    @BindView(R.id.tv_add_supershot)
    TextView tv_add_supershot;

    @BindView(R.id.tv_add_friend)
    TextView tv_add_friend;

    @BindView(R.id.tv_add_contact)
    TextView tv_add_contact;

    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;

    @BindView(R.id.contact_recycler_view)
    RecyclerView contact_recycler_view;

    LinearLayoutManager linearLayoutManager;
    Adapter mAdapter;

    private int mPage = 0;
    private int mSize = 20;
    private int totalCount  = 0;
    private boolean isLoading = false;

    private String mType = "U";

    private List<Rounder> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_rounder);


        ButterKnife.bind(this);

        findViews();
        attachEvents();
    }

    @Override
    protected void findViews() {
        mAdapter = new Adapter(getApplicationContext());
        linearLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        recycler_view.setLayoutManager(linearLayoutManager);
        recycler_view.setAdapter(mAdapter);
        recycler_view.addOnScrollListener(new PaginationScrollListener(linearLayoutManager) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                mPage++;

            }

            @Override
            public boolean isLastPage() {
                if (mAdapter.getItemCount() >= totalCount) {
                    return true;
                } else {
                    return false;
                }

            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });

        friendList();
    }

    @Override
    protected void attachEvents() {
        tv_add_supershot.setOnClickListener(v->{
            mType = "U";

            tv_add_supershot.setBackground(getDrawable(R.drawable.underline_apple_1));
            tv_add_supershot.setTextColor(getResources().getColor(R.color.apple));

            tv_add_friend.setBackground(null);
            tv_add_friend.setTextColor(getResources().getColor(R.color.brownish_grey));

            tv_add_contact.setBackground(null);
            tv_add_contact.setTextColor(getResources().getColor(R.color.brownish_grey));

            friendList();
        });

        tv_add_friend.setOnClickListener(v->{
            mType = "P";

            tv_add_friend.setBackground(getDrawable(R.drawable.underline_apple_1));
            tv_add_friend.setTextColor(getResources().getColor(R.color.apple));

            tv_add_supershot.setBackground(null);
            tv_add_supershot.setTextColor(getResources().getColor(R.color.brownish_grey));

            tv_add_contact.setBackground(null);
            tv_add_contact.setTextColor(getResources().getColor(R.color.brownish_grey));

            friendList();
        });

        tv_add_contact.setOnClickListener(v-> {
            tv_add_contact.setBackground(getDrawable(R.drawable.underline_apple_1));
            tv_add_contact.setTextColor(getResources().getColor(R.color.apple));

            tv_add_friend.setBackground(null);
            tv_add_friend.setTextColor(getResources().getColor(R.color.brownish_grey));

            tv_add_supershot.setBackground(null);
            tv_add_supershot.setTextColor(getResources().getColor(R.color.brownish_grey));
        });
    }

    @OnClick(R.id.cv_confirm)
    void onClickConfirm() {
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("rounders", (ArrayList<? extends Parcelable>) mList);
        setResult(RESULT_OK, intent);
        finish();
    }

    @OnClick(R.id.iv_back)
    void onClickBack() {
        finish();
    }

    private void friendList() {
        showSpinner();

        SharedPreferences prefr = getApplicationContext().getSharedPreferences("token", MODE_PRIVATE);
        String token = prefr.getString("token", "");
        Log.d("BEARER_TOKEN", token);

        mList = new ArrayList<>();

        HashMap<String, Object> query = new HashMap<>();
        query.put("page", mPage);
        query.put("size", mSize);
        query.put("type", mType);

        UserService service = new DefaultRestClient<UserService>(getBaseContext()).getClient(UserService.class);
        Call<AddFriend> call = service.friendList(token, query);
        call.enqueue(new Callback<AddFriend>() {
            @Override
            public void onResponse(Call<AddFriend> call, Response<AddFriend> response) {
                LogUtils.err(TAG, response.raw().toString());

                Log.d(TAG, response.raw().toString());

                if (200 == response.raw().code())
                {
                    totalCount = response.body().getData().getNumberOfElements();

                    List<FriendInfo> list = response.body().getData().getContent();

                    if (mAdapter != null) {
                        mList = new ArrayList<>();
                        mAdapter.clear();
                    }

                    if (mPage == 0) {
                        totalCount = response.body().getData().getNumberOfElements();
                    }

                    if (list.size() > 0) {
                        mAdapter.addAll(list);
                    }

                    isLoading = false;
                }

                else
                {
                }
                closeSpinner();
            }

            @Override
            public void onFailure(Call<AddFriend> call, Throwable t) {
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
            View view = inflater.inflate(R.layout.row_friend_check, parent, false);
            Adapter.Holder viewHolder = new Adapter.Holder(view, viewType);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(Adapter.Holder holder, int position) {
            FriendInfo item = getItem(position);

            int on_id = getResources().getIdentifier("btn_check_on", "drawable", context.getPackageName());
            int off_id = getResources().getIdentifier("btn_check_off", "drawable", context.getPackageName());

            holder.iv_check.setTag(off_id);

            holder.iv_check.setOnClickListener(v-> {
                if ((int) holder.iv_check.getTag() == off_id) {
                    holder.iv_check.setImageResource(R.drawable.btn_check_on);
                    holder.iv_check.setTag(on_id);

                    Rounder rounder = new Rounder();
                    rounder.setUserSeq(item.getUserSeq());
                    rounder.setProfileImage(item.getUser().getProfileImage());
                    rounder.setHandycap(item.getHandicap());
                    rounder.setUserName(item.getName());

                    mList.add(rounder);
                } else {
                    holder.iv_check.setImageResource(R.drawable.btn_check_off);
                    holder.iv_check.setTag(off_id);
                    for (int idx = 0; idx <= mList.size(); idx++) {
                        if (item.getUserSeq() == mList.get(idx).getUserSeq()) {
                            mList.remove(idx);
                        }
                    }
                }
            });

            Glide.with(getApplicationContext())
                    //.load(item.getUser().getProfileImage())
                    .load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQAxf_kMdZ91tOIpu23R83XOmjR14iXWnA_qf4U4TcBKD34-kOP&usqp=CAU")
                    .fitCenter()
                    .into(holder.iv_profile);

            holder.tv_friend_name.setText(item.getName());
            holder.tv_handy.setText(getResources().getString(R.string.ss_string_300) + " " + item.getHandicap());

            /*holder.et_city.setText(item.getDisplay_name());

            holder.et_city.setOnClickListener(v->{
                et_place.setText(item.getDisplay_name());

                self(item.getPk());
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
            LinearLayout row;
            ImageView iv_check;
            CircleImageView iv_profile;
            TextView tv_friend_name;
            ImageView iv_grade;
            TextView tv_handy;
            LinearLayout ll_desc;
            TextView tv_desc;

            public Holder(View view, int viewType) {
                super(view);
                ButterKnife.bind(view);
                initialViews(viewType);
            }

            private void initialViews(int type) {
                row = itemView.findViewById(R.id.box_of_row);
                iv_check = itemView.findViewById(R.id.iv_check);
                iv_profile = itemView.findViewById(R.id.iv_profile);
                tv_friend_name = itemView.findViewById(R.id.tv_friend_name);
                iv_grade = itemView.findViewById(R.id.iv_grade);
                tv_handy = itemView.findViewById(R.id.tv_handy);
                ll_desc = itemView.findViewById(R.id.ll_desc);
                tv_desc = itemView.findViewById(R.id.tv_desc);
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
