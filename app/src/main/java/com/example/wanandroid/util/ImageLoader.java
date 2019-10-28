package com.example.wanandroid.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by Administrator on 2019/9/25.
 */

public class ImageLoader {
    /**
     * 加载网络图片
     * @param context
     * @param url
     * @param placeResId
     * @param iv
     */
    public static void setImage(Context context, String url,int placeResId, ImageView iv){
        RequestOptions options = new RequestOptions()
                .placeholder(placeResId);

        Glide.with(context).load(url).apply(options).into(iv);
    }

    /**
     * 加载本地资源图片
     * @param context
     * @param resId
     * @param placeResId
     * @param iv
     */
    public static void setImage(Context context, int resId,int placeResId, ImageView iv){
        RequestOptions options = new RequestOptions()
                .placeholder(placeResId);

        Glide.with(context).load(resId).apply(options).into(iv);
    }
}
