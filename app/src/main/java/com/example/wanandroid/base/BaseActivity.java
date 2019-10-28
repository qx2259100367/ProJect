package com.example.wanandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.example.wanandroid.util.ToastUtil;

import butterknife.ButterKnife;

/**
 * Created by liguixiao on 2019/9/24.
 */

//使用泛型，子类传递什么类型，父类帮子类保存成什么类型，避免强转
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity
        implements BaseView {

    //
    public T mPresenter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mPresenter = initPresenter();
        //以前是通过构造传递view，现在通过一个方法传递
        if (mPresenter != null){
            mPresenter.bindView(this);
        }
        initView();
        initData();
        initListener();
    }

    protected abstract T initPresenter();

    protected void initListener() {

    }

    protected void initData() {

    }

    protected void initView(){};

    //布局id
    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消网络请求，取消订阅，打断V和P的联系
        mPresenter.destory();
        mPresenter = null;
    }

}
