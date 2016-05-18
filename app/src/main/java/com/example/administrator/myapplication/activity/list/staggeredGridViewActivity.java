package com.example.administrator.myapplication.activity.list;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.StaggerdAdapter;
import com.example.administrator.myapplication.courview.wallfech.StaggeredGridView;
import com.example.administrator.myapplication.model.StaggerdBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangbs on 16/5/18.
 */
public class staggeredGridViewActivity extends Activity{
    private ImageView image;
    private StaggeredGridView staggeredGridView;
    private List<StaggerdBean> staggerdBeans=new ArrayList<>();
    private StaggerdAdapter adapter;
    String url="http://52.192.66.23/data/timages/39/39_0.jpg?1454086351";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggerd_grid);
        staggeredGridView=(StaggeredGridView)findViewById(R.id.staggeredGridView);
        getData();
        initView();
    }
    private void getData(){
        for(int i=0;i<5;i++){
            StaggerdBean staggerdBean=new StaggerdBean();
            staggerdBean.setName("名字"+i);
            staggerdBean.setImageUrl(url);
            if(i==0){
                staggerdBean.setWidth(700);
                staggerdBean.setHeight(1000);
            }else if(i==1){
                staggerdBean.setWidth(500);
                staggerdBean.setHeight(330);
            }else if(i==2){
                staggerdBean.setWidth(500);
                staggerdBean.setHeight(400);
            }else if(i==3){
                staggerdBean.setWidth(300);
                staggerdBean.setHeight(500);
            }else if(i==4){
                staggerdBean.setWidth(650);
                staggerdBean.setHeight(600);
            }
            staggerdBeans.add(staggerdBean);
        }
    }
    private void initView(){
        adapter=new StaggerdAdapter(staggerdBeans,this);
        staggeredGridView.setAdapter(adapter);
    }
}
