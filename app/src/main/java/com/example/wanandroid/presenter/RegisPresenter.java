package com.example.wanandroid.presenter;

import com.example.wanandroid.base.BasePresenter;
import com.example.wanandroid.bean.RegisterBean;
import com.example.wanandroid.model.RegisModel;
import com.example.wanandroid.net.ResultCallBack;
import com.example.wanandroid.view.RegisterView;

/**
 * Created by 裘翔 on 2019/10/27.
 */

public class RegisPresenter extends BasePresenter<RegisterView> implements ResultCallBack<RegisterBean> {
    private RegisterView registerView;
    private RegisModel regisModel;

    @Override
    protected void initModel() {
        this.registerView = registerView;
        this.regisModel = new RegisModel();
    }

    public void loadData(String name, String pwd, String pwds) {
        regisModel.loadDatas(this, name, pwd, pwds);
    }

    @Override
    public void onSuccess(RegisterBean bean) {
        if (mView != null) {
            mView.onSuccess(bean);
        }
    }

    @Override
    public void onFail(String msg) {
        mView.onFailed(msg);
    }
}
