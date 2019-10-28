package com.example.wanandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

public class Main_Data_Activity extends AppCompatActivity {
    private TextView main_name;
    private WebView main_web;
    private Toolbar main_tool;
    private String name;
    private String link;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__data_);
        name = getIntent().getStringExtra("name");
        link = getIntent().getStringExtra("link");
        initView();
        initData();
    }

    private void initData() {
        main_web.loadUrl(link);
        main_web.setWebViewClient(new WebViewClient());
        main_name.setText(name);

    }

    private void initView() {
        main_name = (TextView) findViewById(R.id.main_name);
        main_web = (WebView) findViewById(R.id.main_web);
        main_tool = (Toolbar) findViewById(R.id.main_tool);
        img=(ImageView) findViewById(R.id.main_img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
