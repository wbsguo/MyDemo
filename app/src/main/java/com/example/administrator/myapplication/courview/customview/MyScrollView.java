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
 * 自定义view滑动
 */
public class MyScrollView extends View {
    private static final String TAG = "MyScrollView";
    private float density;
    private int widthPixels,heightPixels;
    private Paint paint = new Paint();
    public MyScrollView(Context context) {
        super(context);
        init(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * 负责设置View的大小和位置
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right,
                            int bottom) {
        Log.e(TAG, "onLayout:"+":changed:"+changed+":left:"+left);
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
        canvas.drawCircle(300,500,30,paint);
        canvas.drawLine(100,100,1000,300,paint);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = widthPixels;
        int height = heightPixels;
        setMeasuredDimension(width, height);
    }
    private float oldX=0;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        /** 处理单点、多点触摸 **/
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                oldX=event.getX();
                Log.e(TAG, "单点down");
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                Log.e(TAG, "多点down");
                break;
            case MotionEvent.ACTION_MOVE:
                float moveX=event.getX();
                int scrollX=(int)(oldX-moveX);
                Log.e(TAG,"MOVE左滑:"+"moveX:"+moveX+":oldX:"+oldX+":scrollX:"+scrollX);
                scrollBy(scrollX,0);
                oldX=moveX;
                break;
            case MotionEvent.ACTION_POINTER_UP:
                Log.i(TAG, "多点up");
                break;
        }
        return true;
    }
    private void scrollDsrcipt(){
        //scrollTo代表的是便宜量,参照点是(0,0),如果要移动(100,100)的话,偏移量=(0,0)-(100,100)=(-100,-100)
        //这么描述比较抽象，举个例子。假设SView调用了scrollTo(-100, -100)，此时SView左上角的坐标是(100, 100)，这时再调用scrollBy(-20, -20)，此时SView的左上角就被绘制到了(120, 120)这个位置。
        //总结一下，scrollTo()是一步到位，而scrollBy()是逐步累加。
    }
}
