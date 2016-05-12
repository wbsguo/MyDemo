package com.example.administrator.myapplication.model;

import java.io.Serializable;

public class VideoDetailBean implements Serializable {
	
	public final static String KEY = "video_detail_bean";

	private String mContent;

	public String getmContent() {
		return mContent;
	}

	public void setmContent(String mContent) {
		this.mContent = mContent;
	}
	
}