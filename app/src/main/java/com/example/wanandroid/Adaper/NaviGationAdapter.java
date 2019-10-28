package com.example.wanandroid.Adaper;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wanandroid.R;
import com.example.wanandroid.WebActivity;
import com.example.wanandroid.bean.NavgationBean;
import com.example.wanandroid.util.SystemFacade;
import com.zhy.view.flowlayout.FlowLayout;

import java.util.List;

import io.reactivex.annotations.NonNull;

public class NaviGationAdapter extends RecyclerView.Adapter<NaviGationAdapter.ViewHolder> {
    private List<NavgationBean.DataBean> articlesBeans;
    private Context context;

    public NaviGationAdapter(List<NavgationBean.DataBean> articlesBeans, Context context) {
        this.articlesBeans = articlesBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.naviadaper_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.mname.setText(articlesBeans.get(position).getName());
        final List<NavgationBean.DataBean.ArticlesBean> articles = articlesBeans.get(position).getArticles();
        for (int i = 0; i < articles.size(); i++) {
            //自定义视图
            TextView label = (TextView) View.inflate(context, R.layout.textview_item, null);
            final String data = articles.get(i).getTitle();
            final String link = articles.get(i).getLink();
            //绑定数据
            label.setTextColor(SystemFacade.randomColor());
            label.setText(data);
            label.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, data, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(context, WebActivity.class);
                    intent.putExtra("name",data);
                    intent.putExtra("wed",link);
                    context.startActivity(intent);
                }
            });
            holder.mflow.addView(label);

        }


    }

    @Override
    public int getItemCount() {
        return articlesBeans.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        FlowLayout mflow;
        TextView mname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mflow = itemView.findViewById(R.id.naviadaper_flow);
            mname = itemView.findViewById(R.id.naviadaper_name);
        }
    }

    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void OnClick(int position);
    }
}
