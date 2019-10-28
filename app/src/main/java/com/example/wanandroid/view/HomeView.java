package com.example.wanandroid.view;

import com.example.wanandroid.base.BaseView;
import com.example.wanandroid.bean.BannerBean;
import com.example.wanandroid.bean.HomeBean;

/**
 * Created by 裘翔 on 2019/10/24.
 */

public interface HomeView extends BaseView{
    void onSuccess(HomeBean homeBean);
    void onFailed(String str);
    void setData(BannerBean bannerBean);
}
