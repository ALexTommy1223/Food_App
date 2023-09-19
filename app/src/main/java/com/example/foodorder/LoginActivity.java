package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.foodorder.databinding.ActivityLoginBinding;
import com.example.foodorder.databinding.ActivityStartBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding=ActivityLoginBinding.inflate(getLayoutInflater());
       View view=binding.getRoot();
       setContentView(view);

       binding.dontaccount.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
               startActivity(intent);
           }
       });

    }
}