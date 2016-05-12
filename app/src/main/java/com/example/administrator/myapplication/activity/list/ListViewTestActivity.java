package com.example.administrator.myapplication.activity.list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangbs on 16/4/6.
 */
public class ListViewTestActivity extends BaseActivity {
    @Bind(R.id.button1)
    Button button1;
    @Bind(R.id.button2)
    Button button2;
    @Bind(R.id.button3)
    Button button3;
    @Bind(R.id.button4)
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_test);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    private void initView() {

    }

    @OnClick({R.id.button1, R.id.button2,R.id.button3,R.id.button4})
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.button1:
                intent = new Intent(ListViewTestActivity.this, RefreshScrolloListViewActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(ListViewTestActivity.this, RefreshListActivity.class);
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(ListViewTestActivity.this, RefreshGridActivity.class);
                startActivity(intent);
                break;
            case R.id.button4:
                intent = new Intent(ListViewTestActivity.this, RefreshActivity.class);
                startActivity(intent);
                break;
        }
    }
}
