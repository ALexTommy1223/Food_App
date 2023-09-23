package com.example.foodorder.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodorder.R;
import com.example.foodorder.adapter.CartItemsAdapter;
import com.example.foodorder.databinding.FragmentCartBinding;
import com.example.foodorder.databinding.FragmentMenuBootomSheetBinding;
import com.example.foodorder.databinding.MenuItemsBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;


public class MenuBootomSheetFragment extends BottomSheetDialogFragment {
    private static FragmentMenuBootomSheetBinding binding;

    public MenuBootomSheetFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMenuBootomSheetBinding.inflate(inflater, container, false);

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        ArrayList<String> menuFoodName = new ArrayList<>();
        menuFoodName.add("Burger");
        menuFoodName.add("sandwich");
        menuFoodName.add("momo");
        menuFoodName.add("item");
        menuFoodName.add("sandwich");

        ArrayList<String>   menuItemPrice = new ArrayList<>();
        menuItemPrice.add("$7");
        menuItemPrice.add("$8");
        menuItemPrice.add("$12");
        menuItemPrice.add("$9");
        menuItemPrice.add("$17");

        ArrayList<Integer> menuItemImage = new ArrayList<>();
        menuItemImage.add(R.drawable.menu1);
        menuItemImage.add(R.drawable.menu2);
        menuItemImage.add(R.drawable.menu3);
        menuItemImage.add(R.drawable.menu4);
        menuItemImage.add(R.drawable.menu5);

        CartItemsAdapter adapter = new CartItemsAdapter(menuFoodName, menuItemPrice, menuItemImage);
        binding.menuRecylerview.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.menuRecylerview.setAdapter(adapter);

        return binding.getRoot();
    }
}