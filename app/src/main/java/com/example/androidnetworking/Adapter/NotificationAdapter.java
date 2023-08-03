package com.example.androidnetworking.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidnetworking.R;
import com.example.androidnetworking.Model.NotificationModel;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {

    private List<NotificationModel> notificationList;

    public NotificationAdapter(List<NotificationModel> notificationList) {
        this.notificationList = notificationList;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item, parent, false);
        return new NotificationViewHolder(view);
    }

    //đây là hàm xử lý dữ liệu truyền lên cho giao diện thông qua model
    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        NotificationModel notification = notificationList.get(position);
        holder.tvNewsID.setText(notification.getIdNews());
        holder.tvTitle.setText(notification.getTitle());
        holder.tvContent.setText(notification.getContent());
        holder.tvDate.setText(notification.getDate());

        // Kiểm tra nếu là item cuối cùng, ẩn đường viền phía dưới
        if (position == notificationList.size() - 1) {
            holder.divider.setVisibility(View.GONE);
        } else {
            holder.divider.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    // đây là hàm sẽ kết nối adapter với giao diện
    public class NotificationViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvContent, tvDate, tvNewsID;
        View divider;
        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNewsID = itemView.findViewById(R.id.tvNewsID);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvContent = itemView.findViewById(R.id.tvContent);
            tvDate = itemView.findViewById(R.id.tvDate);
            divider = itemView.findViewById(R.id.divider);
        }
    }
}
