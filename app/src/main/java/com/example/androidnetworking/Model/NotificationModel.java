package com.example.androidnetworking.Model;

import android.util.Log;
import android.widget.Toast;

import com.example.androidnetworking.HomePage;

public class NotificationModel {
    private String idNews;
    private String title;
    private String content;
    private String date;

    public NotificationModel(String idNews, String title, String content, String date) {
        this.idNews = idNews;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public String getIdNews() {
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
