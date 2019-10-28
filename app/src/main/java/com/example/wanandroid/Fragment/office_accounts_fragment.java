package com.example.wanandroid.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.wanandroid.Adaper.OfficeTabAdaper;
import com.example.wanandroid.R;
import com.example.wanandroid.base.BaseFragment;
import com.example.wanandroid.bean.OfficeTabBean;
import com.example.wanandroid.presenter.OfficePresenter;
import com.example.wanandroid.view.OfficeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 裘翔 on 2019/10/24.
 */

public class office_accounts_fragment extends BaseFragment<OfficeView,OfficePresenter> implements OfficeView{
    @BindView(R.id.article_tab)
    TabLayout mArticleTab;
    @BindView(R.id.article_vp)
    ViewPager mArticleVp;
    private List<OfficeTabBean.DataBean> data;
    private ArrayList<Fragment> fragments;
    private OfficeDataFragment officeDataFragment;
    private int id;
    private Bundle bundle;
    private OfficeTabAdaper officeTabAdaper;

    @Override
    protected OfficePresenter initPresenter() {
        return new OfficePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.official_accounts_fragment;
    }

    @Override
    public void initData() {
        mPresenter.loadDatas();
    }

    @Override
    public void onSuccess(OfficeTabBean bean) {
        data = bean.getData();
        if (data!=null){
            fragments = new ArrayList<>();
            for (int i = 0; i <data.size() ; i++) {
                id = data.get(i).getId();
                officeDataFragment = new OfficeDataFragment(id);
                officeDataFragment.setArguments(bundle);
                fragments.add(officeDataFragment);
            }
            officeTabAdaper = new OfficeTabAdaper(getChildFragmentManager(), fragments, data);
            mArticleVp.setAdapter(officeTabAdaper);
            mArticleTab.setupWithViewPager(mArticleVp);
        }
    }

    @Override
    public void onFailed(String str) {
        Toast.makeText(getContext(), "str", Toast.LENGTH_SHORT).show();
    }
}
