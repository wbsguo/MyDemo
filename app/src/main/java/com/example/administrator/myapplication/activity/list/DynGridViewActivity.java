package com.example.administrator.myapplication.activity.list;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.GridAdapterTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangbs on 16/6/16.
 */
public class DynGridViewActivity extends Activity{
    private GridView grid_test;
    private GridAdapterTest adapterTest;
    private List<String> datas=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dyn_grid);
        grid_test=(GridView)findViewById(R.id.grid_test);
        getData();
        adapterTest=new GridAdapterTest(datas,this);
        grid_test.setAdapter(adapterTest);
        grid_test.setNumColumns(4);
    }
    private void getData(){
        for(int i=0;i<20;i++){
            datas.add("我们测试"+i);
        }
    }
}
