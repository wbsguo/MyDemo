package com.example.administrator.myapplication.activity.myview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.courview.customview.MorePositionView;

/**
 * Created by wangbs on 16/6/21.
 */
public class MorePositionActivity extends Activity{
    private MorePositionView more_position_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_position);
        more_position_view=(MorePositionView)findViewById(R.id.more_position_view);
        more_position_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("SSSS","哦你才离开点击");
            }
        });
    }
}
