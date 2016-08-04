package com.example.administrator.myapplication.activity.myview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.courview.customview.MyTextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangbs on 16/6/24.
 */
public class MyTextActivity extends Activity {
    @Bind(R.id.buttont)
    Button buttont;
    @Bind(R.id.test)
    TextView test;
    @Bind(R.id.test2)
    TextView test2;
    @Bind(R.id.test3)
    TextView test3;
    @Bind(R.id.test4)
    TextView test4;
    @Bind(R.id.test5)
    TextView test5;
    @Bind(R.id.test6)
    TextView test6;
    @Bind(R.id.test7)
    TextView test7;
    @Bind(R.id.test8)
    TextView test8;
    @Bind(R.id.test9)
    TextView test9;
    @Bind(R.id.test10)
    TextView test10;
    @Bind(R.id.test11)
    TextView test11;
    @Bind(R.id.more_position_view)
    MyTextView morePositionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mytext);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttont)
    public void onClick() {
        Log.e("ss", "test:" + "width:" + test.getWidth() + "width2:" + test2.getWidth() + "width3:" + test3.getWidth() + "width4:" + test4.getWidth()
                + "width5:" + test5.getWidth() + "width6:" + test6.getWidth() + "width7:" + test7.getWidth() + "width8:" + test8.getWidth()+ "width9:" + test9.getWidth());
        Log.e("dd","test10:"+test10.getHeight()+"test11:"+test11.getHeight());
    }
}
