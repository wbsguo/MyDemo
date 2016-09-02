package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.model.LocalBean;

import java.util.List;

public class LocalSearchAdapter extends RecyclerView.Adapter<LocalSearchAdapter.MyViewHolder>{

    private List<LocalBean> datas;
    private Context context;
    public LocalSearchAdapter(Context context, List<LocalBean> datas) {
        this.context = context;
        this.datas=datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.local_search_item, null));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.itemView.setTag(position);
        final LocalBean venuesBean=datas.get(position);
        if(!TextUtils.isEmpty(venuesBean.getLocalName())){
            holder.name.setText(venuesBean.getLocalName());
        }
        holder.localItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public View line;
        public LinearLayout localItemLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            line = itemView.findViewById(R.id.line);
            localItemLayout = (LinearLayout) itemView.findViewById(R.id.local_item_layout);
        }
    }

    public void setDatas(List<LocalBean> datas) {
        this.datas = datas;
    }
}
