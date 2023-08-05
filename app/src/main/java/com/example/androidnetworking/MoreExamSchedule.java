package com.example.androidnetworking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.androidnetworking.Adapter.ExamScheduleAdapter;
import com.example.androidnetworking.Adapter.MoreExamScheduleAdapter;
import com.example.androidnetworking.Adapter.ScheduleAdapter;
import com.example.androidnetworking.Model.ExamScheduleModel;
import com.example.androidnetworking.Services.APIServices;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoreExamSchedule extends AppCompatActivity {
    private RecyclerView rvMoreExamSchedule;
    private MoreExamScheduleAdapter moreExamScheduleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_exam_schedule);

        // Lịch thi
        rvMoreExamSchedule = findViewById(R.id.rvMoreExamSchedule);
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
                rvMoreExamSchedule.setLayoutManager(new LinearLayoutManager(MoreExamSchedule.this, RecyclerView.VERTICAL, false));
                moreExamScheduleAdapter = new MoreExamScheduleAdapter(list);
                rvMoreExamSchedule.setAdapter(moreExamScheduleAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<ExamScheduleModel>> call, Throwable t) {
                Toast.makeText(MoreExamSchedule.this, "Lấy dữ liệu lịch thi thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }
}