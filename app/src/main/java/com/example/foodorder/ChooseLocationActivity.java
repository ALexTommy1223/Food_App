package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.foodorder.databinding.ActivityChooseLocationBinding;

import java.util.ArrayList;

public class ChooseLocationActivity extends AppCompatActivity {
    private ActivityChooseLocationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityChooseLocationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String[] locationList=new String[]{"Ha Noi","Ho Chi Minh","Da Nang","Lam Dong","Ha Giang"};
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,locationList);
        AutoCompleteTextView autoCompleteTextView=binding.chooseLocation;
        autoCompleteTextView.setAdapter(adapter);
    }
}