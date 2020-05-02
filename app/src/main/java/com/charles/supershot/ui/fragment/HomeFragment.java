package com.charles.supershot.ui.fragment;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;

import com.aigestudio.wheelpicker.WheelPicker;
import com.bumptech.glide.Glide;
import com.charles.supershot.R;
import com.charles.supershot.rest.model.SliderItem;
import com.charles.supershot.ui.BaseActivity;
import com.charles.supershot.ui.GameTypeActivity;
import com.charles.supershot.ui.SettingRounderActivity;
import com.charles.supershot.ui.SettingTeamActivity;
import com.charles.supershot.ui.adapter.SliderAdapter;
import com.charles.supershot.utils.LogUtils;
import com.smarteist.autoimageslider.SliderView;
import com.smarteist.autoimageslider.SliderViewAdapter;
//import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {
    private final String TAG = LogUtils.makeLogTag(HomeFragment.class);

    @BindView(R.id.imageSlider)
    SliderView mSliderView;

    @BindView(R.id.cv_start_game)
    CardView cv_start_game;

    private SliderAdapter mSlideAdapter;

    public static BaseFragment newInstance(BaseActivity contenxt) {
        HomeFragment frag = new HomeFragment();
        frag.mActivity = contenxt;
        return frag;
    }

    @Override
    protected void followingWorksAfterInflateView() {
        findViews();
        attachEvents();
    }

    @Override
    protected void findViews() {
        mSlideAdapter = new SliderAdapter(mActivity);
        mSliderView.setSliderAdapter(mSlideAdapter);
        //mSliderView.set
        //renewItems(this.getView());
        setSliderViews();
    }

    @Override
    protected void attachEvents() {
        cv_start_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mActivity.callActivity(GameTypeActivity.class, false);
                mActivity.callActivity(SettingTeamActivity.class, false);
            }
        });
    }






    private void setSliderViews() {

        for (int i = 0; i <= 3; i++) {
            SliderItem sliderItem = new SliderItem();
            sliderItem.setDescription("Slider Item Added Manually");



            SliderView sliderView = new SliderView(mActivity);

            switch (i) {
                case 0:
                    sliderItem.setImageUrl("https://images.pexels.com/photos/547114/pexels-photo-547114.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    mSlideAdapter.addItem(sliderItem);
                    break;
                case 1:
                    sliderItem.setImageUrl("https://images.pexels.com/photos/218983/pexels-photo-218983.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    mSlideAdapter.addItem(sliderItem);
                    break;
                case 2:
                    sliderItem.setImageUrl("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
                    mSlideAdapter.addItem(sliderItem);
                    break;
                case 3:
                    sliderItem.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    mSlideAdapter.addItem(sliderItem);
                    break;
            }


        }
    }





    public void renewItems(View view) {
        List<SliderItem> sliderItemList = new ArrayList<>();
        //dummy data
        for (int i = 0; i < 5; i++) {
            SliderItem sliderItem = new SliderItem();
            sliderItem.setDescription("Slider Item " + i);
            if (i % 2 == 0) {
                sliderItem.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
            } else {
                sliderItem.setImageUrl("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
            }
            sliderItemList.add(sliderItem);
        }
        mSlideAdapter.renewItems(sliderItemList);
    }

    public void removeLastItem(View view) {
        if (mSlideAdapter.getCount() - 1 >= 0)
            mSlideAdapter.deleteItem(mSlideAdapter.getCount() - 1);
    }

    public void addNewItem(View view) {
        SliderItem sliderItem = new SliderItem();
        sliderItem.setDescription("Slider Item Added Manually");
        sliderItem.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
        mSlideAdapter.addItem(sliderItem);
    }


    public class SliderAdapter extends
            SliderViewAdapter<SliderAdapter.SliderAdapterVH> {

        private Context context;
        private List<SliderItem> mSliderItems = new ArrayList<>();

        public SliderAdapter(Context context) {
            this.context = context;
        }

        public void renewItems(List<SliderItem> sliderItems) {
            this.mSliderItems = sliderItems;
            notifyDataSetChanged();
        }

        public void deleteItem(int position) {
            this.mSliderItems.remove(position);
            notifyDataSetChanged();
        }

        public void addItem(SliderItem sliderItem) {
            this.mSliderItems.add(sliderItem);
            notifyDataSetChanged();
        }

        @Override
        public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
            return new SliderAdapterVH(inflate);
        }

        @Override
        public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {
            SliderItem sliderItem = mSliderItems.get(position);

            Log.d("TTTTTTTTTTTTTT", sliderItem.getImageUrl());

            viewHolder.textViewDescription.setText(sliderItem.getDescription());
            viewHolder.textViewDescription.setTextSize(16);
            viewHolder.textViewDescription.setTextColor(Color.WHITE);
            /*Glide.with(viewHolder.itemView)
                    .load(sliderItem.getImageUrl())
                    .fitCenter()
                    .into(viewHolder.imageViewBackground);*/

            Glide.with(viewHolder.itemView)
                    .load(sliderItem.getImageUrl())
                    //.fitCenter()
                    .centerCrop()
                    .into(viewHolder.imageViewBackground);

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "This is item in position " + position, Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getCount() {
            //slider view count could be dynamic size
            return mSliderItems.size();
        }

        class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

            View itemView;
            ImageView imageViewBackground;
            ImageView imageGifContainer;
            TextView textViewDescription;

            public SliderAdapterVH(View itemView) {
                super(itemView);
                imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
                imageGifContainer = itemView.findViewById(R.id.iv_gif_container);
                textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
                this.itemView = itemView;
            }
        }
    }


    @Override
    public int getViewResourceId() {
        return R.layout.fragment_home;
    }
}
