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
 * 多点触摸
 */
public class MorePositionView extends View{
	private static final String TAG = "MorePositionView";
	private float density;
	private int widthPixels,heightPixels;
	private Paint paint = new Paint();
	// 放大比例
	private float rate = 16, oldRate = 16;
	private boolean isPointer = false;
	private boolean isScaleFirst = false;
	// 记录第一次触屏时线段的距离
	private float oldLineDistance;
	public MorePositionView(Context context) {
		super(context);
		init(context);
	}

	public MorePositionView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public MorePositionView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context);
	}

	/**
	 * 负责设置View的大小和位置
	 */
	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
							int bottom) {
		Log.e(TAG, "onLayout");
		super.onLayout(changed, left, top, right, bottom);
	}
	private void init(Context context) {
		DisplayMetrics displayMetrics=context.getResources().getDisplayMetrics();
		density =displayMetrics.density;
		widthPixels=displayMetrics.widthPixels;
		heightPixels=displayMetrics.heightPixels;
		Log.e(TAG,"widthPixels:"+widthPixels+":heightPixels:"+heightPixels+":density:"+density);
		paint.setColor(Color.parseColor("#45a599"));
		paint.setAntiAlias(true);
		paint.setStyle(Paint.Style.FILL);
		paint.setTextAlign(Paint.Align.CENTER);
	}
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Log.e(TAG,"绘图宽度:"+getWidth()+"绘图高度:"+getHeight());
		canvas.drawCircle(300,500,30*rate,paint);
	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int width = widthPixels*5;
		int height = heightPixels;
		setMeasuredDimension(width, height);
	}
	/*@Override
	public boolean onTouchEvent(MotionEvent event) {
		int pointerCount = event.getPointerCount();
		Log.e(TAG,"pointerCount"+pointerCount);
		Log.e(TAG,"DrawTestView-onTouch");
		*//** 处理单点、多点触摸 **//*
		switch (event.getAction() & MotionEvent.ACTION_MASK) {
			case MotionEvent.ACTION_DOWN:
				Log.e(TAG, "单点down");
				break;
			case MotionEvent.ACTION_UP:
				statueInit();
				break;
			case MotionEvent.ACTION_POINTER_DOWN:
				isPointer = true;
				Log.e(TAG, "多点down");
				break;
			case MotionEvent.ACTION_MOVE:
				morePositionMove(event);
				break;
			case MotionEvent.ACTION_POINTER_UP:
				Log.i(TAG, "多点up");
				statueInit();
				break;
			case MotionEvent.ACTION_CANCEL:
				statueInit();
				break;
		}
		return true;
	}*/
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.e(TAG,"DrawTestView-onTouch");
		int pointerCount = event.getPointerCount();
		Log.e(TAG,"pointerCount"+pointerCount);
		if(pointerCount==1){
			Log.e(TAG, "单点down");
			isPointer=false;
		}else if(pointerCount==2){
			isPointer=true;
		}
		/** 处理单点、多点触摸 **/
		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				Log.i(TAG, "单点down");
				break;
			case MotionEvent.ACTION_UP:
				Log.i(TAG, "单点up");
				statueInit();
				break;
			case MotionEvent.ACTION_POINTER_DOWN:
				Log.e(TAG, "多点down");
				break;
			case MotionEvent.ACTION_MOVE:
				morePositionMove(event);
				break;
			case MotionEvent.ACTION_POINTER_UP:
				Log.i(TAG, "多点up");
				statueInit();
				break;
			case MotionEvent.ACTION_CANCEL:
				Log.i(TAG, "取消");
				statueInit();
				break;
		}
		return true;
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
			Log.e(TAG, "多点move");
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
					Log.e(TAG, "比例:" + rate);
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
	}
}
