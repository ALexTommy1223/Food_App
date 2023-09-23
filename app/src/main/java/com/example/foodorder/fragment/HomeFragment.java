package com.example.foodorder.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.foodorder.R;
import com.example.foodorder.adapter.PopularAdapter;
import com.example.foodorder.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentHomeBinding.inflate(inflater, container, false);
        binding.viewallMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenuBootomSheetFragment bootomSheetFragment=new MenuBootomSheetFragment();
                bootomSheetFragment.show(getParentFragmentManager(),"Test");
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<SlideModel> imageList=new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.banner1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner2, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner3, ScaleTypes.FIT));
        ImageSlider imageSlider=binding.imageSlider;
        imageSlider.setImageList(imageList);
        imageSlider.setImageList(imageList,ScaleTypes.FIT);

        List<String> foodName= Arrays.asList("Burger","sandwich","momo","item");
        List<String> price=Arrays.asList("$5","$7","$8","$10");
        List<Integer> populerFoodImages=Arrays.asList(R.drawable.menu1,
                R.drawable.menu2, R.drawable.menu3,R.drawable.menu4
                );
        PopularAdapter adapter=new PopularAdapter(foodName,price,populerFoodImages,requireContext());
        binding.popularRec.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.popularRec.setAdapter(adapter);
    }
}