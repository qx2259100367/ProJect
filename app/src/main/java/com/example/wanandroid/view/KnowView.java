package com.example.wanandroid.view;

import com.example.wanandroid.base.BaseView;
import com.example.wanandroid.bean.KnowBean;

/**
 * Created by 裘翔 on 2019/10/25.
 */

public interface KnowView extends BaseView{
      void onSuccess(KnowBean knowBean);
      void onFailed(String str);
}
