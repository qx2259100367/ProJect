package com.example.wanandroid.Adaper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wanandroid.R;
import com.example.wanandroid.bean.OfficeDataBean;

import java.util.ArrayList;

/**
 * Created by 裘翔 on 2019/10/25.
 */

public class OfficeDataAdaper extends RecyclerView.Adapter<OfficeDataAdaper.ViewHolder>{
    private Context context;
    private ArrayList<OfficeDataBean.DataBean.DatasBean> list;
    private View view;

    public OfficeDataAdaper(Context context, ArrayList<OfficeDataBean.DataBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public OfficeDataAdaper.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.office_item, null);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(OfficeDataAdaper.ViewHolder holder, final int position) {
              holder.office_name.setText(list.get(position).getAuthor());
              holder.office_name_homepage.setText(list.get(position).getChapterName());
              holder.office_time_homepage.setText(list.get(position).getNiceDate());
              holder.office_desc_homepage.setText(list.get(position).getTitle());
              holder.itemView.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                       onClickItem.setonItemClick(v,position);
                  }
              });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView office_iv;
        TextView office_name_homepage;
        TextView office_desc_homepage;
        TextView office_time_homepage;
        TextView office_name;
        public ViewHolder(View itemView) {
            super(itemView);
            office_iv=itemView.findViewById(R.id.office_iv);
            office_name=itemView.findViewById(R.id.office_name);
            office_time_homepage=itemView.findViewById(R.id.office_time_homepage);
            office_desc_homepage=itemView.findViewById(R.id.office_desc_homepage);
            office_name_homepage=itemView.findViewById(R.id.office_name_homepage);
        }
    }
    private OnClickItem onClickItem;

    public void setOnClickItem(OnClickItem onClickItem) {
        this.onClickItem = onClickItem;
    }
    public interface OnClickItem{

        void setonItemClick(View v, int position);
    }
}
