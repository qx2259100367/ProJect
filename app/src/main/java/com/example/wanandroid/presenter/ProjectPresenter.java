package com.example.wanandroid.presenter;

import com.example.wanandroid.base.BasePresenter;
import com.example.wanandroid.bean.ProjectBean;
import com.example.wanandroid.model.ProjectModel;
import com.example.wanandroid.net.ResultCallBack;
import com.example.wanandroid.view.ProjectView;

/**
 * Created by 裘翔 on 2019/10/25.
 */

public class ProjectPresenter extends BasePresenter<ProjectView> implements ResultCallBack<ProjectBean> {
    private ProjectView projectView;
    private ProjectModel projectModel;
    @Override
    protected void initModel() {
       this.projectView=projectView;
       this.projectModel=new ProjectModel();
    }

    public void loadData() {
         projectModel.loadData(this);
    }

    @Override
    public void onSuccess(ProjectBean bean) {
         mView.onSuccess(bean);
    }

    @Override
    public void onFail(String msg) {
         mView.onFailed(msg);
    }
}
