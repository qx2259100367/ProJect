package com.example.wanandroid.view;

import com.example.wanandroid.base.BaseView;
import com.example.wanandroid.bean.ProjectDataBean;

/**
 * Created by 裘翔 on 2019/10/25.
 */

public interface ProjectDataView extends BaseView{
      void onSuccess(ProjectDataBean bean);
      void onFailed(String str);
}
