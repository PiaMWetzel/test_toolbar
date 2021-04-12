package com.example.myapplication88;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ComposeMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_message);
        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        ((TextView) findViewById(R.id.nameDisplay)).setText(name);
    }
}