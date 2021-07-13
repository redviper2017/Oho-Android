package com.oho.oho.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.card.MaterialCardView;
import com.oho.oho.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        LinearLayout navToLoginButton = findViewById(R.id.nav_to_login_button);
        MaterialCardView signupButton = findViewById(R.id.button_signup);

        navToLoginButton.setOnClickListener(this);
        signupButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.nav_to_login_button)
            startActivity(new Intent(this,LoginActivity.class));
        if (view.getId() == R.id.button_signup)
            startActivity(new Intent(this,CreateProfileActivity.class));
    }
}