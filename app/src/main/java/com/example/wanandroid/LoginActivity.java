package com.example.wanandroid;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.wanandroid.Fragment.mainfragment;
import com.example.wanandroid.base.BaseActivity;
import com.example.wanandroid.bean.LoginBean;
import com.example.wanandroid.presenter.LoginPresenter;
import com.example.wanandroid.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView{

    @BindView(R.id.log_tool)
    ImageView mLogTool;
    @BindView(R.id.log_name)
    EditText mLogName;
    @BindView(R.id.log_pwd)
    EditText mLogPwd;
    @BindView(R.id.log_deng)
    Button mLogDeng;
    @BindView(R.id.log_zhu)
    Button mLogZhu;
    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.log_deng, R.id.log_zhu})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.log_deng:
                String name = mLogName.getText().toString();
                String pwd = mLogPwd.getText().toString();
                if (!TextUtils.isEmpty(name)){
                    if (!TextUtils.isEmpty(pwd)){
                        mPresenter.loadData(name,pwd);
                    }else {
                        Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.log_zhu:
               startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
        }
    }

    @Override
    public void onSuccess(LoginBean loginBean){
        int errorCode = loginBean.getErrorCode();
        if (errorCode == 0){
            Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, mainfragment.class));
        }else{
            Toast.makeText(this, "用户名或密码不正确，或先注册", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailed(String str){

    }
}
