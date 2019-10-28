package com.example.wanandroid.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.wanandroid.Adaper.KnowAdaper;
import com.example.wanandroid.KnowDataActivity;
import com.example.wanandroid.R;
import com.example.wanandroid.base.BaseFragment;
import com.example.wanandroid.bean.KnowBean;
import com.example.wanandroid.presenter.KnowPresenter;
import com.example.wanandroid.view.KnowView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 裘翔 on 2019/10/24.
 */

public class knowfragment extends BaseFragment<KnowView, KnowPresenter> implements KnowView {
    @BindView(R.id.know_rec)
    RecyclerView mKnowRec;
    @BindView(R.id.know_sml)
    SmartRefreshLayout mKnowSml;
    private ArrayList<KnowBean.DataBean> childrenBeans;
    private KnowAdaper knowAdaper;
    private int page;
    private List<KnowBean.DataBean.ChildrenBean> children;
    private Intent intent;

    @Override
    protected KnowPresenter initPresenter() {
        return new KnowPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.know_ledge_fragment;
    }

    @Override
    public void initView() {
        mKnowRec.setLayoutManager(new LinearLayoutManager(getContext()));
        childrenBeans = new ArrayList<KnowBean.DataBean>();
        knowAdaper = new KnowAdaper(getContext(), childrenBeans);
        mKnowRec.setAdapter(knowAdaper);
        mKnowSml.setOnLoadMoreListener(new OnRefreshLoadMoreListener(){
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                page++;
                mPresenter.loadData();
                mKnowSml.finishLoadMore();
            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                childrenBeans.clear();
                page = 0;
                initData();
                mKnowSml.finishRefresh();
            }
        });

    }

    @Override
    public void initData() {
        mPresenter.loadData();
    }

    @Override
    public void onSuccess(KnowBean knowBean) {
        childrenBeans.addAll(knowBean.getData());
        knowAdaper.notifyDataSetChanged();
    }

    @Override
    public void onFailed(String str) {
        Toast.makeText(getContext(), "str", Toast.LENGTH_SHORT).show();
    }
}
