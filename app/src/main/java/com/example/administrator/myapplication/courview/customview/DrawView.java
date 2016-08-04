package com.example.administrator.myapplication.courview.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by wangbs on 16/6/22.
 */
public class DrawView extends View implements View.OnClickListener{
    private static final String TAG="DrawView";
    private float density;
    private int widthPixels,heightPixels;
    private Paint paint = new Paint();
    // 放大比例
    private float rate = 1, oldRate = 1;
    private boolean isPointer = false;
    private boolean isScaleFirst = false;
    // 记录第一次触屏时线段的距离
    private float oldLineDistance;
    public DrawView(Context context) {
        super(context);
        init(context);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private void init(Context context) {
        DisplayMetrics displayMetrics=context.getResources().getDisplayMetrics();
        density =displayMetrics.density;
        widthPixels=displayMetrics.widthPixels;
        heightPixels=displayMetrics.heightPixels;
        paint.setColor(Color.parseColor("#45a599"));
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        setOnClickListener(this);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = widthPixels;
        int height = heightPixels;
        setMeasuredDimension(width, height);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(300,500,30*rate,paint);
    }
    @Override
	public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG,"DrawView-onTouchEvent");
		int pointerCount = event.getPointerCount();
		Log.e(TAG,"pointerCount"+pointerCount);
		switch (event.getAction() & MotionEvent.ACTION_MASK) {
			case MotionEvent.ACTION_DOWN:
                Constance.flag =-1;
				Log.e(TAG, "单点down");
				break;
			case MotionEvent.ACTION_UP:
                Log.e(TAG,"单点up");
                Constance.flag =-1;
				statueInit();
				break;
			case MotionEvent.ACTION_POINTER_DOWN:
                Log.e(TAG, "多点down");
                Constance.flag =0;
                isPointer = true;
				break;
			case MotionEvent.ACTION_MOVE:
                Log.e(TAG,"单点移动");
                if(pointerCount>1){
                    Constance.flag =0;
                }else{
                    Constance.flag =-1;
                }
				morePositionMove(event);
				break;
			case MotionEvent.ACTION_POINTER_UP:
				Log.e(TAG, "多点up");
                Constance.flag =-1;
				statueInit();
				break;
			case MotionEvent.ACTION_CANCEL:
                Log.e(TAG,"单点取消");
                Constance.flag =-1;
				statueInit();
				break;
		}
		return super.onTouchEvent(event);
	}

    @Override
    public void onClick(View v) {
        Log.e(TAG,"点击");
    }
    /**
     * 状态还原
     */
    private void statueInit(){
        oldRate = rate;
        isScaleFirst = false;
        isPointer=false;
    }
    private void morePositionMove(MotionEvent event){
        // 缩放
        if (isPointer) {
            try {
                float x1 = event.getX(1);
                float x0 = event.getX(0);
                float y1 = event.getY(1);
                float y0 = event.getY(0);
                if (!isScaleFirst) {
                    // 得到第一次触屏时线段的长度
                    oldLineDistance = (float) Math.sqrt(Math
                            .pow(x1 - x0, 2) + Math.pow(y1 - y0, 2));
                    isScaleFirst = true;
                } else {
                    // 得到触屏时线段的长度
                    float newLineDistance = (float) Math.sqrt(Math.pow(x1- x0, 2)
                            + Math.pow(y1 - y0, 2));
                    // 获取本次的缩放比例
                    rate = oldRate * newLineDistance / oldLineDistance;
                    postInvalidate();
//                    Log.e(TAG, "比例:" + rate);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }
}
