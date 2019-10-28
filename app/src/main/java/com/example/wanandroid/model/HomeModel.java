package com.example.wanandroid.model;

import com.example.wanandroid.ApiServer;
import com.example.wanandroid.base.BaseModel;
import com.example.wanandroid.bean.BannerBean;
import com.example.wanandroid.bean.HomeBean;
import com.example.wanandroid.net.BaseObserver;
import com.example.wanandroid.net.HttpUtils;
import com.example.wanandroid.net.ResultCallBack;
import com.example.wanandroid.net.RxUtils;
import com.example.wanandroid.presenter.HomePresenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 裘翔 on 2019/10/24.
 */

public class HomeModel extends BaseModel{

    private Retrofit retrofit;
    private ApiServer apiserver;

    public void loadData(final ResultCallBack<HomeBean> callBack) {
        ApiServer apiserver = HttpUtils.getInstance().getApiserver(ApiServer.homeUrl, ApiServer.class);
        apiserver.getHome().compose(RxUtils.<HomeBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<HomeBean>(this) {
                    @Override
                    protected void onSuccess(HomeBean homeBean) {
                         callBack.onSuccess(homeBean);
                    }

                    @Override
                    protected void error(String err) {
                         callBack.onFail(err);
                    }
                });
    }


    public void bannerData(final MyCallBask myCallBask) {
        ApiServer apiserver = HttpUtils.getInstance().getApiserver(ApiServer.homeUrl, ApiServer.class);
        apiserver.getBanner().compose(RxUtils.<BannerBean>rxObserableSchedulerHelper())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                          myCallBask.onSucc(bannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public interface MyCallBask{
         void onSucc(BannerBean bannerBean);
    }
}
