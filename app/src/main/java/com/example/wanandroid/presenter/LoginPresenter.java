package com.example.wanandroid.presenter;

import com.example.wanandroid.base.BasePresenter;
import com.example.wanandroid.bean.LoginBean;
import com.example.wanandroid.model.LoginModel;
import com.example.wanandroid.net.ResultCallBack;
import com.example.wanandroid.view.LoginView;

/**
 * Created by 裘翔 on 2019/10/27.
 */

public class LoginPresenter extends BasePresenter<LoginView> implements ResultCallBack<LoginBean> {
    private LoginView loginView;
    private LoginModel loginModel;
    @Override
    protected void initModel() {
        this.loginView=loginView;
        this.loginModel=loginModel;
    }

    public void loadData(String name, String pwd) {
        loginModel.loadData(this,name,pwd);
    }

    @Override
    public void onSuccess(LoginBean bean) {
        if (mView!=null){
            mView.onSuccess(bean);
        }
    }

    @Override
    public void onFail(String msg) {
         mView.onFailed(msg);
    }
}
