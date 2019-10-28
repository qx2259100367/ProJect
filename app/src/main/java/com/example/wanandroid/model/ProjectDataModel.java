package com.example.wanandroid.model;

import android.util.Log;

import com.example.wanandroid.ApiServer;
import com.example.wanandroid.base.BaseModel;
import com.example.wanandroid.bean.ProjectDataBean;
import com.example.wanandroid.net.BaseObserver;
import com.example.wanandroid.net.HttpUtils;
import com.example.wanandroid.net.ResultCallBack;
import com.example.wanandroid.net.RxUtils;

/**
 * Created by 裘翔 on 2019/10/25.
 */

public class ProjectDataModel extends BaseModel{

    private ApiServer apiserver;

    public void loadData(final ResultCallBack<ProjectDataBean> callBack, int page, int id) {
        apiserver = HttpUtils.getInstance().getApiserver(ApiServer.Pro, ApiServer.class);
        apiserver.getPro(page,id)
                 .compose(RxUtils.<ProjectDataBean>rxObserableSchedulerHelper())
                 .subscribe(new BaseObserver<ProjectDataBean>(this) {
                    @Override
                    protected void onSuccess(ProjectDataBean bean) {
                        callBack.onSuccess(bean);
                        Log.i("tag","成功"+bean);
                    }

                    @Override
                    protected void error(String err) {
                        Log.i("tag","错误"+err.toString());
                        callBack.onFail(err);
                    }
                });
    }
}
