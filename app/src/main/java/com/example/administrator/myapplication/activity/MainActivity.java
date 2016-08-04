package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.effert.EffertActivity;
import com.example.administrator.myapplication.activity.list.ListViewTestActivity;
import com.example.administrator.myapplication.activity.myview.MyCustomViewActivity;
import com.example.administrator.myapplication.activity.sys.SysTestActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangbs on 16/5/12.
 */
public class MainActivity extends BaseActivity {
    @Bind(R.id.button1)
    Button button1;
    @Bind(R.id.button2)
    Button button2;
    @Bind(R.id.button3)
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.button1,R.id.button2,R.id.button3,R.id.button4})
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.button1:
                intent = new Intent(MainActivity.this, ListViewTestActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(MainActivity.this, MyCustomViewActivity.class);
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(MainActivity.this, SysTestActivity.class);
                startActivity(intent);
                break;
            case R.id.button4:
                intent = new Intent(MainActivity.this, EffertActivity.class);
                startActivity(intent);
                break;
        }
    }
}
