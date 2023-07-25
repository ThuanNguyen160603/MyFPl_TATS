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

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>{
    private List<ScheduleModel> mSchedule;

    public void setData(List<ScheduleModel> list){
        this.mSchedule = list;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedule, parent, false);
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
       ScheduleModel schedule = mSchedule.get(position);
       if(schedule == null){
           return;
       }
        holder.tvTitle1.setText(schedule.getTitile1());
        holder.tvTitle2.setText(schedule.getTitile2());
        holder.tvTitle3.setText(schedule.getTitile3());
        holder.tvTitle4.setText(schedule.getTitile4());
        holder.tvTitle5.setText(schedule.getTitile5());
    }


    @Override
    public int getItemCount() {
        if(mSchedule != null){
            return mSchedule.size();
        }
        return 0;
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTitle1, tvTitle2, tvTitle3, tvTitle4, tvTitle5;
        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle1 = itemView.findViewById(R.id.tv_title1);
            tvTitle2 = itemView.findViewById(R.id.tv_title2);
            tvTitle3 = itemView.findViewById(R.id.tv_title3);
            tvTitle4 = itemView.findViewById(R.id.tv_title4);
            tvTitle5 = itemView.findViewById(R.id.tv_title5);


        }
    }
}
