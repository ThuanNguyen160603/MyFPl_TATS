package com.example.androidnetworking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.androidnetworking.Adapter.NotificationAdapter;
import com.example.androidnetworking.Model.NotificationModel;

import java.util.ArrayList;
import java.util.List;

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

        // Tạo dữ liệu cứng cho danh sách thông báo
        createDummyData();

        // Khởi tạo Adapter và gán vào RecyclerView
        adapter = new NotificationAdapter(notificationList);
        recyclerView.setAdapter(adapter);
    }

    private void createDummyData() {
        // Tạo danh sách thông báo giả định
        notificationList = new ArrayList<>();

        notificationList.add(new NotificationModel(1, "Thông báo 1", "Nội dung thông báo 1", "2023-07-24"));
        notificationList.add(new NotificationModel(2, "Thông báo 2", "Nội dung thông báo 2", "2023-07-25"));
        notificationList.add(new NotificationModel(3, "Thông báo 3", "Nội dung thông báo 3", "2023-07-26"));
        notificationList.add(new NotificationModel(4, "Thông báo 4", "Nội dung thông báo 4", "2023-07-24"));
        notificationList.add(new NotificationModel(5, "Thông báo 5", "Nội dung thông báo 5", "2023-07-25"));
        notificationList.add(new NotificationModel(6, "Thông báo 6", "Nội dung thông báo 6", "2023-07-26"));
        notificationList.add(new NotificationModel(7, "Thông báo 7", "Nội dung thông báo 7", "2023-07-24"));
        notificationList.add(new NotificationModel(8, "Thông báo 8", "Nội dung thông báo 8", "2023-07-25"));
        notificationList.add(new NotificationModel(9, "Thông báo 9", "Nội dung thông báo 9", "2023-07-26"));

        // Thêm các thông báo giả định khác vào danh sách này tùy ý
    }
}
