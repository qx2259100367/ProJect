package com.example.wanandroid.model;

import com.example.wanandroid.ApiServer;
import com.example.wanandroid.base.BaseModel;
import com.example.wanandroid.bean.RegisterBean;
import com.example.wanandroid.net.BaseObserver;
import com.example.wanandroid.net.HttpUtils;
import com.example.wanandroid.net.ResultCallBack;
import com.example.wanandroid.net.RxUtils;
import com.example.wanandroid.presenter.RegisPresenter;

/**
 * Created by 裘翔 on 2019/10/27.
 */

public class RegisModel extends BaseModel{
    public void loadDatas(final ResultCallBack<RegisterBean> callBack, String name, String pwd, String pwds) {
        ApiServer apiserver = HttpUtils.getInstance().getApiserver(ApiServer.LoginUrl, ApiServer.class);
        apiserver.getRegister(name,pwd,pwds)
                .compose(RxUtils.<RegisterBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<RegisterBean>(this) {
                    @Override
                    protected void onSuccess(RegisterBean registerBean) {
                          callBack.onSuccess(registerBean);
                    }

                    @Override
                    protected void error(String err) {
                          callBack.onFail(err);
                    }
                });
    }
}
