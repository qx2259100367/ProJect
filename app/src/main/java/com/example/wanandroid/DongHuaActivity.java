package com.example.wanandroid;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

public class DongHuaActivity extends AppCompatActivity {
    private Handler handler=new Handler();
    int time = 1;
    private LottieAnimationView mOneAnimation;
    private LottieAnimationView mTwoAnimation;
    private LottieAnimationView mThreeAnimation;
    private LottieAnimationView mFourAnimation;
    private LottieAnimationView mFiveAnimation;
    private LottieAnimationView mSixAnimation;
    private LottieAnimationView mSevenAnimation;
    private LottieAnimationView mEightAnimation;
    private LottieAnimationView mNineAnimation;
    private LottieAnimationView mTenAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dong_hua);
        initView();
        initData();
        inSkip();
    }
    private void inSkip() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (time == 0) {
                    startActivity(new Intent(DongHuaActivity.this, MainActivity.class));
                    finish();
                } else {
                    time--;
                    inSkip();
                }
            }
        }, 1000);
    }

    private void initData() {
        startAnimation(mOneAnimation, "W.json");
        startAnimation(mTwoAnimation, "A.json");
        startAnimation(mThreeAnimation, "N.json");
        startAnimation(mFourAnimation, "A.json");
        startAnimation(mFiveAnimation, "N.json");
        startAnimation(mSixAnimation, "D.json");
        startAnimation(mSevenAnimation, "R.json");
        startAnimation(mEightAnimation, "I.json");
        startAnimation(mNineAnimation, "O.json");
        startAnimation(mTenAnimation, "D.json");
    }

    private void cancelAnimation() {
        cancelAnimation(mOneAnimation);
        cancelAnimation(mTwoAnimation);
        cancelAnimation(mThreeAnimation);
        cancelAnimation(mFourAnimation);
        cancelAnimation(mFiveAnimation);
        cancelAnimation(mSixAnimation);
        cancelAnimation(mSevenAnimation);
        cancelAnimation(mEightAnimation);

        cancelAnimation(mNineAnimation);
        cancelAnimation(mTenAnimation);
    }

    private void startAnimation(LottieAnimationView mLottieAnimationView, String animationName) {
        mLottieAnimationView.setAnimation(animationName);
        mLottieAnimationView.playAnimation();
    }

    private void cancelAnimation(LottieAnimationView mLottieAnimationView) {
        if (mLottieAnimationView != null) {
            mLottieAnimationView.cancelAnimation();
        }
    }

    @Override
    protected void onDestroy() {
        cancelAnimation();
        super.onDestroy();
    }

    private void initView() {
        mOneAnimation = (LottieAnimationView) findViewById(R.id.one_animation);
        mTwoAnimation = (LottieAnimationView) findViewById(R.id.two_animation);
        mThreeAnimation = (LottieAnimationView) findViewById(R.id.three_animation);
        mFourAnimation = (LottieAnimationView) findViewById(R.id.four_animation);
        mFiveAnimation = (LottieAnimationView) findViewById(R.id.five_animation);
        mSixAnimation = (LottieAnimationView) findViewById(R.id.six_animation);
        mSevenAnimation = (LottieAnimationView) findViewById(R.id.seven_animation);
        mEightAnimation = (LottieAnimationView) findViewById(R.id.eight_animation);
        mNineAnimation = (LottieAnimationView) findViewById(R.id.nine_animation);
        mTenAnimation = (LottieAnimationView) findViewById(R.id.ten_animation);
    }
}
