package com.example.administrator.myapplication.courview.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by wangbs on 16/6/21.
 * 1-4年;4-8月;8-12周;12-16天;
 */
public class MoreScreenView extends View {
    private static final String TAG = "CaloriesWeekGraph";
    private float density;
    private Paint bodyLinePaint = new Paint();
    private Paint bodyDotPaint = new Paint();
    private Paint textPaint = new Paint();
    private Paint bodyPaint = new Paint();
    private Path bodyPath=new Path();
    public MoreScreenView(Context context) {
        super(context);
        init(context);
    }

    public MoreScreenView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MoreScreenView(Context context, AttributeSet attrs, int defStyleAttr) {
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

        bodyPaint.setColor(Color.parseColor("#c6f6eb"));
        bodyPaint.setAntiAlias(true);
        bodyPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        graphDraw(canvas);
    }
    private void graphDraw(Canvas canvas) {
        canvas.drawCircle(300, 500, 30, bodyDotPaint);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        /** 处理单点、多点触摸 **/
        switch (event.getAction()) {
            // 单点触摸
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "单点down");
                break;
            case MotionEvent.ACTION_UP:
                break;
            // 多点触摸
            case MotionEvent.ACTION_POINTER_DOWN:
                Log.e(TAG, "多点down");
                break;
            case MotionEvent.ACTION_MOVE:
                float moveX = event.getX();
                float moveY = event.getY();
                Log.e(TAG, "移动" + ":moveX:" + moveX + ":moveY" + moveY);
                break;
            case MotionEvent.ACTION_POINTER_UP:
                Log.i(TAG, "多点up");
                break;
        }
        return true;
    }
}
