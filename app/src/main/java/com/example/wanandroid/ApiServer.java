package com.example.wanandroid;

import com.example.wanandroid.bean.BannerBean;
import com.example.wanandroid.bean.HomeBean;
import com.example.wanandroid.bean.KnowBean;
import com.example.wanandroid.bean.KnowDataBean;
import com.example.wanandroid.bean.LoginBean;
import com.example.wanandroid.bean.RegisterBean;
import com.example.wanandroid.bean.NavgationBean;
import com.example.wanandroid.bean.OfficeDataBean;
import com.example.wanandroid.bean.OfficeTabBean;
import com.example.wanandroid.bean.ProjectBean;
import com.example.wanandroid.bean.ProjectDataBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by 裘翔 on 2019/10/24.
 */

public interface ApiServer {
    //http://www.wanandroid.com/article/list/0/json;
    String homeUrl = "http://www.wanandroid.com/";

    @GET("article/list/0/json")
    Observable<HomeBean> getHome();

    //http://www.wanandroid.com/
    @GET("banner/json")
    Observable<BannerBean> getBanner();

    //知识体系
    String knowUrl = "http://www.wanandroid.com/";

    @GET("tree/json")
    Observable<KnowBean> getKnow();

    //知识体系详情数据
    String knowDataUrl="http://www.wanandroid.com/";
    @GET("article/list/{num}/json")
    Observable<KnowDataBean> getKnowData(@Path("num") int page, @Query("cid") int id);

    //公众号Tab栏
    String OfficeUrl = "http://wanandroid.com/";

    @GET("wxarticle/chapters/json")
    Observable<OfficeTabBean> getOfficeTab();

    String OfficeDataUrl = "http://wanandroid.com/";

    @GET("wxarticle/list/{id}/{page}/json")
    Observable<OfficeDataBean> getOfficeData(@Path("id") int id, @Path("page") int page);

    //项目Tab
    String ProUrl = "http://www.wanandroid.com/";

    @GET("project/tree/json")
    Observable<ProjectBean> getProTab();

    String Pro = "http://www.wanandroid.com/project/";

    @GET("list/{page}/json?")
    Observable<ProjectDataBean> getPro(@Path("page") int page, @Query("cid") int id);

    //导航
    String NavUrl = "http://www.wanandroid.com/";

    @GET("navi/json")
    Observable<NavgationBean> getNavData();

    String LoginUrl = "https://www.wanandroid.com/";
    @POST("user/login??")
    Observable<LoginBean> getLoginData(@Query("username") String u, @Query("password") String p);

    @POST("user/register???")
    Observable<RegisterBean> getRegister(@Query("username") String u, @Query("password") String p, @Query("repassword") String pp);
}
