package com.example.wanandroid.presenter;

import com.example.wanandroid.base.BaseFragment;
import com.example.wanandroid.base.BasePresenter;
import com.example.wanandroid.bean.OfficeTabBean;
import com.example.wanandroid.model.OfficeModel;
import com.example.wanandroid.net.ResultCallBack;
import com.example.wanandroid.view.OfficeView;

import java.util.ArrayList;

/**
 * Created by 裘翔 on 2019/10/25.
 */

public class OfficePresenter extends BasePresenter<OfficeView> implements ResultCallBack<OfficeTabBean> {
    private OfficeView officeView;
    private OfficeModel officeModel;
    @Override
    protected void initModel() {
        this.officeView=officeView;
        this.officeModel=new OfficeModel();
    }

    public void loadDatas() {
       officeModel.loadData(this);
    }

    @Override
    public void onSuccess(OfficeTabBean bean) {
        if (mView!=null){
        mView.onSuccess(bean);}
    }

    @Override
    public void onFail(String msg) {
        if (mView!=null){
       mView.onFailed(msg);}
    }
}
