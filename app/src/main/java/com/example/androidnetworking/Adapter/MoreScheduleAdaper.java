package com.example.androidnetworking.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidnetworking.Model.ScheduleModel;
import com.example.androidnetworking.R;

import java.util.List;

public class MoreScheduleAdaper extends RecyclerView.Adapter<MoreScheduleAdaper.ScheduleViewHolder>{
    private List<ScheduleModel> scheduleList;

    public MoreScheduleAdaper(List<ScheduleModel> scheduleList) {
        this.scheduleList = scheduleList;
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
       ScheduleModel schedule = scheduleList.get(position);
       if(schedule == null){
           return;
       }
        holder.tvMonID.setText("ID mã môn: " + schedule.getIdMon());
        holder.tvDate.setText("Ngày học: " + schedule.getNgayHoc());
        holder.tvDiaDiem.setText("Địa điểm: " + schedule.getDiaDiem());
        holder.tvCa.setText(String.valueOf("Ca: " + schedule.getCa()));
    }


    @Override
    public int getItemCount() {
        if(scheduleList != null){
            return scheduleList.size();
        }
        return 0;
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder{
        private TextView tvMonID, tvDate, tvDiaDiem, tvCa;
        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMonID = itemView.findViewById(R.id.tvMonID);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvDiaDiem = itemView.findViewById(R.id.tvDiaDiem);
            tvCa = itemView.findViewById(R.id.tvCa);
        }
    }
}
