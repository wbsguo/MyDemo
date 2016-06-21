package com.example.administrator.myapplication.activity.myview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.administrator.myapplication.R;

/**
 * Created by wangbs on 16/6/21.
 */
public class MyViewActivity extends Activity{
    private static final String TAG="MyViewActivity";
    private LinearLayout add_view;
    private int scrrenWidth,scrrenHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myview);
        findView();
        init();
        addView();
    }
    private void init(){
        scrrenWidth=getResources().getDisplayMetrics().widthPixels;
        scrrenHeight=getResources().getDisplayMetrics().heightPixels;
        Log.e(TAG,"scrrenWidth:"+scrrenWidth+":scrrenHeight:"+scrrenHeight);
    }
    private void findView(){
        add_view=(LinearLayout)findViewById(R.id.add_view);
    }
    private void addView(){
        for(int i=0;i<3;i++){
            childView(i);
        }
    }
    private void childView(final int i) {
        View childView = getLayoutInflater().inflate(R.layout.childview_item, null);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
                , LinearLayout.LayoutParams.MATCH_PARENT);
        params.width=scrrenWidth;
        params.height=scrrenHeight;
        add_view.addView(childView, i,params);
    }
}
