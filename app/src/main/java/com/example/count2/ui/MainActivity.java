package com.example.count2.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.count2.R;
import com.example.count2.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new ContinentsFragment()).commit();
    }
}