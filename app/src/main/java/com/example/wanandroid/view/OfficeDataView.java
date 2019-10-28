package com.example.wanandroid.view;

import com.example.wanandroid.base.BaseView;
import com.example.wanandroid.bean.OfficeDataBean;

/**
 * Created by 裘翔 on 2019/10/25.
 */

public interface OfficeDataView extends BaseView{
    void onSuccess(OfficeDataBean data);
    void onFailed(String str);
}
