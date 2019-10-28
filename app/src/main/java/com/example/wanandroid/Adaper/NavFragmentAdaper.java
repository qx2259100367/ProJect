package com.example.wanandroid.Adaper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.wanandroid.bean.NavgationBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 裘翔 on 2019/10/26.
 */

public class NavFragmentAdaper extends FragmentStatePagerAdapter{
    private ArrayList<Fragment> fs;
    private List<NavgationBean.DataBean> list;
    public NavFragmentAdaper(FragmentManager fm,ArrayList<Fragment> fs,List<NavgationBean.DataBean> list) {
        super(fm);
        this.fs=fs;
        this.list=list;
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
        return list.get(position).getName();
    }
}
