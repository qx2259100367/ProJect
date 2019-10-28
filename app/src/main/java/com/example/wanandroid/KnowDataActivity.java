package com.example.wanandroid;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wanandroid.Adaper.KnowTabAdaper;
import com.example.wanandroid.Fragment.KnowDataFragment;
import com.example.wanandroid.bean.KnowBean;

import java.util.ArrayList;
import java.util.List;

public class KnowDataActivity extends AppCompatActivity {

    private ImageView mKnowImg;
    private Toolbar mKnowToolbar;
    private TabLayout mKnowTab;
    private ViewPager mKnowVp;
    private ArrayList<Fragment> fs;
    private KnowDataFragment knowDataFragment;
    private int id;
    private Bundle bundle;
    private KnowTabAdaper tabAdaper;
    /**
     * WanAndroid
     */
    private TextView mKnowDataName;
    private String name1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know_data);
        initView();
        initData();
    }


    private void initData() {
        List<KnowBean.DataBean.ChildrenBean> children = (List<KnowBean.DataBean.ChildrenBean>) getIntent().getSerializableExtra("children");
        name1 = getIntent().getStringExtra("name");
        mKnowDataName.setText(name1);
        Log.i("tag", "children" + children.size());
        fs = new ArrayList<>();
        for (int i = 0; i < children.size(); i++) {
            knowDataFragment = new KnowDataFragment();
            id = children.get(i).getId();
            bundle = new Bundle();
            bundle.putString("id", String.valueOf(id));
            knowDataFragment.setArguments(bundle);
            fs.add(knowDataFragment);
        }
        tabAdaper = new KnowTabAdaper(getSupportFragmentManager(), fs,children);
        mKnowVp.setAdapter(tabAdaper);
        mKnowTab.setupWithViewPager(mKnowVp);
    }

    private void initView() {
        mKnowImg = (ImageView) findViewById(R.id.know_img);
        mKnowToolbar = (Toolbar) findViewById(R.id.know_toolbar);
        mKnowTab = (TabLayout) findViewById(R.id.know_tab);
        mKnowVp = (ViewPager) findViewById(R.id.know_vp);
        mKnowToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mKnowDataName = (TextView) findViewById(R.id.know_data_name);
    }
}
