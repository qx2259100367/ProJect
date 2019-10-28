package com.example.wanandroid.presenter;

import com.example.wanandroid.base.BasePresenter;
import com.example.wanandroid.base.BaseView;
import com.example.wanandroid.bean.HomeBean;
import com.example.wanandroid.bean.KnowDataBean;
import com.example.wanandroid.model.HomeModel;
import com.example.wanandroid.model.KnowDataModel;
import com.example.wanandroid.net.ResultCallBack;
import com.example.wanandroid.view.HomeView;
import com.example.wanandroid.view.KnowDataView;
import com.example.wanandroid.view.KnowView;

/**
 * Created by 裘翔 on 2019/10/27.
 */

public class KnowDataPresenter extends BasePresenter<KnowDataView> implements ResultCallBack<KnowDataBean> {
    private KnowDataView knowDataView;
    private KnowDataModel knowDataModel;
    @Override
    protected void initModel() {
        this.knowDataView=knowDataView;
        this.knowDataModel=new KnowDataModel();
    }

    public void loadData(int page, int id) {
         knowDataModel.loadData(this,page,id);
    }

    @Override
    public void onSuccess(KnowDataBean bean) {
        if (mView!=null){
            mView.onSuccess(bean);
        }
    }

    @Override
    public void onFail(String msg) {
       mView.onFailed(msg);
    }
}
