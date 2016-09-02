package com.example.administrator.myapplication.activity.effert;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.LocalSearchAdapter;
import com.example.administrator.myapplication.model.LocalBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by wangbs on 16/8/8.
 */
public class SearchActivity extends Activity {
    @Bind(R.id.recycleview_locals)
    RecyclerView recycleviewLocals;
    private List<LocalBean> locals=new ArrayList<>();
    private LocalSearchAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        viewList();
        getData();
    }
    private void getData(){
        for(int i=0;i<20;i++){
            LocalBean localBean=new LocalBean();
            localBean.setLocalName("我们设置:"+i);
            locals.add(localBean);
        }
        flashView(locals);
    }
    private void viewList() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycleviewLocals.setLayoutManager(layoutManager);
        adapter = new LocalSearchAdapter(this, locals);
        recycleviewLocals.setAdapter(adapter);
    }
    private void flashView(List<LocalBean> locals) {
        adapter.setDatas(locals);
        adapter.notifyDataSetChanged();
    }
}
