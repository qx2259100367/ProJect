package com.example.wanandroid.net;

public interface ResultCallBack<T> {
    void onSuccess(T bean);
    void onFail(String msg);
}
