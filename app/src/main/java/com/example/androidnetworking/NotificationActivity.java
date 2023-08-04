package com.example.androidnetworking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.androidnetworking.Adapter.NotificationAdapter;
import com.example.androidnetworking.Model.NotificationModel;
import com.example.androidnetworking.Services.APIServices;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NotificationActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NotificationAdapter adapter;
    private List<NotificationModel> notificationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        // Khởi tạo RecyclerView
        recyclerView = findViewById(R.id.recyclerViewNotifications);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Kết nối api
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIServices.baseLink)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIServices apiServices = retrofit.create(APIServices.class);

        // Dữ liệu lấy từ api
        Call<ArrayList<NotificationModel>> response = apiServices.getNews();
        response.enqueue(new Callback<ArrayList<NotificationModel>>() {
            @Override
            public void onResponse(Call<ArrayList<NotificationModel>> call, Response<ArrayList<NotificationModel>> response) {
                ArrayList<NotificationModel> list = response.body();
                // Khởi tạo Adapter và gán vào RecyclerView
                adapter = new NotificationAdapter(list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<NotificationModel>> call, Throwable t) {
                Toast.makeText(NotificationActivity.this, "Lấy dữ liệu thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
