package com.example.wanandroid.net;


import android.net.ParseException;

import com.example.wanandroid.BaseApp;
import com.example.wanandroid.R;
import com.example.wanandroid.base.BaseModel;
import com.example.wanandroid.util.ToastUtil;
import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * @author xts
 *         Created by asus on 2019/8/27.
 */

public abstract class BaseObserver<T> implements Observer<T> {

    /**
     * 解析数据失败
     */
    public static final int PARSE_ERROR = 1001;
    /**
     * 网络问题
     */
    public static final int BAD_NETWORK = 1002;
    /**
     * 连接错误
     */
    public static final int CONNECT_ERROR = 1003;
    /**
     * 连接超时
     */
    public static final int CONNECT_TIMEOUT = 1004;

    private BaseModel mModel;
    private Disposable mDisposable;

    public BaseObserver(BaseModel model) {
        this.mModel = model;
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete");
    }

    @Override
    public void onSubscribe(Disposable d) {
        //将Disposable添加到容器里面,方便后面baseModel统一取消
        this.mDisposable = d;
        mModel.addDisposable(d);
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
        //请求成功,取消订阅关系
        mDisposable.dispose();
        mModel.removeDisposable(mDisposable);
    }

    protected abstract void onSuccess(T t);

    @Override
    public void onError(Throwable e) {
        if (e instanceof HttpException) {
            //   HTTP错误
            onException(BAD_NETWORK);
        } else if (e instanceof ConnectException
                || e instanceof UnknownHostException) {
            //   连接错误
            onException(CONNECT_ERROR);
        } else if (e instanceof InterruptedIOException) {
            //  连接超时
            onException(CONNECT_TIMEOUT);
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            //  解析错误
            onException(PARSE_ERROR);
        } else {
            if (e != null) {
                error(e.toString());
            } else {
                error(BaseApp.getBaseApp().getString(R.string.unknow_error));
            }
        }
    }

    private void onException(int unknownError) {
        String err = "";
        switch (unknownError) {
            case CONNECT_ERROR:
                err = BaseApp.getRes().getString(R.string.conn_error);
                error(err);
                break;

            case CONNECT_TIMEOUT:
                err = BaseApp.getRes().getString(R.string.conn_timeout);
                error(err);
                break;

            case BAD_NETWORK:
                err = BaseApp.getRes().getString(R.string.net_error);
                error(err);
                break;

            case PARSE_ERROR:
                err = BaseApp.getRes().getString(R.string.parse_error);
                error(err);
                break;

            default:
                err = BaseApp.getRes().getString(R.string.unknow_error);
                break;
        }
        ToastUtil.showShort(err);
    }

    protected abstract void error(String err);
}
