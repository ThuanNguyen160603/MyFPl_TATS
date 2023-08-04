package com.example.androidnetworking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.androidnetworking.Adapter.MoreScheduleAdaper;
import com.example.androidnetworking.Adapter.ScheduleAdapter;
import com.example.androidnetworking.Model.ScheduleModel;
import com.example.androidnetworking.Services.APIServices;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoreSchedule extends AppCompatActivity {
    private RecyclerView rvMoreSchedule;
    private MoreScheduleAdaper moreScheduleAdaper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_schedule);

        // Lịch học
        rvMoreSchedule = findViewById(R.id.rvMoreSchedule);
        getAndSetScheduleData();
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
                rvMoreSchedule.setLayoutManager(new LinearLayoutManager(MoreSchedule.this, RecyclerView.VERTICAL, false));
                moreScheduleAdaper = new MoreScheduleAdaper(list);
                rvMoreSchedule.setAdapter(moreScheduleAdaper);
            }

            @Override
            public void onFailure(Call<ArrayList<ScheduleModel>> call, Throwable t) {
                Toast.makeText(MoreSchedule.this, "Lấy dữ liệu lịch học thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }
}