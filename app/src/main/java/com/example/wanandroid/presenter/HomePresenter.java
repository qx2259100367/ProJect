package com.example.wanandroid.presenter;

import com.example.wanandroid.base.BasePresenter;
import com.example.wanandroid.bean.BannerBean;
import com.example.wanandroid.bean.HomeBean;
import com.example.wanandroid.model.HomeModel;
import com.example.wanandroid.net.ResultCallBack;
import com.example.wanandroid.view.HomeView;

/**
 * Created by 裘翔 on 2019/10/24.
 */

public class HomePresenter extends BasePresenter<HomeView> implements ResultCallBack<HomeBean>,HomeModel.MyCallBask {
    private HomeView homeView;
    private HomeModel homeModel;

    @Override
    protected void initModel() {
        this.homeView = homeView;
        this.homeModel = new HomeModel();
    }

    public void loadData() {
         homeModel.loadData(this);
    }

    @Override
    public void onSuccess(HomeBean bean) {
       mView.onSuccess(bean);
    }

    @Override
    public void onFail(String msg) {
       mView.onFailed(msg);
    }

    public void bannerData() {
        homeModel.bannerData(this);
    }

    @Override
    public void onSucc(BannerBean bannerBean) {
        mView.setData(bannerBean);
    }
}
