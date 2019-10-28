package com.example.wanandroid.presenter;

import com.example.wanandroid.base.BasePresenter;
import com.example.wanandroid.bean.KnowBean;
import com.example.wanandroid.model.KnowModel;
import com.example.wanandroid.net.ResultCallBack;
import com.example.wanandroid.view.KnowView;

/**
 * Created by 裘翔 on 2019/10/25.
 */

public class KnowPresenter extends BasePresenter<KnowView> implements ResultCallBack<KnowBean> {
    private KnowView knowView;
    private KnowModel knowModel;
    @Override
    protected void initModel() {
        this.knowView=knowView;
        this.knowModel=new KnowModel();
    }

    public void loadData() {
        knowModel.loadData(this);
    }

    @Override
    public void onSuccess(KnowBean bean) {
        mView.onSuccess(bean);
    }

    @Override
    public void onFail(String msg) {
       mView.onFailed(msg);
    }
}
