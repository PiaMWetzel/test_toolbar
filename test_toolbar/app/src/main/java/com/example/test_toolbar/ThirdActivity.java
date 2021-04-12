package com.example.test_toolbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent intent = getIntent();

        String nm = intent.getStringExtra("username");

        ((TextView) findViewById(R.id.textView8)).setText("Welcome, " + nm +". You are great!");
    }
}