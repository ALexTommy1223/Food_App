package com.example.foodorder.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodorder.R;
import com.example.foodorder.adapter.NotificationAdapter;
import com.example.foodorder.databinding.FragmentNotificationBottomBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;


public class Notification_Bottom_Fragment extends BottomSheetDialogFragment {
    private FragmentNotificationBottomBinding binding;

    public Notification_Bottom_Fragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentNotificationBottomBinding.inflate(getLayoutInflater());

        ArrayList<String> notifications=new ArrayList<>();
        notifications.add("Your order has been canceled successly");
        notifications.add("Another notification message");
        notifications.add("Yet another notification");
        ArrayList<Integer> notificationImage=new ArrayList<>();
        notificationImage.add(R.drawable.sademoji);
        notificationImage.add(R.drawable.truck);
        notificationImage.add(R.drawable.congrats);

        NotificationAdapter adapterView= new NotificationAdapter(notifications,notificationImage);
        binding.notificationBottomRecylerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.notificationBottomRecylerView.setAdapter(adapterView);
        return binding.getRoot();
    }

}