package com.example.wanandroid.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.wanandroid.Adaper.OfficeDataAdaper;
import com.example.wanandroid.Main_Data_Activity;
import com.example.wanandroid.R;
import com.example.wanandroid.WebActivity;
import com.example.wanandroid.base.BaseFragment;
import com.example.wanandroid.bean.OfficeDataBean;
import com.example.wanandroid.presenter.OfficeDataPresenter;
import com.example.wanandroid.view.OfficeDataView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 裘翔 on 2019/10/25.
 */

@SuppressLint("ValidFragment")
public class OfficeDataFragment extends BaseFragment<OfficeDataView, OfficeDataPresenter> implements OfficeDataView {

    private int cid;
    @BindView(R.id.office_rec)
    RecyclerView mOfficeRec;
    @BindView(R.id.office_smart)
    SmartRefreshLayout mOfficeSmart;
    private String id;
    private int page = 1;
    private List<OfficeDataBean.DataBean.DatasBean> beanList;
    private ArrayList<OfficeDataBean.DataBean.DatasBean> datasBeans;
    private OfficeDataAdaper dataAdaper;
    private String title;
    private String link;
    private Intent intent;

    @SuppressLint("ValidFragment")
    public OfficeDataFragment(int id) {
        this.cid = id;
    }

    @Override
    protected OfficeDataPresenter initPresenter() {
        return new OfficeDataPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.office_data_layout;
    }

    @Override
    public void initData() {
       // id = (String) getArguments().get("id");
        mPresenter.loadData(cid, page);
    }

    @Override
    public void initView() {
        mOfficeRec.setLayoutManager(new LinearLayoutManager(getContext()));
        datasBeans = new ArrayList<>();
        dataAdaper = new OfficeDataAdaper(getContext(), datasBeans);
        mOfficeRec.setAdapter(dataAdaper);
        mOfficeSmart.setOnLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                page++;
                mPresenter.loadData(Integer.parseInt(id),page);
                mOfficeSmart.finishLoadMore();
            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                datasBeans.clear();
                page = 0;
                initData();
                mOfficeSmart.finishRefresh();
            }
        });
        dataAdaper.setOnClickItem(new OfficeDataAdaper.OnClickItem() {
            @Override
            public void setonItemClick(View v, int position) {
                title = datasBeans.get(position).getTitle();
                link = datasBeans.get(position).getLink();
                intent = new Intent(getActivity(), Main_Data_Activity.class);
                intent.putExtra("name",title);
                intent.putExtra("link",link);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onSuccess(OfficeDataBean data) {
        beanList = data.getData().getDatas();
        datasBeans.addAll(beanList);
        dataAdaper.notifyDataSetChanged();
    }

    @Override
    public void onFailed(String str) {
        Toast.makeText(getContext(), "str", Toast.LENGTH_SHORT).show();
    }

}
