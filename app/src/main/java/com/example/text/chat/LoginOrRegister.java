package com.example.text.chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;

import com.example.text.chat.LogUtil.LogUtil;

public class LoginOrRegister extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "LoginOrRegister";

    private TabHost tabHost;
    private Button btnLogin;
    private EditText etLoginUsername,etLoginPassword;
    private Button btnRegister;
    private EditText etRegisterUsername,etRegisterPassword,etInsurePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_or_register);
        LogUtil.d(TAG,"登入界面");
        initViews();
    }
    private void initViews(){
        //初始化控件
        tabHost = (TabHost) findViewById(R.id.tabHost);

        //登录
        btnLogin = (Button) findViewById(R.id.btn_login);
        etLoginUsername = (EditText) findViewById(R.id.et_login_username);
        etLoginPassword = (EditText) findViewById(R.id.et_login_password);

        //注册
        btnRegister = (Button) findViewById(R.id.btn_register);
        etRegisterUsername = (EditText) findViewById(R.id.et_register_username);
        etRegisterPassword = (EditText) findViewById(R.id.et_register_password);
        etInsurePassword = (EditText) findViewById(R.id.et_insure_password);

        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("Login").setIndicator("Login").setContent(R.id.layout_login));
        tabHost.addTab(tabHost.newTabSpec("Register").setIndicator("Register").setContent(R.id.layout_register));

        //注册监听
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.btn_login: {
               Intent intent = new Intent(this, MainActivity.class);
               startActivity(intent);
               break;
           }
           case R.id.btn_register:{
               Intent intent = new Intent(this,MainActivity.class);
               startActivity(intent);
               break;
           }
           default:
               break;

       }
    }
}
