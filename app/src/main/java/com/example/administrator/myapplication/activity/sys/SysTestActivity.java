package com.example.administrator.myapplication.activity.sys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.administrator.myapplication.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangbs on 16/6/24.
 */
public class SysTestActivity extends Activity {
    @Bind(R.id.button1)
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sys);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button1)
    public void onClick() {
        Intent intent=new Intent(SysTestActivity.this,ScrlooTestActivity.class);
        startActivity(intent);
    }
}
