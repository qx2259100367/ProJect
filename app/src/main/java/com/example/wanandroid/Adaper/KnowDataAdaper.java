package com.example.wanandroid.Adaper;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wanandroid.Main_Data_Activity;
import com.example.wanandroid.R;
import com.example.wanandroid.bean.KnowDataBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 裘翔 on 2019/10/27.
 */

public class KnowDataAdaper extends RecyclerView.Adapter<KnowDataAdaper.ViewHolder>{
    private Context context;
    private List<KnowDataBean.DataBean.DatasBean> list;

    public KnowDataAdaper(Context context, List<KnowDataBean.DataBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public KnowDataAdaper.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.rec_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(KnowDataAdaper.ViewHolder holder, final int position) {
          holder.tv_time.setText(list.get(position).getShareUser());
          holder.tv_desc.setText(list.get(position).getTitle());
          holder.tv_time.setText(list.get(position).getNiceDate());
          holder.tv_namepage.setText(list.get(position).getChapterName());
          holder.itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  String title = list.get(position).getTitle();
                  String link = list.get(position).getLink();
                  Intent intent = new Intent(context, Main_Data_Activity.class);
                  intent.putExtra("name",title);
                  intent.putExtra("link",link);
                  context.startActivity(intent);
              }
          });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvname;
        TextView tv_namepage;
        TextView tv_desc;
        TextView tv_time;
        public ViewHolder(View itemView) {
            super(itemView);
            tvname=itemView.findViewById(R.id.tvname);
            tv_desc=itemView.findViewById(R.id.tv_desc_homepage);
            tv_namepage=itemView.findViewById(R.id.tv_name_homepage);
            tv_time=itemView.findViewById(R.id.tv_time_homepage);
        }
    }
}
