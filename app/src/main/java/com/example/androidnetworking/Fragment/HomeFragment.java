package com.example.androidnetworking.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.androidnetworking.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.androidnetworking.Adapter.CategoryAdapter;
import com.example.androidnetworking.Adapter.CategoryScheduleAdapter;
import com.example.androidnetworking.Fragment.HomeFragment;
import com.example.androidnetworking.Fragment.NotificationFragment;
import com.example.androidnetworking.Fragment.SettingFragment;
import com.example.androidnetworking.Model.Book;
import com.example.androidnetworking.Model.Category;
import com.example.androidnetworking.Model.CategorySchedule;
import com.example.androidnetworking.Model.ScheduleModel;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}