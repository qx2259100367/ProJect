package com.example.wanandroid.view;

import com.example.wanandroid.base.BaseView;
import com.example.wanandroid.bean.NavgationBean;

/**
 * Created by 裘翔 on 2019/10/26.
 */

public interface NavgationView extends BaseView{
    void onSuccess(NavgationBean navgationBean);
    void onFailed(String str);
}
