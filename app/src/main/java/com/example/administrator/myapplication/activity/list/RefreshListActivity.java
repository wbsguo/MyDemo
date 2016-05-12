package com.example.administrator.myapplication.activity.list;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.BaseActivity;
import com.example.administrator.myapplication.adapter.ListAdapterTest;
import com.example.administrator.myapplication.courview.list.pull.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangbs on 16/4/6.
 */
public class RefreshListActivity extends BaseActivity implements PullToRefreshLayout.OnRefreshListener {
    private ListView list_test;
    private PullToRefreshLayout refresh_view;
    private List<String> datas = new ArrayList<String>();
    private ListAdapterTest adapterTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_list);
        findUI();
        getDatas();
        initView();
    }

    private void findUI() {
        refresh_view = (PullToRefreshLayout) findViewById(R.id.refresh_view);
        list_test = (ListView) findViewById(R.id.list_test);
        refresh_view.setOnRefreshListener(this);
    }

    private void getDatas() {
        for (int i = 0; i < 20; i++) {
            datas.add("测试哦" + i);
        }
    }

    private void initView() {
        adapterTest = new ListAdapterTest(datas, this);
        list_test.setAdapter(adapterTest);
    }


    @Override
    public void onRefresh(final PullToRefreshLayout pullToRefreshLayout) {
        // TODO Auto-generated method stub
        pullToRefreshLayout.postDelayed(new Runnable() {

            @Override
            public void run() {
                pullToRefreshLayout.refreshFinish(PullToRefreshLayout.SUCCEED);
                Toast.makeText(RefreshListActivity.this, "上拉刷新成功", Toast.LENGTH_SHORT).show();
            }
        }, 2000);
    }

    @Override
    public void onLoadMore(final PullToRefreshLayout pullToRefreshLayout) {
        // TODO Auto-generated method stub
        pullToRefreshLayout.postDelayed(new Runnable() {

            @Override
            public void run() {
                pullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.SUCCEED);
                Toast.makeText(RefreshListActivity.this, "下拉加载成功", Toast.LENGTH_SHORT).show();
            }
        }, 2000);
    }
}
