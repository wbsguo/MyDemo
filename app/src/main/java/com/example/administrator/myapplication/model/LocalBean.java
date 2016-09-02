package com.example.administrator.myapplication.model;

import java.io.Serializable;

/**
 * 地图bean
 * Created by wangbs on 16/7/19.
 */
public class LocalBean implements Serializable{
    private String localName; //地理位置
    private double longitude;// 经度
    private double latitude;// 纬度

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

}
