package com.example.wanandroid.view;

import com.example.wanandroid.base.BaseView;
import com.example.wanandroid.bean.LoginBean;

/**
 * Created by 裘翔 on 2019/10/27.
 */

public interface LoginView extends BaseView{
    void onSuccess(LoginBean loginBean);
    void onFailed(String str);
}
