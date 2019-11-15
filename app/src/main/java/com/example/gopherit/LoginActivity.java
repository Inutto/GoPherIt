package com.example.gopherit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLogin(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        // finish this activity, so the user can't return using the back button
        finish();
    }
}
