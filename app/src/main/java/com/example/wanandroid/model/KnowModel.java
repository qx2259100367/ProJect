package com.example.wanandroid.model;

import com.example.wanandroid.ApiServer;
import com.example.wanandroid.base.BaseModel;
import com.example.wanandroid.bean.KnowBean;
import com.example.wanandroid.net.BaseObserver;
import com.example.wanandroid.net.HttpUtils;
import com.example.wanandroid.net.ResultCallBack;
import com.example.wanandroid.net.RxUtils;

/**
 * Created by 裘翔 on 2019/10/25.
 */

public class KnowModel extends BaseModel{

    public void loadData(final ResultCallBack<KnowBean> callBack) {
        ApiServer apiserver = HttpUtils.getInstance().getApiserver(ApiServer.knowUrl, ApiServer.class);
        apiserver.getKnow().compose(RxUtils.<KnowBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<KnowBean>(this) {
                    @Override
                    protected void onSuccess(KnowBean knowBean) {
                        callBack.onSuccess(knowBean);
                    }

                    @Override
                    protected void error(String err) {
                        callBack.onFail(err);
                    }
                });
    }
}
