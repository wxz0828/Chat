package com.example.text.chat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.example.text.chat.LogUtil.LogUtil;

public class Welcome extends AppCompatActivity {
    private final static int DELAY = 2000;
    private final static int GO_GUIDE = 0;
    private final static int GO_HOME = 1;
    private static final String TAG = "Welcome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        LogUtil.d(TAG,"欢迎界面");
        //全屏
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initLoad();
    }
     //加载布局
    private void initLoad() {
        SharedPreferences sharedPreferences = getSharedPreferences("zzchat",MODE_PRIVATE);
        boolean welcome = sharedPreferences.getBoolean("welcome",true);
        if (!welcome){
           handler.sendEmptyMessageDelayed(GO_HOME,DELAY);
        }else{
            handler.sendEmptyMessageDelayed(GO_GUIDE,DELAY); //DELAY延迟2000毫秒
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("welcome",false);
            editor.apply();
        }
    }
    //跳转到登陆界面
    private void goHome(){
        Intent intent = new Intent(this,LoginOrRegister.class);
        startActivity(intent);
        finish();
    }
    //跳转到引导界面
    private void goGuide(){
       Intent intent = new Intent(this,Guide.class);
        startActivity(intent);
        finish();
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case GO_HOME:
                  goHome();
                    break;
                case GO_GUIDE:
                    goGuide();
                    break;
                default:
                    break;
            }
        }
    };
}
