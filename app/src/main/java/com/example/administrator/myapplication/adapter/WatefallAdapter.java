package com.example.administrator.myapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.courview.wallfech.FitTextView;
import com.example.administrator.myapplication.courview.wallfech.ScaleImageView;
import com.example.administrator.myapplication.model.DuitangInfo;

import java.util.List;


@SuppressLint("NewApi")
public class WatefallAdapter extends BaseAdapter {
    private List<DuitangInfo> datas;
    private Context ctx;

    public WatefallAdapter(List<DuitangInfo> datas, Context ctx) {
        this.datas = datas;
        this.ctx = ctx;
    }

    public void setDatas(List<DuitangInfo> datas) {
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(ctx).inflate(
                    R.layout.test_list_item, null);
//            holder.newWeb = (RelativeLayout) convertView.findViewById(R.id.new_web);
            holder.imageView = (ScaleImageView) convertView
                    .findViewById(R.id.news_pic);
//            holder.contentView = (FitTextView) convertView
//                    .findViewById(R.id.news_title);
//            holder.pointView = (TextView) convertView
//                    .findViewById(R.id.news_point);
//            holder.originView = (TextView) convertView
//                    .findViewById(R.id.news_origin);
//            holder.level = (TextView) convertView.findViewById(R.id.level);
//            holder.prAd= (LinearLayout) convertView.findViewById(R.id.ad_pr);
            holder.text_name = (FitTextView) convertView.findViewById(R.id.text_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        DuitangInfo duitangInfo=datas.get(position);
//        holder.originView.setText(duitangInfo.getOrigin());
        holder.imageView.setImageWidth(duitangInfo.getWidth());
        holder.imageView.setImageHeight(duitangInfo.getHeight());
//        holder.contentView.setMText(duitangInfo.getMsg());
        holder.text_name.setMText(duitangInfo.getMsg());
        holder.text_name.invalidate();
        Glide.with(ctx).load(duitangInfo.getIsrc()).placeholder(new ColorDrawable(Color.WHITE)).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imageView);
        return convertView;
    }

    private class ViewHolder {
        TextView level;
        ScaleImageView imageView;
        FitTextView contentView;
        TextView pointView;
        TextView originView;
        FitTextView text_name;
        RelativeLayout newWeb;
        LinearLayout prAd;
    }
}
