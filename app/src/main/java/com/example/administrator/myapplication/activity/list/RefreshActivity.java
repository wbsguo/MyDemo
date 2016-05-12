package com.example.administrator.myapplication.activity.list;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.SearchVideosAdapter;
import com.example.administrator.myapplication.courview.list.pull.PullToRefreshView;
import com.example.administrator.myapplication.model.VideoDetailBean;

import java.util.ArrayList;


public class RefreshActivity extends Activity implements
        PullToRefreshView.OnHeaderRefreshListener,PullToRefreshView.OnFooterRefreshListener{
    private PullToRefreshView pullRefresh;
    //	GridView search_layout_gv_result;
    private ListView listview;
    SearchVideosAdapter adapter;
    ArrayList<VideoDetailBean> videoDetailBeans=new ArrayList<VideoDetailBean>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        findUI();
    }
    private void findUI(){
        pullRefresh = (PullToRefreshView) findViewById(R.id.pull_refresh);
        pullRefresh.setOnHeaderRefreshListener(this);
        pullRefresh.setOnFooterRefreshListener(this);
        listview = (ListView) findViewById(R.id.listview);
        for(int i=0;i<2;i++){
            VideoDetailBean videoDetailBean=new VideoDetailBean();
            videoDetailBean.setmContent("我们"+1);
            videoDetailBeans.add(videoDetailBean);
        }
        adapter=new SearchVideosAdapter(this, videoDetailBeans);
        heardView();
        listview.setAdapter(adapter);
    }
    private View heardView;
    private void heardView(){
        heardView= LayoutInflater.from(this).inflate(R.layout.refrsh_heard, null);
        listview.addHeaderView(heardView);
    }
    @Override
    public void onFooterRefresh(PullToRefreshView view) {
        // TODO Auto-generated method stub
        view.postDelayed(new Runnable() {

            @Override
            public void run() {
                pullRefresh.onFooterRefreshComplete();
                videoDetailBeans.clear();
                adapter.setDatas(videoDetailBeans);
                adapter.notifyDataSetChanged();
            }
        }, 200);
    }

    @Override
    public void onHeaderRefresh(PullToRefreshView view) {
        view.postDelayed(new Runnable() {

            @Override
            public void run() {
                pullRefresh.onHeaderRefreshComplete();
            }
        }, 200);
    }
}
