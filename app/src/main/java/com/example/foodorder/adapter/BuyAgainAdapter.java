package com.example.foodorder.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.foodorder.databinding.BuyAgainItemBinding;
import java.util.List;

public class BuyAgainAdapter extends RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder> {
    private List<String> buyAgainFoodName;
    private List<String> buyAgainFoodPrice;
    private List<Integer> buyAgainFoodImage;

    public BuyAgainAdapter(List<String> buyAgainFoodName, List<String> buyAgainFoodPrice, List<Integer> buyAgainFoodImage) {
        this.buyAgainFoodName = buyAgainFoodName;
        this.buyAgainFoodPrice = buyAgainFoodPrice;
        this.buyAgainFoodImage = buyAgainFoodImage;
    }

    @NonNull
    @Override
    public BuyAgainAdapter.BuyAgainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BuyAgainItemBinding binding = BuyAgainItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new BuyAgainViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BuyAgainAdapter.BuyAgainViewHolder holder, int position) {
        holder.bind(buyAgainFoodName.get(position), buyAgainFoodPrice.get(position), buyAgainFoodImage.get(position));
    }

    @Override
    public int getItemCount() {
        return buyAgainFoodName.size();
    }

    public class BuyAgainViewHolder extends RecyclerView.ViewHolder {
        private BuyAgainItemBinding binding;

        public BuyAgainViewHolder(@NonNull  BuyAgainItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String foodName, String foodPrice, Integer foodImage) {
            binding.buyagainName.setText(foodName);
            binding.buyagainPrice.setText(foodPrice);
            binding.buyagainImage.setImageResource(foodImage);
        }
    }
}
