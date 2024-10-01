package com.rizal.project2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.rizal.project2.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        customEditTextPassword();
        setupAction();
        setupAnimation();
    }

    private void customEditTextPassword() {
        binding.etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 6) {
                    binding.etlPassword.setError("Password minimal 6 karakter");
                } else {
                    binding.etlPassword.setError(null);
                }
                String password = s.toString();
                customEditTextConfirmPassword(password);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void customEditTextConfirmPassword(String password) {
        binding.etConfirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.equals(password)) {
                    binding.etlConfirmPassword.setError("Password Harus Sama");
                } else {
                    binding.etlConfirmPassword.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setupAction() {
        binding.tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupAnimation() {
        ObjectAnimator ivImage = ObjectAnimator.ofFloat(binding.ivImage, View.ALPHA, 1f);
        ivImage.setDuration(500);

        ObjectAnimator tv1 = ObjectAnimator.ofFloat(binding.tv1, View.ALPHA, 1f);
        tv1.setDuration(500);

        ObjectAnimator tv2 = ObjectAnimator.ofFloat(binding.tv2, View.ALPHA, 1f);
        tv2.setDuration(500);

        ObjectAnimator etlEmail = ObjectAnimator.ofFloat(binding.etlEmail, View.ALPHA, 1f);
        etlEmail.setDuration(500);

        ObjectAnimator etlPassword = ObjectAnimator.ofFloat(binding.etlPassword, View.ALPHA, 1f);
        etlPassword.setDuration(500);

        ObjectAnimator etlConfirmPassword = ObjectAnimator.ofFloat(binding.etlConfirmPassword, View.ALPHA, 1f);
        etlConfirmPassword.setDuration(500);

        ObjectAnimator tvLogin = ObjectAnimator.ofFloat(binding.tvLogin, View.ALPHA, 1f);
        tvLogin.setDuration(500);

        ObjectAnimator btnDaftar = ObjectAnimator.ofFloat(binding.btnDaftar, View.ALPHA, 1f);
        btnDaftar.setDuration(500);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ivImage, tv1, tv2, etlEmail, etlPassword, etlConfirmPassword, tvLogin, btnDaftar);
        animatorSet.setStartDelay(100);
        animatorSet.start();

        ObjectAnimator animator = android.animation.ObjectAnimator.ofFloat(binding.ivImage, View.TRANSLATION_X, -50f, 50f);
        animator.setDuration(6000);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();
    }
}