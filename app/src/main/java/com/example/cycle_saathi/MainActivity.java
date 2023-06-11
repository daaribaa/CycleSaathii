package com.example.cycle_saathi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView cs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cs = findViewById(R.id.logo);

        Intent in = new Intent(MainActivity.this, LoginPageActivity.class);
        startActivity(in);

    }
}