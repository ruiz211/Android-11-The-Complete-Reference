package com.ruiz211.androidbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Init MainActivity");

        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.honda);
    }

    public void openSecondActivity(View view) {
        String message = "Message from MainActivity";
        Intent intent = new Intent(this, SecondActivity.class);
//        intent.setData();
        startActivity(intent);
    }
}