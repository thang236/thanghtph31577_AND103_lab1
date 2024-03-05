package com.example.thanghtph31577_and103_lab1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.thanghtph31577_and103_lab1.databinding.ActivityResgiterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    ActivityResgiterBinding binding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityResgiterBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(binding.getRoot());

        userClick();
    }
    private void userClick() {
        binding.tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }

    private void validate() {
        String email = binding.editTextEmail.getText().toString().trim();
        String pass =  binding.editTextPassword.getText().toString().trim();
        Log.d("TAG", "validate: "+ email);
        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = mAuth.getCurrentUser();
                    Toast.makeText(Register.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                }
                else {
                    Log.d("zzzzzz", "onComplete: ", task.getException());
                    Toast.makeText(Register.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}

