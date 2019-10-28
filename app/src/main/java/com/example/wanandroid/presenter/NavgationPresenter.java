package com.example.wanandroid.presenter;

import com.example.wanandroid.base.BasePresenter;
import com.example.wanandroid.bean.NavgationBean;
import com.example.wanandroid.model.NavgationModel;
import com.example.wanandroid.net.ResultCallBack;
import com.example.wanandroid.view.NavgationView;

/**
 * Created by 裘翔 on 2019/10/26.
 */

public class NavgationPresenter extends BasePresenter<NavgationView> implements ResultCallBack<NavgationBean> {
    private NavgationView navgationView;
    private NavgationModel navgationModel;
    @Override
    protected void initModel() {
        this.navgationView=navgationView;
        this.navgationModel=new NavgationModel();
    }

    public void loadData() {
        navgationModel.loadData(this);
    }

    @Override
    public void onSuccess(NavgationBean bean) {
        if (mView!=null){
            mView.onSuccess(bean);
        }
    }

    @Override
    public void onFail(String msg) {
       mView.onFailed(msg);
    }
}
