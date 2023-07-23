package com.example.androidnetworking;

public class Book {
    private int resourceId;
    private String titile;

    public Book(int resourceId, String titile) {
        this.resourceId = resourceId;
        this.titile = titile;
    }

    public Book() {
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
