package com.example.administrator.myapplication.courview.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import com.example.administrator.myapplication.util.ViewUtil;

/**
 * Created by wangbs on 16/6/24.
 */
public class MyTextView extends View{
    private static final String TAG="MyTextView";
    private TextPaint textPaint=new TextPaint();
    private Paint paint=new Paint();
    private float textX=300,textY=300;
    public MyTextView(Context context) {
        super(context);
        init(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private void init(Context context){
        DisplayMetrics displayMetrics=context.getResources().getDisplayMetrics();
        float density =displayMetrics.density;
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAntiAlias(true);
        float sp= ViewUtil.getInstance().dp2pxFloat(context,"sp",16);
        textPaint.setTextSize(sp);

        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint.FontMetrics fontMetrics=textPaint.getFontMetrics();
        Log.e(TAG,"top:"+fontMetrics.top+"buttom:"+fontMetrics.bottom+"descent:"+fontMetrics.descent+"ascent:"+fontMetrics.ascent+"loading:"+fontMetrics.leading);
        canvas.drawText("目标60kg",textX,textY,textPaint);
        canvas.drawLine(textX+100,textY+fontMetrics.top,textX+300,textY+fontMetrics.top,paint);
        canvas.drawLine(textX+100,textY+fontMetrics.bottom,textX+300,textY+fontMetrics.bottom,paint);
        canvas.drawLine(textX+100,textY+fontMetrics.descent,textX+300,textY+fontMetrics.descent,paint);
    }
}
