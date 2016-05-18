package com.example.administrator.myapplication.model;

import java.util.ArrayList;

public class DuitangInfo {
	private int width;
	private int height;
	private String albid = "";
	private String msg = "";
	private String isrc = "";
	private String point = "";
	private String origin = "";
	private String url = "";
	private String time = "";
	private ArrayList<String> images;

	public ArrayList<String> getImages() {
		return images;
	}

	public void setImages(ArrayList<String> images) {
		this.images = images;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPoint() {
		return point;
	}

	public String getOrigin() {
		return origin;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTime() {

		return time;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getAlbid() {
		return albid;
	}

	public void setAlbid(String albid) {
		this.albid = albid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getIsrc() {
		return isrc;
	}

	public void setIsrc(String isrc) {
		this.isrc = isrc;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	

}
