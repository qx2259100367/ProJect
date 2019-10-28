package com.example.wanandroid.view;

import com.example.wanandroid.base.BaseView;
import com.example.wanandroid.bean.ProjectBean;

/**
 * Created by 裘翔 on 2019/10/25.
 */

public interface ProjectView extends BaseView{
    void onSuccess(ProjectBean projectBean);
    void onFailed(String str);
}
