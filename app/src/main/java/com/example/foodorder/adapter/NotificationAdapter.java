package com.example.foodorder.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder.databinding.NotificationItemsBinding;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {
    private ArrayList<String> notification;
    private ArrayList<Integer> notificationImage;

    public NotificationAdapter(ArrayList<String> notification, ArrayList<Integer> notificationImage) {
        this.notification = notification;
        this.notificationImage = notificationImage;
    }

    @NonNull
    @Override
    public NotificationAdapter.NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotificationViewHolder(NotificationItemsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.NotificationViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return notification.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder {
        private NotificationItemsBinding binding;
        public NotificationViewHolder(@NonNull NotificationItemsBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

        public void bind(int position) {
            binding.notificationTextView.setText(notification.get(position));
            binding.notificationImageView.setImageResource(notificationImage.get(position));
        }
    }
}
