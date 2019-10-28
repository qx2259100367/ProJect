package com.example.wanandroid.Adaper;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wanandroid.KnowDataActivity;
import com.example.wanandroid.R;
import com.example.wanandroid.bean.KnowBean;
import com.example.wanandroid.util.SystemFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 裘翔 on 2019/10/25.
 */

public class KnowAdaper extends RecyclerView.Adapter<KnowAdaper.ViewHolder>{
    private Context context;
    private ArrayList<KnowBean.DataBean> list;

    public KnowAdaper(Context context, ArrayList<KnowBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public KnowAdaper.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.know_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(KnowAdaper.ViewHolder holder, final int position) {
         holder.know_name.setText(list.get(position).getName());
         holder.know_name.setTextColor(SystemFacade.randomColor());
        final List<KnowBean.DataBean.ChildrenBean> children = list.get(position).getChildren();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i <children.size() ; i++) {
              stringBuffer.append(children.get(i).getName()+" ");
        }
        holder.know_title.setText(stringBuffer);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<KnowBean.DataBean.ChildrenBean> children1 = list.get(position).getChildren();
                Intent intent = new Intent(context, KnowDataActivity.class);
                intent.putExtra("children", (Serializable) children1);
                intent.putExtra("name",list.get(position).getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView know_name;
        TextView know_title;
        public ViewHolder(View itemView) {
            super(itemView);
            know_name=itemView.findViewById(R.id.know_name);
            know_title=itemView.findViewById(R.id.know_titie);
        }
    }
    private OnClickItem onClickItem;

    public void setOnClickItem(OnClickItem onClickItem) {
        this.onClickItem = onClickItem;
    }
    public interface OnClickItem{

        void setonClicItem(View v, int position);
    }
}
