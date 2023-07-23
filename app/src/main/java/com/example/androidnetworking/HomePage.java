package com.example.androidnetworking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
        listBook.add(new Book(R.drawable.img1,"Book1"));
        listBook.add(new Book(R.drawable.img2,"Book2"));
        listBook.add(new Book(R.drawable.img3,"Book3"));
        listBook.add(new Book(R.drawable.img4,"Book4"));
        listBook.add(new Book(R.drawable.img4,"Book5"));


        listCategory.add(new Category("Thông tin lịch học", listBook));
        listCategory.add(new Category("Thông tin lịch thi", listBook));
        listCategory.add(new Category("Thông tin sự kiện", listBook));
        listCategory.add(new Category("Category 4", listBook));

        return listCategory;
    }

}