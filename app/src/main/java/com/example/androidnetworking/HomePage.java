package com.example.androidnetworking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.androidnetworking.Adapter.CategoryAdapter;
import com.example.androidnetworking.Adapter.CategoryScheduleAdapter;
import com.example.androidnetworking.Adapter.ExamScheduleAdapter;
import com.example.androidnetworking.Adapter.ScheduleAdapter;
import com.example.androidnetworking.Model.Book;
import com.example.androidnetworking.Model.Category;
import com.example.androidnetworking.Model.CategorySchedule;
import com.example.androidnetworking.Model.ExamScheduleModel;
import com.example.androidnetworking.Model.NotificationModel;
import com.example.androidnetworking.Model.ScheduleModel;
import com.example.androidnetworking.Services.APIServices;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomePage extends AppCompatActivity {
    private RecyclerView rcvCategory, rvSchedule, rvExamSchedule;
    private CategoryAdapter categoryAdapter;
    private CategoryScheduleAdapter categoryscheduleAdapter;

    private ScheduleAdapter scheduleAdapter;
    private ExamScheduleAdapter examScheduleAdapter;

    public void StartNotification(View view) {
        Intent intent = new Intent(HomePage.this, NotificationActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // Tin Tức


        // Lịch học
        rvSchedule = findViewById(R.id.rvSchedule);
        getAndSetScheduleData();

        // Lịch thi
        rvExamSchedule = findViewById(R.id.rvExamSchedule);
        getAndSetExamScheduleData();
    }

    private void getAndSetExamScheduleData() {
        // Kết nối api
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIServices.baseLink)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIServices apiServices = retrofit.create(APIServices.class);

        // Dữ liệu lấy từ api
        Call<ArrayList<ExamScheduleModel>> response = apiServices.getExamSchedule();
        response.enqueue(new Callback<ArrayList<ExamScheduleModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ExamScheduleModel>> call, Response<ArrayList<ExamScheduleModel>> response) {
                ArrayList<ExamScheduleModel> list = response.body();
                rvExamSchedule.setLayoutManager(new LinearLayoutManager(HomePage.this, RecyclerView.VERTICAL, false));
                examScheduleAdapter = new ExamScheduleAdapter(list);
                rvExamSchedule.setAdapter(examScheduleAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<ExamScheduleModel>> call, Throwable t) {
                Toast.makeText(HomePage.this, "Lấy dữ liệu lịch thi thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getAndSetScheduleData() {
        // Kết nối api
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIServices.baseLink)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIServices apiServices = retrofit.create(APIServices.class);

        // Dữ liệu lấy từ api
        Call<ArrayList<ScheduleModel>> response = apiServices.getSchedule();
        response.enqueue(new Callback<ArrayList<ScheduleModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ScheduleModel>> call, Response<ArrayList<ScheduleModel>> response) {
                ArrayList<ScheduleModel> list = response.body();
                rvSchedule.setLayoutManager(new LinearLayoutManager(HomePage.this, RecyclerView.VERTICAL, false));
                scheduleAdapter = new ScheduleAdapter(list);
                rvSchedule.setAdapter(scheduleAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<ScheduleModel>> call, Throwable t) {
                Toast.makeText(HomePage.this, "Lấy dữ liệu lịch học thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }

}