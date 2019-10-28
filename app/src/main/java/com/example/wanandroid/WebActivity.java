package com.example.wanandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.http.Url;

public class WebActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mToolName;
    private WebView mWeb;
    private String name;
    private String wed;
    private Toolbar mWebTool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        name = getIntent().getStringExtra("name");
        wed = getIntent().getStringExtra("wed");
        initView();
        initData();
    }

    private void initData() {
        mWeb.loadUrl(wed);
        mWeb.setWebViewClient(new WebViewClient());
        mToolName.setText(name);

    }

    private void initView() {
        mToolName = (TextView) findViewById(R.id.tool_name);
        mWeb = (WebView) findViewById(R.id.web);
        mToolName.setOnClickListener(this);
        mWebTool = (Toolbar) findViewById(R.id.web_tool);
        mWeb.setOnClickListener(this);
        mWebTool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tool_name:
                break;
            case R.id.web:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       menu.add(1,1,1,"分享");
       menu.add(1,2,1,"用系统浏览器打开");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri uri = Uri.parse(wed);
                intent.setData(uri);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
