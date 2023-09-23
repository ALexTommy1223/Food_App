package com.example.foodorder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder.R;
import com.example.foodorder.databinding.PopularItemsBinding;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder> {
   private List<String> items;
   private List<String> price;
   private List<Integer> image;
   private Context context;

    public PopularAdapter(List<String> items, List<String> price, List<Integer> image, Context context) {
        this.items = items;
        this.price = price;
        this.image = image;
        this.context = context;
    }

    @NonNull
    @Override
    public PopularAdapter.PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PopularViewHolder(PopularItemsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.PopularViewHolder holder, int position) {
        String item=items.get(position);
        String priceValue=price.get(position);
        int imageResource=image.get(position);
        holder.bind(item,priceValue,imageResource);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class PopularViewHolder extends RecyclerView.ViewHolder {
        private PopularItemsBinding binding;

        public PopularViewHolder(@NonNull PopularItemsBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

        public void bind(String item, String priceValue, int imageResource) {
            binding.foodNameProduct.setText(item);
            binding.pricePopular.setText(priceValue);
            binding.imageView5.setImageResource(imageResource);

        }
    }
}
