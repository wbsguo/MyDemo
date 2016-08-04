package com.example.administrator.myapplication.activity.effert;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.courview.effert.WheelView;
import com.example.administrator.myapplication.util.ViewUtil;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangbs on 16/8/4.
 */
public class WheelViewActivity extends Activity {
    @Bind(R.id.wheel_button)
    Button wheelButton;
    @Bind(R.id.layout)
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel_view);
        ButterKnife.bind(this);
        initData();
    }

    @OnClick(R.id.wheel_button)
    public void onClick() {
        showPicker(2,2);
    }
    private String[] hourArray, minusArray;
    private void initData() {
        hourArray = getResources().getStringArray(R.array.picker_hours);
        minusArray = getResources().getStringArray(R.array.picker_minus);
    }
    private void showPicker(int hourPosition, int minPosition) {
        View outerView = LayoutInflater.from(this).inflate(R.layout.wheel_time_layout, null);
        final WheelView wv = (WheelView) outerView.findViewById(R.id.wheel_hour);
        final WheelView wheel_minus = (WheelView) outerView.findViewById(R.id.wheel_minus);
        final TextView set_cancel = (TextView) outerView.findViewById(R.id.set_cancel);
        final TextView remind_save = (TextView) outerView.findViewById(R.id.remind_save);
        wv.setOffset(1);
        wheel_minus.setOffset(1);

        wv.setItems(Arrays.asList(hourArray));
        wheel_minus.setItems(Arrays.asList(minusArray));
        wv.setSeletion(hourPosition);
        wheel_minus.setSeletion(minPosition);
        wv.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                if (!TextUtils.isEmpty(item)) {
                }
                super.onSelected(selectedIndex, item);
            }
        });
        wheel_minus.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                if (!TextUtils.isEmpty(item)) {
                }
                super.onSelected(selectedIndex, item);
            }
        });
        final PopupWindow popupWindow = new PopupWindow(outerView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        //popu以为响应相应的触摸事件
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable(getResources()));
        popupWindow.setAnimationStyle(android.R.style.Animation_InputMethod);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
            }
        });
        set_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        remind_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

            }
        });
        computeLocation(popupWindow);
    }

    private void computeLocation(PopupWindow popupWindow) {
        int y = 0;
        int naHeight = 0;
        if (ViewUtil.getInstance().checkDeviceHasNavigationBar(this)) {//有底部导航栏
            naHeight = ViewUtil.getInstance().getNavigationBarHeight(this);
            y += naHeight;
        }
        popupWindow.showAtLocation(layout, Gravity.BOTTOM, 0, y);
    }
}
