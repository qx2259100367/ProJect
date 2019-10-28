package com.example.wanandroid.view;

import com.example.wanandroid.base.BaseView;
import com.example.wanandroid.bean.HomeBean;
import com.example.wanandroid.bean.KnowDataBean;

/**
 * Created by 裘翔 on 2019/10/27.
 */

public interface KnowDataView extends BaseView{
      void onSuccess(KnowDataBean knowDataBean);
      void onFailed(String str);
}
