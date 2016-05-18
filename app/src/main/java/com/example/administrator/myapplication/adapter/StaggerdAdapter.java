package com.example.administrator.myapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.courview.wallfech.ScaleImageView;
import com.example.administrator.myapplication.model.StaggerdBean;

import java.util.List;

@SuppressLint("NewApi")
public class StaggerdAdapter extends BaseAdapter {
	private List<StaggerdBean> datas;
	private Context ctx;
	public StaggerdAdapter(List<StaggerdBean> datas, Context ctx) {
		this.datas = datas;
		this.ctx = ctx;
	}
	public void setDatas(List<StaggerdBean> datas){
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
			viewHolder = new ViewHolder();
			convertView = LayoutInflater.from(ctx).inflate(
					R.layout.staggerd_item, null);
			viewHolder.name_test = (TextView) convertView
					.findViewById(R.id.name_test);
			viewHolder.image_test = (ScaleImageView) convertView
					.findViewById(R.id.image_test);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		final StaggerdBean bean = datas.get(position);
		viewHolder.name_test.setText(bean.getName());
		viewHolder.image_test.setImageWidth(bean.getWidth());
		viewHolder.image_test.setImageHeight(bean.getHeight());
		Glide.with(ctx)
				.load(bean.getImageUrl())
				.centerCrop()
				.into(viewHolder.image_test);
//		Glide.with(ctx).load(Uri.parse(bean.getImageUrl())).placeholder(new ColorDrawable(Color.WHITE)).diskCacheStrategy(DiskCacheStrategy.ALL).into(viewHolder.image_test);
		return convertView;
	}

	private class ViewHolder {
		ScaleImageView image_test;
		TextView name_test;
	}
}
