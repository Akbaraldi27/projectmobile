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

import com.rizal.project2.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupAction();
        customEditTextPassword();
        setupAnimation();
    }

    private void customEditTextPassword() {
        binding.etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 6){
                    binding.etlPassword.setError("Password minimal 6 karakter");
                }else {
                    binding.etlPassword.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setupAction() {
        binding.tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
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

        ObjectAnimator btnMasuk = ObjectAnimator.ofFloat(binding.btnMasuk, View.ALPHA, 1f);
        btnMasuk.setDuration(500);

        ObjectAnimator tvRegister = ObjectAnimator.ofFloat(binding.tvRegister, View.ALPHA, 1f);
        tvRegister.setDuration(500);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ivImage, tv1, tv2, etlEmail, etlPassword, btnMasuk, tvRegister);
        animatorSet.setStartDelay(100);
        animatorSet.start();

        ObjectAnimator animator = android.animation.ObjectAnimator.ofFloat(binding.ivImage, View.TRANSLATION_X, -50f, 50f);
        animator.setDuration(6000);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();
    }
}