package com.example.wanandroid.Adaper;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wanandroid.R;
import com.example.wanandroid.bean.ProjectDataBean;

import java.util.List;

public class ProjectDataAdapter extends RecyclerView.Adapter<ProjectDataAdapter.ViewHolder> {
    private List<ProjectDataBean.DataBean.DatasBean> datas;
    private Context context;

    public ProjectDataAdapter(List<ProjectDataBean.DataBean.DatasBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context,R.layout.project_data_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        ProjectDataBean.DataBean.DatasBean datasBean = datas.get(position);
        holder.pro_title.setText(datasBean.getDesc());
        holder.pro_author.setText(datasBean.getAuthor());
        holder.pro_time.setText(datasBean.getNiceDate());
        holder.pro_name.setText(datasBean.getTitle());
        Glide.with(context).load(datasBean.getEnvelopePic()).into(holder.pro_iv1);
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               onClickItem.setonItemClick(v,position);
           }
       });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pro_iv1;
        TextView pro_title;
        TextView  pro_time;
        TextView   pro_name;
        TextView  pro_author;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pro_iv1=itemView.findViewById(R.id.pro_iv1);
            pro_name=itemView.findViewById(R.id.pro_name);
            pro_time=itemView.findViewById(R.id.pro_time);
            pro_title=itemView.findViewById(R.id.pro_title);
            pro_author=itemView.findViewById(R.id.pro_author);
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
