package com.example.foodorder.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder.databinding.MenuItemsBinding;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private ArrayList<String> menuItemName;
    private ArrayList<String> menuItemPrice;
    private ArrayList<Integer> menuItemImage;

    public MenuAdapter(ArrayList<String> menuItemName, ArrayList<String> menuItemPrice, ArrayList<Integer> menuItemImage) {
        this.menuItemName = menuItemName;
        this.menuItemPrice = menuItemPrice;
        this.menuItemImage = menuItemImage;
    }

    @NonNull
    @Override
    public MenuAdapter.MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MenuViewHolder(MenuItemsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.MenuViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return menuItemName.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        private MenuItemsBinding binding;
        public MenuViewHolder(@NonNull  MenuItemsBinding binding) {
            super(binding.getRoot());
            this.binding=binding;

        }

        public void bind(int position) {
            binding.menuNameProduct.setText(menuItemName.get(position));
            binding.menuPrice.setText(menuItemPrice.get(position));
            binding.menuImage.setImageResource(menuItemImage.get(position));
        }
    }
}
