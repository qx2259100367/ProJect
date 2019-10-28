package com.example.wanandroid.presenter;

import android.util.Log;
import android.view.View;

import com.example.wanandroid.base.BasePresenter;
import com.example.wanandroid.bean.ProjectDataBean;
import com.example.wanandroid.model.ProjectDataModel;
import com.example.wanandroid.net.ResultCallBack;
import com.example.wanandroid.view.ProjectDataView;

/**
 * Created by 裘翔 on 2019/10/25.
 */

public class ProjectDataPresenter extends BasePresenter<ProjectDataView> implements ResultCallBack<ProjectDataBean> {
    private ProjectDataView projectDataView;
    private ProjectDataModel projectDataModel;
    public  static   final  String TAG="tag";
    @Override
    protected void initModel() {
        this.projectDataView=projectDataView;
        this.projectDataModel=new ProjectDataModel();
    }

    public void loadData(int page, int id) {
        projectDataModel.loadData(this,page,id);
    }

    @Override
    public void onSuccess(ProjectDataBean bean) {
        if (mView!=null){
         mView.onSuccess(bean);}
    }

    @Override
    public void onFail(String msg) {
        //mView.onFailed(msg);
        Log.i(TAG, "onFail: "+msg.toString());
    }
}
