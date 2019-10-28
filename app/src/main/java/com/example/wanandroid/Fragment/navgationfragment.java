package com.example.wanandroid.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.wanandroid.Adaper.NavFragmentAdaper;
import com.example.wanandroid.Adaper.NaviGationAdapter;
import com.example.wanandroid.R;
import com.example.wanandroid.base.BaseFragment;
import com.example.wanandroid.bean.NavgationBean;
import com.example.wanandroid.presenter.NavgationPresenter;
import com.example.wanandroid.view.NavgationView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.TabView;

/**
 * Created by 裘翔 on 2019/10/24.
 */

public class navgationfragment extends BaseFragment<NavgationView,NavgationPresenter> implements NavgationView{
    @BindView(R.id.navigation_tab)
    VerticalTabLayout mNavigationTab;
    @BindView(R.id.navigation_recy)
    RecyclerView mNavigationRecy;
    private List<NavgationBean.DataBean> data;
    private ArrayList<Fragment> fs;
    private NavFragmentAdaper fragmentAdaper;
    private NaviGationAdapter gationAdapter;


    @Override
    protected NavgationPresenter initPresenter() {
        return new NavgationPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.navigation_fragment;
    }

    @Override
    public void initData() {
        mPresenter.loadData();
    }

    @Override
    public void onSuccess(NavgationBean navgationBean) {
        data = navgationBean.getData();
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mNavigationRecy.setLayoutManager(manager);
        gationAdapter = new NaviGationAdapter(data, getContext());
        mNavigationRecy.setAdapter(gationAdapter);
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
             strings.add(data.get(i).getName());
        }
        mNavigationTab.setTabAdapter(new TabAdapter(){
            @Override
            public int getCount() {
                return data.size();
            }

            @Override
            public ITabView.TabBadge getBadge(int position) {
                return null;
            }

            @Override
            public ITabView.TabIcon getIcon(int position) {
                return null;
            }

            @Override
            public ITabView.TabTitle getTitle(int position) {
                return new ITabView.TabTitle.Builder()
                        .setContent(data.get(position).getName())
                        .setTextColor(0xFF36BC9B, 0xFF757575)
                        .build();
            }

            @Override
            public int getBackground(int position) {
                return 0;
            }
        });
       mNavigationTab.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabView tab, int position) {
               manager.scrollToPositionWithOffset(position,0);
           }

           @Override
           public void onTabReselected(TabView tab, int position) {

           }
       });
    }

    @Override
    public void onFailed(String str) {
        Toast.makeText(getContext(), "str", Toast.LENGTH_SHORT).show();
    }
}
