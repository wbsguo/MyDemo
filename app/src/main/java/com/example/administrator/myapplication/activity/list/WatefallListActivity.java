package com.example.administrator.myapplication.activity.list;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ListView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.WatefallAdapter;
import com.example.administrator.myapplication.model.DuitangInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class WatefallListActivity extends Activity {
    private ListView list_test;
    private WatefallAdapter adapter;
    List<DuitangInfo> duitangs = new ArrayList<DuitangInfo>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watefall_list);
        list_test=(ListView)findViewById(R.id.list);
        getData();
        initView();
    }
    private void initView(){
        adapter=new WatefallAdapter(duitangs,this);
        list_test.setAdapter(adapter);
    }
    public String getDataFromData(String filePath) {
        String data = null;
        File file = null;
        file = new File(filePath);
        InputStream in = null;
        if (!file.exists()) {
            return null;
        }
        try {
            in = new FileInputStream(file);
            byte[] buffer = new byte[in.available()];
            in.read(buffer);
            data = new String(buffer);
        } catch (Exception e) {
            // TODO: handle exception\
            e.printStackTrace();
            return null;
        }finally{
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }
    private void getData(){
        String path = Environment.getExternalStorageDirectory()
                .toString() + "/wolai";
        String json= getDataFromData(path+"/"+"login.txt");
        try {
            if (null != json) {
                JSONObject newsObject = new JSONObject(json);
                JSONArray jsonArray = newsObject.getJSONArray("entries");
                JSONObject jsonObject;
                String str;
                int lon;
                for (int i = 0; i < jsonArray.length(); i++) {
                    ArrayList<String> images = new ArrayList<String>();
                    jsonObject = (JSONObject) jsonArray.get(i);

                    DuitangInfo newsInfo1 = new DuitangInfo();
                    // 获取标题
                    str = jsonObject.get("title").toString();
                    newsInfo1.setMsg(str);
                    // 图片地址
                    str = jsonObject.get("image_url").toString();
                    newsInfo1.setIsrc(str);
                    // 新闻id
                    str = jsonObject.get("id").toString();
                    newsInfo1.setAlbid(str);
                    str = jsonObject.get("alternate_href").toString();
                    newsInfo1.setUrl(str);
                    newsInfo1.setPoint(str);
                    // 图片宽度
                    lon = jsonObject.getInt("image_width");
                    newsInfo1.setWidth(lon);
                    // 图片高度
                    lon = jsonObject.getInt("image_height");
                    newsInfo1.setHeight(lon);
                    // 来源网站
                    str = jsonObject.get("origin_title").toString();
                    newsInfo1.setOrigin(str);
                    //新闻更新时间
                    str = jsonObject.get("updated_at").toString();
                    newsInfo1.setTime(str);
                    //内容图片
                    JSONArray jsonAr = (JSONArray) jsonObject.get("images");
                    for (int j = 0; j < jsonAr.length(); j++) {
                        str = jsonAr.getString(j);
                        images.add(str);
                        System.out.println("str:" + str);
                    }

                    newsInfo1.setImages(images);

                    duitangs.add(newsInfo1);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
