package com.hyeonwoo.java_background;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.View;

import com.hyeonwoo.java_background.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    // Java는 클래스 파일안에 public 객체가 하나만 존재해야함 ._.
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        binding.buttonExecutor.setOnClickListener(v -> { navController.navigate(R.id.executorFragment); });
        binding.buttonJob.setOnClickListener(v -> { navController.navigate(R.id.jobFragment); });
        binding.buttonWork.setOnClickListener(v -> { navController.navigate(R.id.workFragment); });
    }
}