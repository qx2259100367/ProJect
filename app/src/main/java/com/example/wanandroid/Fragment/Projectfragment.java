package com.example.wanandroid.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.wanandroid.Adaper.ProjectTabAdaper;
import com.example.wanandroid.R;
import com.example.wanandroid.base.BaseFragment;
import com.example.wanandroid.bean.ProjectBean;
import com.example.wanandroid.presenter.ProjectPresenter;
import com.example.wanandroid.view.ProjectView;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 裘翔 on 2019/10/24.
 */

public class Projectfragment extends BaseFragment<ProjectView, ProjectPresenter> implements ProjectView {
    @BindView(R.id.projert_tab)
    SlidingTabLayout mProjertTab;
    @BindView(R.id.project_vp)
    ViewPager mProjectVp;
    private ArrayList<Fragment> fragments;
    private ProjectDataFragment projectDataFragment;
    private int id;
    private Bundle bundle;
    private ProjectTabAdaper tabAdaper;
    private List<ProjectBean.DataBean> data;


    @Override
    protected ProjectPresenter initPresenter() {
        return new ProjectPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.projectfragment;
    }


    @Override
    public void initData() {
        mPresenter.loadData();
    }

    @Override
    public void onSuccess(ProjectBean projectBean) {
        data = projectBean.getData();
        fragments = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            id = data.get(i).getId();
            projectDataFragment = new ProjectDataFragment();
            bundle = new Bundle();
            bundle.putString("id", String.valueOf(id));
            projectDataFragment.setArguments(bundle);
            fragments.add(projectDataFragment);
        }
        tabAdaper = new ProjectTabAdaper(getChildFragmentManager(), fragments, data);
        mProjectVp.setAdapter(tabAdaper);
        mProjertTab.setViewPager(mProjectVp);
    }

    @Override
    public void onFailed(String str) {
        Toast.makeText(getContext(), "str", Toast.LENGTH_SHORT).show();
    }
}
