package com.example.administrator.myapplication.model;

import java.io.Serializable;

/**
 * Created by wangbs on 16/5/18.
 */
public class StaggerdBean implements Serializable{
    private String imageUrl;
    private String name;
    private int width;
    private int height;
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
