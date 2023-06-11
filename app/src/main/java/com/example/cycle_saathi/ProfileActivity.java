package com.example.cycle_saathi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView nameTV, addressTV, emailTV, contactTV, userNameTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameTV = findViewById(R.id.profileName);
        addressTV = findViewById(R.id.profileAddress);
        emailTV = findViewById(R.id.profileEmail);
        contactTV = findViewById(R.id.profileContact);
        userNameTV = findViewById(R.id.profileUserName);


        /*nameTV.setText();
        addressTV.setText();
        emailTV.setText();
        contactTV.setText();
        userNameTV.setText();*/
    }
}