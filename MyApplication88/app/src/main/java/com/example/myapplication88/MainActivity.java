package com.example.myapplication88;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void composeMessage(View view){

        Intent intent = new Intent(this, ComposeMessage.class);
        String name = ((Button) view).getText().toString();
        intent.putExtra("NAME", name);
        startActivity(intent);


    }
}