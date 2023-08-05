package com.example.androidnetworking.Services;

import com.example.androidnetworking.Model.ExamScheduleModel;
import com.example.androidnetworking.Model.NotificationModel;
import com.example.androidnetworking.Model.ScheduleModel;
import com.example.androidnetworking.Model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIServices {
    String baseLink = "http://192.168.187.173/androidnetworkingapi/api/"; //ip thay đổi theo địa chỉ internet đang dùng
    //api lấy tin tin tức/thông báo
    @GET("news.php")
    Call<ArrayList<NotificationModel>> getNews();

    @GET("schedule.php")
    Call<ArrayList<ScheduleModel>> getSchedule();

    @GET("exam_schedule.php")
    Call<ArrayList<ExamScheduleModel>> getExamSchedule();

    @GET("login.php")
    Call<Void> loginUser(
            @Query("username") String username,
            @Query("password") String password
    );
}
