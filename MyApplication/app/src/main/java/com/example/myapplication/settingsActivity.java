package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class settingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Intent intent = getIntent();
        String s = intent.getStringExtra("cool");
        ((TextView) findViewById(R.id.textView2)).setText(s);
       // Toast.makeText(this, s, Toast.LENGTH_LONG);
    }
}