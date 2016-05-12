package com.example.administrator.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.administrator.myapplication.R;

import butterknife.ButterKnife;

/**
 * Created by wangbs on 16/5/12.
 */
public class TestActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
