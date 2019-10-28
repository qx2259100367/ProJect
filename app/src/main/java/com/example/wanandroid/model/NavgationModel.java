package com.example.wanandroid.model;

import com.example.wanandroid.ApiServer;
import com.example.wanandroid.base.BaseModel;
import com.example.wanandroid.bean.NavgationBean;
import com.example.wanandroid.net.BaseObserver;
import com.example.wanandroid.net.HttpUtils;
import com.example.wanandroid.net.ResultCallBack;
import com.example.wanandroid.net.RxUtils;
import com.example.wanandroid.presenter.NavgationPresenter;

/**
 * Created by 裘翔 on 2019/10/26.
 */

public class NavgationModel extends BaseModel{

    public void loadData(final ResultCallBack<NavgationBean> callBack) {
        ApiServer apiserver = HttpUtils.getInstance().getApiserver(ApiServer.NavUrl, ApiServer.class);
        apiserver.getNavData()
                .compose(RxUtils.<NavgationBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<NavgationBean>(this) {
                    @Override
                    protected void onSuccess(NavgationBean navgationBean) {
                         if (navgationBean!=null){
                             callBack.onSuccess(navgationBean);
                         }
                    }

                    @Override
                    protected void error(String err) {
                          callBack.onFail(err);
                    }
                });
    }
}
