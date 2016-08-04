package com.example.administrator.myapplication.activity.sys;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ScrollView;

import com.example.administrator.myapplication.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by wangbs on 16/6/24.
 */
public class ScrlooTestActivity extends Activity {
    @Bind(R.id.srcoll_test)
    ScrollView srcollTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrool);
        ButterKnife.bind(this);
    }
    private void dscript(){
        //滚动到最右
        srcollTest.fullScroll(ScrollView.FOCUS_RIGHT);
    }
}
