package com.example.androidnetworking.Model;

public class NotificationModel {
    private int idNews;
    private String title;
    private String content;
    private String date;

    public NotificationModel(int idNews, String title, String content, String date) {
        this.idNews = idNews;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public int getIdNews() {
        return idNews;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }
}
