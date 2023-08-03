package com.example.androidnetworking.Services;

import com.example.androidnetworking.Model.ExamScheduleModel;
import com.example.androidnetworking.Model.NotificationModel;
import com.example.androidnetworking.Model.ScheduleModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServices {
    String baseLink = "http://192.168.2.51/androidnetworkingapi/api/"; //ip thay đổi theo địa chỉ internet đang dùng
    //api lấy tin tin tức/thông báo
    @GET("news.php")
    Call<ArrayList<NotificationModel>> getNews();

    @GET("schedule.php")
    Call<ArrayList<ScheduleModel>> getSchedule();

    @GET("exam_schedule.php")
    Call<ArrayList<ExamScheduleModel>> getExamSchedule();
}
