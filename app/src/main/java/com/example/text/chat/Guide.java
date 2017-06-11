package com.example.text.chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.text.chat.LogUtil.LogUtil;
import com.example.text.chat.adapter.AdapterGuideViewPager;

import java.util.ArrayList;
import java.util.List;

public class Guide extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private ViewPager viewPager;
    private AdapterGuideViewPager adapterGuideViewPager;
    private ImageView imageView[] = new ImageView[3];
    private int[] indicatorDotIds={R.id.iv_indicator_dot1,R.id.iv_indicator_dot2,R.id.iv_indicator_dot3};
    private List<View> viewList;
    private Button btnToMain;

    private static final String TAG = "Guide";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guide);
        LogUtil.d(TAG,"引导界面");
        initViews();
    }
    //加载布局
    private void initViews(){
       final LayoutInflater inflater = LayoutInflater.from(this);
        viewList = new ArrayList<>();
        viewList.add(inflater.inflate(R.layout.guide_page1,null));
        viewList.add(inflater.inflate(R.layout.guide_page2,null));
        viewList.add(inflater.inflate(R.layout.guide_page3,null));

        //得到imageView的控件id
        for (int i = 0;i<indicatorDotIds.length;i++){
            imageView[i] = (ImageView) findViewById(indicatorDotIds[i]);
        }
        adapterGuideViewPager = new AdapterGuideViewPager(this,viewList);
        viewPager = (ViewPager) findViewById(R.id.vp_guide);
        viewPager.setAdapter(adapterGuideViewPager);
        viewPager.addOnPageChangeListener(this);

        btnToMain = (Button)(viewList.get(2)).findViewById(R.id.btn_to_main);
        btnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guide.this,LoginOrRegister.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < indicatorDotIds.length; i++) {
            if (i != position) {
                imageView[i].setImageResource(R.drawable.unselected);
            } else {
                imageView[i].setImageResource(R.drawable.selected);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
