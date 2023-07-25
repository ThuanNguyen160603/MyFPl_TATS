package com.example.androidnetworking.Model;

import com.example.androidnetworking.Model.Book;

import java.util.List;

public class Category {
    private String nameCategory;
    private List<Book> books;

    private List<ScheduleModel> schedules;

    public Category(String nameCategory, List<Book> books) {
        this.nameCategory = nameCategory;
        this.books = books;

    }

    public List<ScheduleModel> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ScheduleModel> schedules) {
        this.schedules = schedules;
    }


    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
