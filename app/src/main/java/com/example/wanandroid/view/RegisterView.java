package com.example.wanandroid.view;

import com.example.wanandroid.base.BaseView;
import com.example.wanandroid.bean.RegisterBean;

/**
 * Created by 裘翔 on 2019/10/27.
 */

public interface RegisterView extends BaseView{
    void onSuccess(RegisterBean registerBean);
    void onFailed(String str);
}
