package com.example.wanandroid.Adaper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wanandroid.R;
import com.example.wanandroid.bean.BannerBean;
import com.example.wanandroid.bean.HomeBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

/**
 * Created by 裘翔 on 2019/10/24.
 */

public class HomeRecAdaper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<BannerBean.DataBean> banner;
    private ArrayList<HomeBean.DataBean.DatasBean> home;

    public HomeRecAdaper(Context context, ArrayList<BannerBean.DataBean> banner, ArrayList<HomeBean.DataBean.DatasBean> home) {
        this.context = context;
        this.home = home;
        this.banner = banner;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view0 = View.inflate(context, R.layout.bannner_item, null);
            ViewHolder0 holder0 = new ViewHolder0(view0);
            return holder0;
        } else {
            View view1 = View.inflate(context, R.layout.rec_item, null);
            ViewHolder1 holder1 = new ViewHolder1(view1);
            return holder1;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == 0) {
            ViewHolder0 holder0 = (ViewHolder0) holder;
            holder0.MyBanner.setImages(banner).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    BannerBean.DataBean banners = (BannerBean.DataBean) path;
                    Glide.with(context).load(banners.getImagePath()).into(imageView);
                }
            }).start();
        } else {
            ViewHolder1 holder1 = (ViewHolder1) holder;
            if (banner.size() > 0) {
                position = position - 1;
            }
            holder1.tv_name_homepage.setText(home.get(position).getChapterName());
            holder1.tv_desc_homepage.setText(home.get(position).getTitle());
            holder1.tv_time_homepage.setText(home.get(position).getNiceDate());
            holder1.tvname.setText(home.get(position).getSuperChapterName());
            final int finalPosition = position;
            holder1.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickItem.setOnLongItemClick(v, finalPosition);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        if (banner.size() > 0) {
            return home.size() + 1;
        } else {
            return home.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (banner.size() > 0 && position == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    class ViewHolder0 extends RecyclerView.ViewHolder {
        Banner MyBanner;

        public ViewHolder0(View view0) {
            super(view0);
            MyBanner = itemView.findViewById(R.id.MyBanner);

        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        ImageView iv_homepage;
        TextView tv_name_homepage;
        TextView tv_desc_homepage;
        TextView tv_time_homepage;
        TextView tvname;

        public ViewHolder1(View view1) {
            super(view1);
            iv_homepage = itemView.findViewById(R.id.iv_homepage);
            tv_name_homepage = itemView.findViewById(R.id.tv_name_homepage);
            tv_desc_homepage = itemView.findViewById(R.id.tv_desc_homepage);
            tv_time_homepage = itemView.findViewById(R.id.tv_time_homepage);
            tvname = itemView.findViewById(R.id.tvname);
        }
    }

    private OnClickItem onClickItem;

    public void setOnClickItem(OnClickItem onClickItem) {
        this.onClickItem = onClickItem;
    }

    public interface OnClickItem {

        void setOnLongItemClick(View v, int finalPosition);
    }
}
