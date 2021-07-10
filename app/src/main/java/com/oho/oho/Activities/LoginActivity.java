package com.oho.oho.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.oho.oho.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout emailLayout;
    private LinearLayout otpLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        MaterialCardView loginButton   = findViewById(R.id.button_login);
        MaterialCardView otpButton     = findViewById(R.id.button_verify_otp);
        emailLayout                    = findViewById(R.id.email_layout);
        otpLayout                      = findViewById(R.id.otp_layout);
        LinearLayout navToSignupButton = findViewById(R.id.nav_to_signup_button);

        loginButton.setOnClickListener(this);
        otpButton.setOnClickListener(this);
        navToSignupButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button_login){
            emailLayout.setVisibility(View.GONE);
            otpLayout.setVisibility(View.VISIBLE);
        }
        if(view.getId() == R.id.button_verify_otp){
            emailLayout.setVisibility(View.GONE);
            otpLayout.setVisibility(View.VISIBLE);
            Toast.makeText(this,"verifying you request, please wait..",Toast.LENGTH_SHORT).show();
        }
        if (view.getId() == R.id.nav_to_signup_button)
            startActivity(new Intent(this,RegisterActivity.class));
    }

    @Override
    public void onBackPressed() {
        if(otpLayout.getVisibility() == View.VISIBLE) {
            emailLayout.setVisibility(View.VISIBLE);
            otpLayout.setVisibility(View.GONE);
        }else
            super.onBackPressed();
    }
}