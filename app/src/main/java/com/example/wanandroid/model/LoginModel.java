package com.example.wanandroid.model;

import com.example.wanandroid.ApiServer;
import com.example.wanandroid.base.BaseModel;
import com.example.wanandroid.bean.LoginBean;
import com.example.wanandroid.net.BaseObserver;
import com.example.wanandroid.net.HttpUtils;
import com.example.wanandroid.net.ResultCallBack;
import com.example.wanandroid.net.RxUtils;
import com.example.wanandroid.presenter.LoginPresenter;

/**
 * Created by 裘翔 on 2019/10/27.
 */

public class LoginModel extends BaseModel{
    public void loadData(final ResultCallBack<LoginBean> callBack, String name, String pwd) {
        ApiServer apiserver = HttpUtils.getInstance().getApiserver(ApiServer.LoginUrl, ApiServer.class);
        apiserver.getLoginData(name,pwd)
                .compose(RxUtils.<LoginBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<LoginBean>(this) {
                    @Override
                    protected void onSuccess(LoginBean loginBean) {
                         callBack.onSuccess(loginBean);
                    }

                    @Override
                    protected void error(String err) {
                         callBack.onFail(err);
                    }
                });
    }
}
