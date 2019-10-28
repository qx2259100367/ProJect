package com.example.wanandroid.view;

import com.example.wanandroid.base.BaseView;
import com.example.wanandroid.bean.OfficeTabBean;

/**
 * Created by 裘翔 on 2019/10/25.
 */

public interface OfficeView extends BaseView{
    void onSuccess(OfficeTabBean bean);
    void onFailed(String str);
}
