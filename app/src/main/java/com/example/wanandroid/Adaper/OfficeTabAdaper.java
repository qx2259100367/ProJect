package com.example.wanandroid.Adaper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.wanandroid.bean.OfficeTabBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 裘翔 on 2019/10/25.
 */

public class OfficeTabAdaper extends FragmentStatePagerAdapter{
    private ArrayList<Fragment> fs;
    private List<OfficeTabBean.DataBean> tabs;
    public OfficeTabAdaper(FragmentManager fm,ArrayList<Fragment> fs,List<OfficeTabBean.DataBean> tabs) {
        super(fm);
        this.fs=fs;
        this.tabs=tabs;
    }

    @Override
    public Fragment getItem(int position) {
        return fs.get(position);
    }

    @Override
    public int getCount() {
        return fs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getName();
    }
}
