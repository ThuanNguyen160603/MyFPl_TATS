package com.example.androidnetworking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidnetworking.Adapter.CategoryAdapter;
import com.example.androidnetworking.Adapter.CategoryScheduleAdapter;
import com.example.androidnetworking.Model.Book;
import com.example.androidnetworking.Model.Category;
import com.example.androidnetworking.Model.CategorySchedule;
import com.example.androidnetworking.Model.ScheduleModel;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {
    private RecyclerView rcvCategory, rcvCategory1;
    private CategoryAdapter categoryAdapter;
    private CategoryScheduleAdapter categoryscheduleAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //tin tuc
        rcvCategory = findViewById(R.id.rcv_category);
        rcvCategory.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        categoryAdapter = new CategoryAdapter(this);
        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);

        //lich hoc
        rcvCategory1 = findViewById(R.id.rcv_lich);
        rcvCategory1.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        categoryscheduleAdapter = new CategoryScheduleAdapter(this);
        categoryscheduleAdapter.setData(getListCategory1());
        rcvCategory1.setAdapter(categoryscheduleAdapter);

        //lich thi
        //thong bao

    }
    private List<Category> getListCategory(){
        List<Category> listCategory = new ArrayList<>();
        List<Book> listBook = new ArrayList<>();

        //add du lieu itemtin tuc
        listBook.add(new Book(R.drawable.tin1,"FPT Đồng Hành Cùng VNOI CUP 2023 – Vườn Ươm Tài Năng Công Nghệ Trẻ"));
        listBook.add(new Book(R.drawable.tin2,"FPT Software Khai Trương Văn Phòng Mới Tại Huế"));
        listBook.add(new Book(R.drawable.tin3,"FezyFlow - Nền Tảng Giúp Doanh Nghiệp Cải Thiện 45% Năng Suất Làm Việc"));
        listBook.add(new Book(R.drawable.tin4,"FPT Software Hợp Tác Với Viện Kỹ Thuật ĐH Bách Khoa Trong Lĩnh Vực Xe Điện"));
        listBook.add(new Book(R.drawable.tin5,"FPT Software Trở Thành Đối Tác Phần Mềm Toàn Diện Của Tập Đoàn Nippon Seiki"));

        //add name category
        listCategory.add(new Category("Tin tức", listBook));

        return listCategory;
    }

    private List<CategorySchedule> getListCategory1() {
        List<CategorySchedule> listCategory = new ArrayList<>();
        List<ScheduleModel> listSchedule = new ArrayList<>();

        //add du kieu lich hoc
        listSchedule.add(new ScheduleModel("Android Networking", "Ca 2 (7h30-9h30)", "Phòng T1008", "2023-07-24", "MOB402"));
        listSchedule.add(new ScheduleModel("Lập trình Server", "Ca 6 (7h30-9h30)", "Phòng T1001", "2023-07-25", "MOB402"));
        listSchedule.add(new ScheduleModel("Dự Án 1", "Ca 4 (7h30-9h30)", "Phòng T305", "2023-07-26", "MOB402"));
        listSchedule.add(new ScheduleModel("Khởi sự doanh nghiệp", "Ca 3 (7h30-9h30)", "Phòng T808", "2023-07-23", "MOB402"));
        listSchedule.add(new ScheduleModel("Kỹ năng học tập 2", "Ca 5 (7h30-9h30)", "Phòng T1108", "2023-07-22", "MOB402"));

        //add name category
        listCategory.add(new CategorySchedule("Lịch học", listSchedule));

        return listCategory;
    }

    public void Notify (View view) {
        Intent intent = new Intent(HomePage.this, Notification.class);
        startActivity(intent);
    }
}