package com.example.wanandroid.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.wanandroid.Adaper.HomeRecAdaper;
import com.example.wanandroid.Adaper.KnowDataAdaper;
import com.example.wanandroid.R;
import com.example.wanandroid.base.BaseFragment;
import com.example.wanandroid.bean.HomeBean;
import com.example.wanandroid.bean.KnowDataBean;
import com.example.wanandroid.presenter.HomePresenter;
import com.example.wanandroid.presenter.KnowDataPresenter;
import com.example.wanandroid.view.HomeView;
import com.example.wanandroid.view.KnowDataView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 裘翔 on 2019/10/27.
 */

public class KnowDataFragment extends BaseFragment<KnowDataView,KnowDataPresenter> implements KnowDataView{
    @BindView(R.id.know_data_rec)
    RecyclerView mKnowDataRec;
    private int page = 0;
    private ArrayList<KnowDataBean.DataBean.DatasBean> beans;
    private KnowDataAdaper knowDataAdaper;


    @Override
    protected KnowDataPresenter initPresenter() {
        return new KnowDataPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.know_data_fragment;
    }

    @Override
    public void initData() {
        String id = (String) getArguments().get("id");
        mPresenter.loadData(page,Integer.parseInt(id));

    }

    @Override
    public void initView() {
        mKnowDataRec.setLayoutManager(new LinearLayoutManager(getContext()));
        beans = new ArrayList<>();
        knowDataAdaper = new KnowDataAdaper(getContext(), beans);
        mKnowDataRec.setAdapter(knowDataAdaper);
    }

    @Override
    public void onSuccess(KnowDataBean knowDataBean) {
          beans.addAll(knowDataBean.getData().getDatas());
          knowDataAdaper.notifyDataSetChanged();
    }

    @Override
    public void onFailed(String str) {
        Toast.makeText(getContext(), "str", Toast.LENGTH_SHORT).show();
    }
}
