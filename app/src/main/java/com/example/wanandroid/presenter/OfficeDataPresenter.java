package com.example.wanandroid.presenter;

import com.example.wanandroid.base.BasePresenter;
import com.example.wanandroid.bean.OfficeDataBean;
import com.example.wanandroid.model.OfficeDataModel;
import com.example.wanandroid.model.OfficeModel;
import com.example.wanandroid.net.ResultCallBack;
import com.example.wanandroid.view.OfficeDataView;
import com.example.wanandroid.view.OfficeView;

/**
 * Created by 裘翔 on 2019/10/25.
 */

public class OfficeDataPresenter extends BasePresenter<OfficeDataView> implements ResultCallBack<OfficeDataBean> {
    private OfficeView officeView;
    private OfficeDataModel officeDataModel;
    @Override
    protected void initModel() {
        this.officeView=officeView;
        this.officeDataModel=new OfficeDataModel();
    }

    public void loadData(int id, int page) {
        officeDataModel.loadData(this,id,page);
    }

    @Override
    public void onSuccess(OfficeDataBean bean) {
         if (mView!=null){
             mView.onSuccess(bean);
         }

    }

    @Override
    public void onFail(String msg) {
         mView.onFailed(msg);
    }
}
