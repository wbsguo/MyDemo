package com.example.administrator.myapplication.courview.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/**
 * Created by wangbs on 16/6/22.
 * HorizontalScrollView与子view的onTouchEvent冲突的解决办法
 */
public class MyHorizontalScrollView extends HorizontalScrollView {
    private static final String TAG="MyHorizontalScrollView";
    private Context mContext;
    public MyHorizontalScrollView(Context context) {
        super(context);
        mContext = context;
    }

    public MyHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyHorizontalScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG,"MyHorizontalScrollView-onInterceptTouchEvent");
        if (Constance.flag == -1) {
            return super.onInterceptTouchEvent(ev);
        }else{
            return false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.e(TAG,"MyHorizontalScrollView-onTouchEvent");
        return super.onTouchEvent(ev);
    }

}
