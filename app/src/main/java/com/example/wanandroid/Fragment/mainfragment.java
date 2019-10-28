package com.example.wanandroid.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.wanandroid.Adaper.HomeRecAdaper;
import com.example.wanandroid.Main_Data_Activity;
import com.example.wanandroid.R;
import com.example.wanandroid.base.BaseFragment;
import com.example.wanandroid.bean.BannerBean;
import com.example.wanandroid.bean.HomeBean;
import com.example.wanandroid.presenter.HomePresenter;
import com.example.wanandroid.view.HomeView;
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

public class mainfragment extends BaseFragment<HomeView, HomePresenter> implements HomeView {
    @BindView(R.id.home_rec)
    RecyclerView mHomeRec;
    @BindView(R.id.srl)
    SmartRefreshLayout mSrl;
    private ArrayList<HomeBean.DataBean.DatasBean> beans;
    private ArrayList<BannerBean.DataBean> bannerBean;
    private HomeRecAdaper recAdaper;
    private int page;

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.mainfragment;
    }

    @Override
    public void initData() {
        mPresenter.loadData();
        mPresenter.bannerData();
    }

    @Override
    public void initView() {
        mHomeRec.setLayoutManager(new LinearLayoutManager(getContext()));
        beans = new ArrayList<>();
        bannerBean = new ArrayList<>();
        recAdaper = new HomeRecAdaper(getContext(), bannerBean, beans);
        mHomeRec.setAdapter(recAdaper);
        mSrl.setOnLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {

                page++;
                mPresenter.loadData();
                mSrl.finishLoadMore();
            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                bannerBean.clear();
                beans.clear();
                page = 0;
                initData();
                mSrl.finishRefresh();
            }
        });
        recAdaper.setOnClickItem(new HomeRecAdaper.OnClickItem() {
            @Override
            public void setOnLongItemClick(View v, int finalPosition) {
                String name = beans.get(finalPosition).getTitle();
                String link = beans.get(finalPosition).getLink();
                Intent intent = new Intent(getActivity(), Main_Data_Activity.class);
                intent.putExtra("name",name);
                intent.putExtra("link",link);
                startActivity(intent);
            }
        });
    }

    @Override
    public void setData(BannerBean Bean) {
        bannerBean.addAll(Bean.getData());
        recAdaper.notifyDataSetChanged();

    }

    @Override
    public void onSuccess(HomeBean homeBean) {
        beans.addAll(homeBean.getData().getDatas());
        recAdaper.notifyDataSetChanged();
    }

    @Override
    public void onFailed(String str) {
        Toast.makeText(getContext(), "str", Toast.LENGTH_SHORT).show();
    }


}
