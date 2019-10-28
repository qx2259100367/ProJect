package com.example.wanandroid.base;

import android.telephony.PhoneNumberUtils;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by liguixiao on 2019/9/24.
 */

public abstract class BaseModel {
    CompositeDisposable mCompositeDisposable;
    public void destory() {
        //取消网络请求和订阅关系
        if (mCompositeDisposable != null && mCompositeDisposable.size()>0){
            //
            mCompositeDisposable.dispose();
        }
    }

    public void addDisposable(Disposable d) {
        if (mCompositeDisposable  == null){
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(d);
    }

    public void removeDisposable(Disposable disposable) {
        if (mCompositeDisposable != null){
            mCompositeDisposable.remove(disposable);
        }
    }
}
