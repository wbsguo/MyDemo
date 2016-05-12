package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by wangbs on 16/3/30.
 */
public class TestAdapter extends BaseAdapter {
    private Context ctx;
    private List<String> datas;

    public TestAdapter(Context ctx, List<String> datas) {
        this.ctx = ctx;
        this.datas = datas;
    }

    public void setDatas(List<String> datas) {
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
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(ctx).inflate(
                    R.layout.adapter_test, null);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.text1.setText("");
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.text1)
        TextView text1;
        @Bind(R.id.image)
        ImageView image;
        @Bind(R.id.button)
        Button button;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
