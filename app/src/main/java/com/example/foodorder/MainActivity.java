package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.example.foodorder.databinding.ActivityMainBinding;
import com.example.foodorder.fragment.Notification_Bottom_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavController navController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView)).getNavController();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        binding.notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notification_Bottom_Fragment bottomSheetDialog = new Notification_Bottom_Fragment();
                bottomSheetDialog.show(getSupportFragmentManager(), "Test");

            }
        });
    }
}