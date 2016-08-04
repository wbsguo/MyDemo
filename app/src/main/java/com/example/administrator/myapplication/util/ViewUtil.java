package com.example.administrator.myapplication.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.ViewConfiguration;

/**
 * Created by wangbs on 16/6/24.
 * dip,sp转换为px
 * 设置固定大小的bitmap
 * 判断底部导航栏是否存在
 * 获取状态栏高度
 * 获取底部导航栏高度
 */
public class ViewUtil {
    private static ViewUtil instance;
    public static ViewUtil getInstance() {
        if (instance == null) {
            instance = new ViewUtil();
        }
        return instance;
    }
    /**
     * dip,sp转换为px
     * @param context
     * @param floatValue
     * @return
     */
    public float dp2pxFloat(Context context, String unitType, float floatValue) {
        if("dip".equals(unitType) || "dp".equals(unitType)){
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, floatValue,
                    context.getResources().getDisplayMetrics());
        }else if("sp".equals(unitType)){
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, floatValue,
                    context.getResources().getDisplayMetrics());
        }else{
            return floatValue;
        }
    }

    /**
     * 设置固定大小的bitmap
     * @param bgimage
     * @param newWidth
     * @param newHeight
     * @return
     */
    public Bitmap zoomImage(Bitmap bgimage, double newWidth,
                            double newHeight) {
        // 获取这个图片的宽和高
        float width = bgimage.getWidth();
        float height = bgimage.getHeight();
        // 创建操作图片用的matrix对象
        Matrix matrix = new Matrix();
        // 计算宽高缩放率
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // 缩放图片动作
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap bitmap = Bitmap.createBitmap(bgimage, 0, 0, (int) width,
                (int) height, matrix, true);
        return bitmap;
    }
    /**
     * 判断底部导航栏是否存在
     */
    public boolean checkDeviceHasNavigationBar(Context activity) {

        //通过判断设备是否有返回键、菜单键(不是虚拟键,是手机屏幕外的按键)来确定是否有navigation bar
        boolean hasMenuKey = ViewConfiguration.get(activity)
                .hasPermanentMenuKey();
        boolean hasBackKey = KeyCharacterMap
                .deviceHasKey(KeyEvent.KEYCODE_BACK);

        if (!hasMenuKey && !hasBackKey) {
            // 做任何你需要做的,这个设备有一个导航栏
            return true;
        }
        return false;
    }

    /**
     * 获取状态栏高度
     */
    public int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }

    /**
     * 获取底部导航栏高度
     */
    public int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }
}
