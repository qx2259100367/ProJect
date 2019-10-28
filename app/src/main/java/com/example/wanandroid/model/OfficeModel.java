package com.example.wanandroid.model;

import com.example.wanandroid.ApiServer;
import com.example.wanandroid.base.BaseModel;
import com.example.wanandroid.bean.OfficeTabBean;
import com.example.wanandroid.net.BaseObserver;
import com.example.wanandroid.net.HttpUtils;
import com.example.wanandroid.net.ResultCallBack;
import com.example.wanandroid.net.RxUtils;
import com.example.wanandroid.presenter.OfficePresenter;

/**
 * Created by 裘翔 on 2019/10/25.
 */

public class OfficeModel extends BaseModel{

    private ApiServer apiserver;

    public void loadData(final ResultCallBack<OfficeTabBean> callBack) {
        apiserver = HttpUtils.getInstance().getApiserver(ApiServer.OfficeUrl, ApiServer.class);
        apiserver.getOfficeTab().compose(RxUtils.<OfficeTabBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<OfficeTabBean>(this) {
                    @Override
                    protected void onSuccess(OfficeTabBean bean) {
                        if (callBack!=null){
                        callBack.onSuccess(bean);}
                    }

                    @Override
                    protected void error(String err) {
                       callBack.onFail(err);
                    }
                });
    }
}
