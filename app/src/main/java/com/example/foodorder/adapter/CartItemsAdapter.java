package com.example.foodorder.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder.databinding.CartItemsBinding;

import java.util.ArrayList;
import java.util.List;

public class CartItemsAdapter extends RecyclerView.Adapter<CartItemsAdapter.CartItemsViewHolder> {

    private ArrayList<String> CartItem;
    private ArrayList<String> CartPrice;
    private ArrayList <Integer> CartImage;
    private int[] itemQuantities;

    public CartItemsAdapter(ArrayList<String> cartItem, ArrayList<String> cartPrice, ArrayList<Integer> cartImage) {
        CartItem = cartItem;
        CartPrice = cartPrice;
        CartImage = cartImage;
        itemQuantities = new int[CartItem.size()];
    }

    @NonNull
    @Override
    public CartItemsAdapter.CartItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CartItemsViewHolder(CartItemsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemsAdapter.CartItemsViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return CartItem.size();
    }

    public class CartItemsViewHolder extends RecyclerView.ViewHolder {
        public  CartItemsBinding binding;
        public CartItemsViewHolder(@NonNull CartItemsBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

        public void bind(int position) {
            String quantity=String.valueOf(itemQuantities[position]);
            binding.cartFoodName.setText(CartItem.get(position));
            binding.cartItemPrice.setText(CartPrice.get(position));
            binding.cartImage.setImageResource(CartImage.get(position));
            binding.cartItemQuantity.setText(quantity);


            binding.minusbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    decreaseQuantity(getAdapterPosition());
                }
            });
            binding.plusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    increaseQuantity(getAdapterPosition());
                }
            });
            binding.cartItemDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int itemPosition=getAdapterPosition();
                    if(itemPosition!=RecyclerView.NO_POSITION){
                        deleteItem(itemPosition);
                    }

                }
            });
        }
    }

    private void increaseQuantity(int position) {
            if(itemQuantities[position]<10){
                itemQuantities[position]++;
                notifyItemChanged(position);
            }
    }

    private void decreaseQuantity(int position) {
        if(itemQuantities[position]>1){
            itemQuantities[position]--;
            notifyItemChanged(position);
        }
    }
    private void deleteItem(int position) {
            CartItem.remove(position);
            CartImage.remove(position);
            CartPrice.remove(position);
            itemQuantities=new int[CartItem.size()];
            notifyItemRemoved(position);
    }
}
