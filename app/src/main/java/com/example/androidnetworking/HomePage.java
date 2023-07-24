package com.example.androidnetworking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidnetworking.Adapter.CategoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {
    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        rcvCategory = findViewById(R.id.rcv_category);
        categoryAdapter = new CategoryAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);

    }
    private List<Category> getListCategory(){
        List<Category> listCategory = new ArrayList<>();
        List<Book> listBook = new ArrayList<>();
        listBook.add(new Book(R.drawable.tt1,"Tin tức 24h"));
        listBook.add(new Book(R.drawable.tt2,"Book2"));
        listBook.add(new Book(R.drawable.tt3,"Báo Tin Tức: Tờ báo đi đầu trong cổ vũ nhân tố mới của những sự kện nóng hổi"));
        listBook.add(new Book(R.drawable.tt4,"Book4"));
        listBook.add(new Book(R.drawable.tt5,"Book5"));


        listCategory.add(new Category("Thông tin sự kiện", listBook));
        listCategory.add(new Category("Thông báo", listBook));
        listCategory.add(new Category("Lịch học", listBook));
        listCategory.add(new Category("Lịch thi", listBook));

        return listCategory;
    }

    public void Notify (View view) {
        Intent intent = new Intent(HomePage.this, Notification.class);
        startActivity(intent);
    }

}