package com.example.wanandroid.model;

import com.example.wanandroid.ApiServer;
import com.example.wanandroid.base.BaseModel;
import com.example.wanandroid.bean.HomeBean;
import com.example.wanandroid.bean.KnowDataBean;
import com.example.wanandroid.net.BaseObserver;
import com.example.wanandroid.net.HttpUtils;
import com.example.wanandroid.net.ResultCallBack;
import com.example.wanandroid.net.RxUtils;
import com.example.wanandroid.presenter.KnowDataPresenter;

/**
 * Created by 裘翔 on 2019/10/27.
 */

public class KnowDataModel extends BaseModel{
    public void loadData(final ResultCallBack<KnowDataBean> callBack, int page, int id) {
        ApiServer apiserver = HttpUtils.getInstance().getApiserver(ApiServer.knowDataUrl, ApiServer.class);
        apiserver.getKnowData(page,id)
                .compose(RxUtils.<KnowDataBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<KnowDataBean>(this) {
                    @Override
                    protected void onSuccess(KnowDataBean homeBean) {
                        callBack.onSuccess(homeBean);
                    }

                    @Override
                    protected void error(String err) {
                       callBack.onFail(err);
                    }
                });
    }
}
