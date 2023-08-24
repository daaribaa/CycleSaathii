package com.example.cycle_saathi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HomePageActivity extends AppCompatActivity {

    Button btnRecord, profileBtn, aboutUsBtn;
    ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ivLogo = findViewById(R.id.hpLogo);

        btnRecord = findViewById(R.id.btnRecord);
        btnRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(HomePageActivity.this, OsmMapActivity.class);
                startActivity(in);
            }
        });

        profileBtn = findViewById(R.id.profileBtn);
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(HomePageActivity.this, ProfileActivity.class);
                startActivity(in);
            }
        });

        aboutUsBtn =  findViewById(R.id.aboutUsBtn);
        aboutUsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(HomePageActivity.this, AboutUsActivity.class);
                startActivity(in);
            }
        });
    }
}