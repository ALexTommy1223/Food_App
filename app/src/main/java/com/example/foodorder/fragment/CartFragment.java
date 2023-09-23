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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CartFragment extends Fragment {
    private static FragmentCartBinding binding;


    public CartFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCartBinding.inflate(inflater, container, false);

        ArrayList<String> cartFoodName = new ArrayList<>();
        cartFoodName.add("Burger");
        cartFoodName.add("sandwich");
        cartFoodName.add("momo");
        cartFoodName.add("item");
        cartFoodName.add("sandwich");

        ArrayList<String> cartItemPrice = new ArrayList<>();
        cartItemPrice.add("$7");
        cartItemPrice.add("$8");
        cartItemPrice.add("$12");
        cartItemPrice.add("$9");
        cartItemPrice.add("$17");

        ArrayList<Integer> cartImage = new ArrayList<>();
        cartImage.add(R.drawable.menu1);
        cartImage.add(R.drawable.menu2);
        cartImage.add(R.drawable.menu3);
        cartImage.add(R.drawable.menu4);
        cartImage.add(R.drawable.menu5);

        CartItemsAdapter adapter = new CartItemsAdapter(cartFoodName, cartItemPrice, cartImage);
        binding.cartRec.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.cartRec.setAdapter(adapter);

        return binding.getRoot();
    }
}