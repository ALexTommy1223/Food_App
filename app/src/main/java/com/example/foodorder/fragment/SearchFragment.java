package com.example.foodorder.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.foodorder.R;
import com.example.foodorder.adapter.MenuAdapter;
import com.example.foodorder.databinding.FragmentSearchBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SearchFragment extends Fragment {
    private FragmentSearchBinding binding;
    private MenuAdapter adapter;
    private List<String> orignalMenuFoodName = Arrays.asList("Burger", "sandwitch", "momo", "item", "sandwich", "mimo");
    private List<String> orignalMenuItemPrice = Arrays.asList("$5", "$9", "75", "$45", "$15", "$6");

    private List<Integer> orignalMenuImage = Arrays.asList(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6
    );



    public SearchFragment() {
        // Required empty public constructor
    }

    private ArrayList<String> filteredMenuFoodName=new ArrayList<>();
    private ArrayList<String> filteredMenuItemPrice=new ArrayList<>();
    private ArrayList<Integer> filteredMenuImage=new ArrayList<>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentSearchBinding.inflate(inflater,container,false);
        adapter=new MenuAdapter(filteredMenuFoodName,filteredMenuItemPrice,filteredMenuImage);
        binding.menuRecylerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.menuRecylerView.setAdapter(adapter);

        setupSearchView();
        showAllMenu();
        return binding.getRoot();
    }

    private void showAllMenu() {
        filteredMenuFoodName.clear();
        filteredMenuItemPrice.clear();
        filteredMenuImage.clear();

        filteredMenuFoodName.addAll(orignalMenuFoodName);
        filteredMenuItemPrice.addAll(orignalMenuItemPrice);
        filteredMenuImage.addAll(orignalMenuImage);

        adapter.notifyDataSetChanged();
    }

    private void setupSearchView() {
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterMenuItems(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterMenuItems(newText);
                return true;
            }
        });
    }

    private void filterMenuItems(String query) {
        filteredMenuFoodName.clear();
        filteredMenuItemPrice.clear();
        filteredMenuImage.clear();

        for (int index=0;index<orignalMenuFoodName.size();index++){
            String foodName=orignalMenuFoodName.get(index);
            if(foodName.toLowerCase().contains(query.toLowerCase())){
                filteredMenuFoodName.add(foodName);
                filteredMenuItemPrice.add(orignalMenuItemPrice.get(index));
                filteredMenuImage.add(orignalMenuImage.get(index));
            }
        }
        adapter.notifyDataSetChanged();
    }
}