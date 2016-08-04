package com.example.administrator.myapplication.activity.effert;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.MainActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangbs on 16/8/4.
 */
public class EffertActivity extends Activity {
    @Bind(R.id.button1)
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effert);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button1)
    public void onClick() {
        Intent intent = new Intent(EffertActivity.this, WheelViewActivity.class);
        startActivity(intent);
    }
}
