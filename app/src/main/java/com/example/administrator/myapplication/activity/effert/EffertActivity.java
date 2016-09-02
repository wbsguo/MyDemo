package com.example.administrator.myapplication.activity.effert;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.myapplication.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangbs on 16/8/4.
 */
public class EffertActivity extends Activity {
    @Bind(R.id.button1)
    Button button1;
    @Bind(R.id.button2)
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effert);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button1, R.id.button2})
    public void onClick(View view) {
        Intent intent=null;
        switch (view.getId()) {
            case R.id.button1:
                intent=new Intent(EffertActivity.this,WheelViewActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent=new Intent(EffertActivity.this,SearchActivity.class);
                startActivity(intent);
                break;
        }
    }
}
