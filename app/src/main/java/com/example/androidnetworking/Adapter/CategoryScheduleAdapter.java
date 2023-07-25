package com.example.androidnetworking.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidnetworking.Model.CategorySchedule;
import com.example.androidnetworking.R;

import java.util.List;

public class CategoryScheduleAdapter extends RecyclerView.Adapter<CategoryScheduleAdapter.CategoryViewHolder>{
    private Context mContext;
    private List<CategorySchedule> mListCategorySchedule;

    public CategoryScheduleAdapter(Context mContext){
        this.mContext = mContext;
    }

    public void setData(List<CategorySchedule> list){
        this.mListCategorySchedule = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category1,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategorySchedule categoryschedule = mListCategorySchedule.get(position);
        if(categoryschedule == null){
            return;
        }
        holder.tvNameCategory.setText(categoryschedule.getNameCategory());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
        holder.rcvBook.setLayoutManager(linearLayoutManager);

//        BookAdapter bookAdapter = new BookAdapter();
//        bookAdapter.setData(categoryschedule.getBooks());
//        holder.rcvBook.setAdapter(bookAdapter);

        ScheduleAdapter scheduleAdapter = new ScheduleAdapter();
        scheduleAdapter.setData(categoryschedule.getSchedules());
        holder.rcvBook.setAdapter(scheduleAdapter);

    }

    @Override
    public int getItemCount() {
        if(mListCategorySchedule != null){
            return mListCategorySchedule.size();
        }
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNameCategory;
        private RecyclerView rcvBook;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNameCategory =  itemView.findViewById(R.id.tv_name_category1);
            rcvBook =  itemView.findViewById(R.id.rcv_book1);


        }
    }

}
