package com.example.androidnetworking.Model;

public class News {
    private int resourceId;
    private String titile;

    public News(int resourceId, String titile) {
        this.resourceId = resourceId;
        this.titile = titile;
    }

    public News() {
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }
}
