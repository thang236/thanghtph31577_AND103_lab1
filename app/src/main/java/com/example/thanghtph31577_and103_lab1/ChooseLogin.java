package com.example.thanghtph31577_and103_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.thanghtph31577_and103_lab1.databinding.ActivityChooseLoginBinding;
import com.example.thanghtph31577_and103_lab1.databinding.ActivityMainBinding;

public class ChooseLogin extends AppCompatActivity {
    ActivityChooseLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChooseLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userListener();
    }

    private void userListener() {
        binding.btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseLogin.this, MainActivity.class));
            }
        });

        binding.btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseLogin.this, LoginByPhone.class));

            }
        });
    }
}