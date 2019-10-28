package com.example.wanandroid.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

public class MImageGetter implements Html.ImageGetter {
    private int mScreenWidth;
    Context c;
    TextView container;

    /**
     *
     * @param text
     * @param c
     * @param widthPixels 设备屏幕宽度
     */
    public MImageGetter(TextView text, Context c, int widthPixels) {
        this.c = c;
        this.container = text;
        this.mScreenWidth = widthPixels;
    }

    /**
     * 解析h5里面的图片
     *
     * @param source
     * @return
     */
    @Override
    public Drawable getDrawable(String source) {
        //可以根据级别显示不同的图片
        final LevelListDrawable drawable = new LevelListDrawable();

        Glide.with(c).asBitmap().load(source).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource,
                                        @Nullable Transition<? super Bitmap> transition) {

                if (resource != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(resource);
                    drawable.addLevel(1, 1, bitmapDrawable);

                    if (resource.getWidth() < container.getTextSize() ||
                            resource.getHeight() < container.getTextSize()) {
                        //处理小logo
                        int textSize = (int) container.getTextSize();
                        drawable.setBounds(0, 0, textSize
                                , textSize);
                    } else {
                        int width = resource.getWidth();
                        int height = resource.getHeight();
                        //图片宽高比
                        float ratio = width * 1.0f / height;
                        //同比例缩放图片
                        drawable.setBounds(0, 0, mScreenWidth
                                , (int) (mScreenWidth / ratio));
                    }


                    drawable.setLevel(1);
                    container.invalidate();
                    container.setText(container.getText());
                }
            }

        });


        return drawable;
    }

}