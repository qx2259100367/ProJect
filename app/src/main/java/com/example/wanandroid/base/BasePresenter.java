package com.example.wanandroid.base;


import java.util.ArrayList;

/**
 * Created by liguixiao on 2019/9/24.
 */

public abstract class BasePresenter<V extends BaseView> {
    public V mView;
    private ArrayList<BaseModel> mModels;

    public BasePresenter(){
        initModel();
    }

    protected abstract void initModel();

    public void bindView(V view) {
        this.mView = view;
    }

    public void destory(){
        //打断V和P关系
        mView = null;
        //取消网络请求和订阅关系 -- MM
        if (mModels != null && mModels.size()>0){
            for (int i = 0; i < mModels.size(); i++) {
                mModels.get(i).destory();
            }
            mModels.clear();
            mModels = null;
        }
    };


    public void addModel(BaseModel model) {
        if (mModels  == null){
            mModels = new ArrayList<>();
        }

        mModels.add(model);
    }
}
