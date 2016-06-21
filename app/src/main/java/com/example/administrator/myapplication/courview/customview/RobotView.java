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
 * 多点触摸
 */
public class RobotView extends View {
	private static final String TAG = "MapView";
	private Paint bodyDotPaint = new Paint();
	private boolean isPointer = false;
	// 放大比例
	private float rate = 1, oldRate = 1;
	// 记录第一次触屏时线段的距离
	private float oldLineDistance;
	private boolean isScaleFirst = true;

	public RobotView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public RobotView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public RobotView(Context context) {
		super(context);
		init();
	}
	private void init() {
		bodyDotPaint.setColor(Color.parseColor("#45a599"));
		bodyDotPaint.setAntiAlias(true);
		bodyDotPaint.setStyle(Paint.Style.FILL);
		bodyDotPaint.setTextAlign(Paint.Align.CENTER);
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		/** 处理单点、多点触摸 **/
		switch (event.getAction() & MotionEvent.ACTION_MASK) {
		// 单点触摸
		case MotionEvent.ACTION_DOWN:
			Log.e(TAG, "单点down");
			break;
		case MotionEvent.ACTION_UP:
			break;
		// 多点触摸
		case MotionEvent.ACTION_POINTER_DOWN:
			isPointer = true;
			Log.e(TAG, "多点down");
			break;
		case MotionEvent.ACTION_MOVE:
			// 缩放
			if (isPointer) {
				Log.e(TAG, "多点move");
				try {
					float x1 = event.getX(1);
					float x0 = event.getX(0);
					float y1 = event.getY(1);
					float y0 = event.getY(0);
					if (isScaleFirst) {
						// 得到第一次触屏时线段的长度
						oldLineDistance = (float) Math.sqrt(Math
								.pow(x1 - x0, 2) + Math.pow(y1 - y0, 2));
						isScaleFirst = false;
					} else {
						// 得到触屏时线段的长度
						float newLineDistance = (float) Math.sqrt(Math.pow(x1- x0, 2)
								+ Math.pow(y1 - y0, 2));
						// 获取本次的缩放比例
						rate = oldRate * newLineDistance / oldLineDistance;
						postInvalidate();
						Log.i(TAG, "比例:" + rate);
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
			break;
		case MotionEvent.ACTION_POINTER_UP:
			Log.i(TAG, "多点up");
			oldRate = rate;
			isScaleFirst = true;
			break;
		}
		return true;
	}
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawCircle(300,500,30*rate,bodyDotPaint);
	}
}
