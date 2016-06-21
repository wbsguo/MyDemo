package com.example.administrator.myapplication.courview.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by wangbs on 16/6/21.
 * 1-4年;4-8月;8-12周;12-16天;
 */
public class CaloriesWeekGraph extends View{
    private static final String TAG="CaloriesWeekGraph";
    private float density;
    private Paint bodyLinePaint = new Paint();
    private Paint bodyDotPaint = new Paint();
    private Paint textPaint = new Paint();
    // 记录第一次触屏时线段的距离
    private float oldLineDistance;
    private boolean isScaleFirst = true;
    public CaloriesWeekGraph(Context context) {
        super(context);
        init(context);
    }

    public CaloriesWeekGraph(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CaloriesWeekGraph(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private void init(Context context) {
        density = context.getResources().getDisplayMetrics().density;
        bodyDotPaint.setColor(Color.parseColor("#45a599"));
        bodyDotPaint.setAntiAlias(true);
        bodyDotPaint.setStyle(Paint.Style.FILL);
        bodyDotPaint.setTextAlign(Paint.Align.CENTER);

        bodyLinePaint.setColor(Color.parseColor("#45a599"));
        bodyLinePaint.setAntiAlias(true);
        bodyLinePaint.setStyle(Paint.Style.FILL);
        bodyLinePaint.setTextAlign(Paint.Align.CENTER);
        bodyLinePaint.setStrokeWidth(4.5f * density);

        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(36);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        graphDraw(canvas);
        drawCrosshairsAndText(30,30,0,canvas);
        drawCrosshairsAndText(60,60,1,canvas);
    }
    private void graphDraw(Canvas canvas) {
        canvas.drawCircle(300,500,30,bodyDotPaint);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int pointerCount = event.getPointerCount();
        Log.e(TAG,"pointerCount"+pointerCount);
        if(pointerCount==2){
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    float downX0=event.getX(0);
                    float downY0=event.getY(0);
                    float downX1=event.getX(1);
                    float downY1=event.getY(1);
                    Log.e(TAG,"单点触摸"+":downX0:"+downX0+":downY0"+downY0+":downX1:"+downX1+":downY1:"+downY1);
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    float posintDownX0=event.getX(0);
                    float posintDownY0=event.getY(0);
                    float posintDownX1=event.getX(1);
                    float posintDownY1=event.getY(1);
                    Log.e(TAG,"多点触摸"+":posintDownX0:"+posintDownX0+":posintDownY0"+posintDownY0+":posintDownX1:"+posintDownX1+":posintDownY1:"+posintDownY1);
                    break;
                case MotionEvent.ACTION_MOVE:
                    float moveX0=event.getX(0);
                    float moveY0=event.getY(0);
                    float moveX1=event.getX(1);
                    float moveY1=event.getY(1);
                    Log.e(TAG,"移动"+":moveX0:"+moveX0+":moveY0"+moveY0+":moveX1:"+moveX1+":moveY1:"+moveY1);
                    if (isScaleFirst) {
                        isScaleFirst=false;
                    }
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    Log.i(TAG, "多点up");
                    isScaleFirst = true;
                    break;
                case MotionEvent.ACTION_UP:
                    Log.i(TAG, "单点up");
                    break;
                case MotionEvent.ACTION_CANCEL:
                    Log.i(TAG, "取消触摸");
                    break;
            }
        }
        return true;
    }
    private void drawCrosshairsAndText(int x, int y,int ptr,Canvas canvas) {
        if(ptr==0){
            canvas.drawText("x" + ptr + "=" + x+";"+"y"+ptr+"="+y, 300, 300, textPaint);
        }else if(ptr==1){
            canvas.drawText("x" + ptr + "=" + x+";"+"y"+ptr+"="+y, 300, 600, textPaint);
        }
    }

}
