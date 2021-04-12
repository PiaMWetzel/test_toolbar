package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void handleText(View view){

        String input = ((TextView) findViewById(R.id.source)).getText().toString();
        ((TextView) findViewById(R.id.hello)).setText(input);
        Log.d("info", input);
        Toast.makeText(this, "Alert", Toast.LENGTH_LONG).show();
    }


    public void disable(View view){
        //code
        Log.d("success","HELLO WORLD");
        //view.setEnabled(false);
        Button button = (Button) view;
        button.setText("changed text");

        ((Button) findViewById(R.id.button2)).setText("hehe, changed");

    }

    public void changeMyText(View view){
        TextView text = findViewById(R.id.my_txt);
        text.setText("This text was changed");
    }

    public void launchSettings(View view){
        //launch new activity
        Intent intent = new Intent(this, settingsActivity.class);
        intent.putExtra("cool", "hello, this intent had some extra");
        startActivity(intent);

    }
}