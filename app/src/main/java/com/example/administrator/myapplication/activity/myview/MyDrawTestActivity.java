package com.example.administrator.myapplication.activity.myview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.administrator.myapplication.R;

/**
 * Created by wangbs on 16/6/22.
 */
public class MyDrawTestActivity extends Activity{
    private static final String TAG="MyDrawTestActivity";
    private LinearLayout add_view;
    private int scrrenWidth,scrrenHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_test);
        findView();
        init();
        initView();
    }
    private void init(){
        scrrenWidth=getResources().getDisplayMetrics().widthPixels;
        scrrenHeight=getResources().getDisplayMetrics().heightPixels;
        Log.e(TAG,"scrrenWidth:"+scrrenWidth+":scrrenHeight:"+scrrenHeight);
    }
    private void findView(){
        add_view=(LinearLayout)findViewById(R.id.add_view);
    }
    private void initView(){
        addView();
    }
    private void addView(){
        childView(0);
    }
    private void childView(final int i) {
        View childView = getLayoutInflater().inflate(R.layout.draw_child_item, null);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
                , LinearLayout.LayoutParams.MATCH_PARENT);
        params.width=scrrenWidth*2;
        params.height=scrrenHeight;
        add_view.addView(childView, i,params);
    }
}
