package com.example.administrator.myapplication.activity.myview;

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
 * Created by wangbs on 16/6/21.
 */
public class MyCustomViewActivity extends Activity {
    @Bind(R.id.button1)
    Button button1;
    @Bind(R.id.button2)
    Button button2;
    @Bind(R.id.button3)
    Button button3;
    @Bind(R.id.button4)
    Button button4;
    @Bind(R.id.button5)
    Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button1, R.id.button2,R.id.button3,R.id.button4,R.id.button5})
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.button1:
                intent = new Intent(MyCustomViewActivity.this, MoreScreenActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(MyCustomViewActivity.this, MorePositionActivity.class);
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(MyCustomViewActivity.this, MyScrollViewActivity.class);
                startActivity(intent);
                break;
            case R.id.button4:
                intent = new Intent(MyCustomViewActivity.this, MyDrawTestActivity.class);
                startActivity(intent);
                break;
            case R.id.button5:
                intent = new Intent(MyCustomViewActivity.this, MyTextActivity.class);
                startActivity(intent);
                break;
        }
    }
}
