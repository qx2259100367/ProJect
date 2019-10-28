package com.example.wanandroid.model;

import com.example.wanandroid.ApiServer;
import com.example.wanandroid.base.BaseModel;
import com.example.wanandroid.bean.OfficeDataBean;
import com.example.wanandroid.net.BaseObserver;
import com.example.wanandroid.net.HttpUtils;
import com.example.wanandroid.net.ResultCallBack;
import com.example.wanandroid.net.RxUtils;
import com.example.wanandroid.presenter.OfficeDataPresenter;

/**
 * Created by 裘翔 on 2019/10/25.
 */

public class OfficeDataModel extends BaseModel{

    private ApiServer apiserver;

    public void loadData(final ResultCallBack<OfficeDataBean> callBack, int id, int page) {
        apiserver = HttpUtils.getInstance().getApiserver(ApiServer.OfficeDataUrl, ApiServer.class);
        apiserver.getOfficeData(id,page)
                .compose(RxUtils.<OfficeDataBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<OfficeDataBean>(this) {
                    @Override
                    protected void onSuccess(OfficeDataBean officeDataBean) {
                            callBack.onSuccess(officeDataBean);
                    }

                    @Override
                    protected void error(String err) {
                            callBack.onFail(err);
                    }
                });
    }
}
