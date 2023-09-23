package com.example.foodorder.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodorder.R;
import com.example.foodorder.adapter.BuyAgainAdapter;
import com.example.foodorder.databinding.FragmentHistoryBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HistoryFragment extends Fragment {
    private FragmentHistoryBinding binding;
    private BuyAgainAdapter buyAgainAdapter;


    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHistoryBinding.inflate(getLayoutInflater(), container, false);
        setUpRecylerView();
        return binding.getRoot();
    }

    private void setUpRecylerView() {
      List<String> buyAgainFoodName= Arrays.asList("Food 1", "Food 2","Food 3");
      List<String> buyAgainFoodPrice= Arrays.asList("$25", "$15","$9");
      List<Integer> buyAgainFoodImage= Arrays.asList(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3);

      buyAgainAdapter=new BuyAgainAdapter(buyAgainFoodName,buyAgainFoodPrice,buyAgainFoodImage);
      binding.buyagainRecylerview.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.buyagainRecylerview.setAdapter(buyAgainAdapter);
    }
}