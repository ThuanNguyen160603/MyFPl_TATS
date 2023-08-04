package com.example.androidnetworking.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidnetworking.Model.ExamScheduleModel;
import com.example.androidnetworking.R;

import java.util.List;

public class MoreExamScheduleAdapter extends RecyclerView.Adapter<MoreExamScheduleAdapter.ScheduleViewHolder>{
    private List<ExamScheduleModel> examScheduleList;

    public MoreExamScheduleAdapter(List<ExamScheduleModel> examScheduleList) {
        this.examScheduleList = examScheduleList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_more_item, parent, false);
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
       ExamScheduleModel examSchedule = examScheduleList.get(position);
       if(examSchedule == null){
           return;
       }
        holder.tvMaMonID.setText("ID mã Môn: " + examSchedule.getMaMon());
        holder.tvDate.setText("Ngày thi: " + examSchedule.getNgayThi());
        holder.tvDiaDiem.setText("Địa điểm: " + examSchedule.getDiaDiem());
        holder.tvCa.setText("Ca: " + String.valueOf(examSchedule.getCa()));
    }

    @Override
    public int getItemCount() {
        if(examScheduleList != null){
            return examScheduleList.size();
        }
        return 0;
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder{
        private TextView tvLTID, tvMaMonID, tvDate, tvDiaDiem, tvCa;
        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMaMonID = itemView.findViewById(R.id.tvMonID);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvDiaDiem = itemView.findViewById(R.id.tvDiaDiem);
            tvCa = itemView.findViewById(R.id.tvCa);
        }
    }
}
