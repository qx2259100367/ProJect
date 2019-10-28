package com.example.wanandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.wanandroid.base.BaseActivity;
import com.example.wanandroid.bean.RegisterBean;
import com.example.wanandroid.presenter.RegisPresenter;
import com.example.wanandroid.util.ToastUtil;
import com.example.wanandroid.view.RegisterView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<RegisPresenter> implements RegisterView{

    @BindView(R.id.regis_tool)
    ImageView mRegisTool;
    @BindView(R.id.regis_name)
    EditText mRegisName;
    @BindView(R.id.regis_pwd)
    EditText mRegisPwd;
    @BindView(R.id.regis_pwds)
    EditText mRegisPwds;
    @BindView(R.id.regis_re)
    Button mRegisRe;
    @Override
    protected RegisPresenter initPresenter() {
        return new RegisPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @OnClick(R.id.regis_re)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.regis_re:
                String name = mRegisName.getText().toString();
                String pwd = mRegisPwd.getText().toString();
                String pwds = mRegisPwds.getText().toString();
                if (!TextUtils.isEmpty(name)){
                    if (!TextUtils.isEmpty(pwd)){
                        if (pwd.equals(pwds)){
                            mPresenter.loadData(name,pwd,pwds);
                        }else {
                            ToastUtil.showLong("密码不一致");
                        }
                    }else {
                        ToastUtil.showLong("请输入密码");
                    }
                }else {
                    ToastUtil.showLong("请输入用户名");
                }
                break;
        }
    }

    @Override
    public void onSuccess(RegisterBean registerBean) {
        int errorCode = registerBean.getErrorCode();
        if (errorCode == 0){
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        }else{
            Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailed(String str) {
        ToastUtil.showLong(str);
    }
}
