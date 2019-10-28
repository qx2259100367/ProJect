package com.example.wanandroid.model;

import com.example.wanandroid.ApiServer;
import com.example.wanandroid.base.BaseModel;
import com.example.wanandroid.bean.ProjectBean;
import com.example.wanandroid.net.BaseObserver;
import com.example.wanandroid.net.HttpUtils;
import com.example.wanandroid.net.ResultCallBack;
import com.example.wanandroid.net.RxUtils;
import com.example.wanandroid.presenter.ProjectPresenter;

/**
 * Created by 裘翔 on 2019/10/25.
 */

public class ProjectModel extends BaseModel{

    private ApiServer apiserver;

    public void loadData(final ResultCallBack<ProjectBean> callBack) {
        apiserver = HttpUtils.getInstance().getApiserver(ApiServer.ProUrl, ApiServer.class);
        apiserver.getProTab()
                .compose(RxUtils.<ProjectBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<ProjectBean>(this) {
                    @Override
                    protected void onSuccess(ProjectBean projectBean) {
                         callBack.onSuccess(projectBean);
                    }

                    @Override
                    protected void error(String err) {
                         callBack.onFail(err);
                    }
                });
    }
}
