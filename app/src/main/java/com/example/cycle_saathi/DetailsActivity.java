package com.example.cycle_saathi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    RecyclerView rcv;
    Button homeBtn, sharebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        rcv = findViewById(R.id.rvDetails);
        //ArrayList<DetailsDTO> detailsDTO = new ArrayList<>();
        LinearLayoutManager lin = new LinearLayoutManager(DetailsActivity.this);
        rcv.setLayoutManager(lin);
        DetailsAdapter dAdapter = new DetailsAdapter("15Km", "1:30", "40kmph", "300");
        rcv.setAdapter(dAdapter);

        homeBtn = findViewById(R.id.goToHomePage);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(DetailsActivity.this,HomePageActivity.class);
                startActivity(in);
            }
        });

        sharebtn = findViewById(R.id.sharebtn);
        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailsActivity.this,"Share options not available now",Toast.LENGTH_LONG);

            }
        });
    }
}