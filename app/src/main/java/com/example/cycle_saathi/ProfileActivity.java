package com.example.cycle_saathi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView nameTV, addressTV, emailTV, contactTV, userNameTV;
    Button homeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameTV = findViewById(R.id.profileName);
        addressTV = findViewById(R.id.profileAddress);
        emailTV = findViewById(R.id.profileEmail);
        contactTV = findViewById(R.id.profileContact);
        userNameTV = findViewById(R.id.profileUserName);

        homeBtn = findViewById(R.id.profileToHome);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(ProfileActivity.this, HomePageActivity.class);
                startActivity(in);
            }
        });


        /*nameTV.setText();
        addressTV.setText();
        emailTV.setText();
        contactTV.setText();
        userNameTV.setText();*/
    }
}