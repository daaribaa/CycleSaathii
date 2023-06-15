package com.example.cycle_saathi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    RecyclerView rcv;

    TextView disTv, timeTv;
    Button homeBtn, sharebtn;
    Double totalDistance, totalTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        /*//need to transfer distance and time from Algo.java
        String dis = getIntent().getStringExtra("TotalDistance");
        String time = getIntent().getStringExtra("TotalTime");
*/
        /*Intent intent = getIntent();
        double dis = intent.getDoubleExtra("TotalDistance", 0.0);
        double time = intent.getDoubleExtra("TotalTime", 0.0);*/

        mainWork();

        disTv = findViewById(R.id.disTV);
        disTv.setText(String.valueOf(totalDistance));

        timeTv = findViewById(R.id.timeTV);
        timeTv.setText(String.valueOf(totalTime));

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

    //Algorithm Ko Kaam
    public void mainWork(){
        List<double[]> coordinates = new ArrayList<>();
        coordinates.add(new double[]{37.7749, -122.4194});
        coordinates.add(new double[]{37.7833, -122.4167});
        coordinates.add(new double[]{37.7881, -122.4075});
        coordinates.add(new double[]{37.7950,-122.3933});
        coordinates.add(new double[]{37.7978, -122.4031});
        coordinates.add(new double[]{37.7942, -122.4105});
        coordinates.add(new double[]{37.7867, -122.4150});
        coordinates.add(new double[]{37.7810, -122.4316});
        coordinates.add(new double[]{37.7904, -122.4008});
        coordinates.add(new double[]{37.7847, -122.4061});
        coordinates.add(new double[]{37.7888, -122.3987});
        coordinates.add(new double[]{37.7925, -122.4056});
        coordinates.add(new double[]{37.7949, -122.4103});
        coordinates.add(new double[]{37.7982, -122.4054});
        coordinates.add(new double[]{37.8025, -122.4132});
        coordinates.add(new double[]{37.7997, -122.4212});
        coordinates.add(new double[]{37.7970, -122.4248});
        coordinates.add(new double[]{37.7944, -122.4315});
        coordinates.add(new double[]{37.7898, -122.4300});
        coordinates.add(new double[]{37.7856, -122.4293});
        coordinates.add(new double[]{37.7815, -122.4282});
        coordinates.add(new double[]{37.7783, -122.4240});
        coordinates.add(new double[]{37.7759, -122.4177});
        coordinates.add(new double[]{37.7732, -122.4111});
        coordinates.add(new double[]{37.7699, -122.4050});
        coordinates.add(new double[]{37.7671, -122.3986});
        coordinates.add(new double[]{37.7640, -122.3919});
        coordinates.add(new double[]{37.7597, -122.3856});
        coordinates.add(new double[]{37.7574, -122.3788});
        coordinates.add(new double[]{37.7552, -122.3719});
        coordinates.add(new double[]{37.7528, -122.3650});
        coordinates.add(new double[]{37.7501, -122.3580});
        coordinates.add(new double[]{37.7474, -122.3510});
        coordinates.add(new double[]{37.7446, -122.3440});
        coordinates.add(new double[]{37.7417, -122.3370});
        coordinates.add(new double[]{37.7387, -122.3300});
        coordinates.add(new double[]{37.7356, -122.3230});
        coordinates.add(new double[]{37.7324, -122.3160});
        coordinates.add(new double[]{37.7291, -122.3089});
        coordinates.add(new double[]{37.7258, -122.3019});
        coordinates.add(new double[]{37.7223, -122.2948});
        coordinates.add(new double[]{37.7188, -122.2877});
        coordinates.add(new double[]{37.7152, -122.2806});
        coordinates.add(new double[]{37.7115, -122.2735});
        coordinates.add(new double[]{37.7078, -122.2663});
        coordinates.add(new double[]{37.7040, -122.2592});
        coordinates.add(new double[]{37.7001, -122.2520});
        coordinates.add(new double[]{37.6961, -122.2448});
        coordinates.add(new double[]{37.6921, -122.2376});
        coordinates.add(new double[]{37.6880, -122.2303});
        coordinates.add(new double[]{37.6838, -122.2231});
        coordinates.add(new double[]{37.6795, -122.2158});
        coordinates.add(new double[]{37.6752, -122.2085});
        coordinates.add(new double[]{37.6708, -122.2012});
        coordinates.add(new double[]{37.6663, -122.1939});
        coordinates.add(new double[]{37.6617, -122.1866});
        coordinates.add(new double[]{37.6571, -122.1792});
        coordinates.add(new double[]{37.6524, -122.1718});
        coordinates.add(new double[]{37.6476, -122.1644});
        coordinates.add(new double[]{37.6428, -122.1569});
        coordinates.add(new double[]{37.6379, -122.1494});
        coordinates.add(new double[]{37.6330, -122.1419});
        coordinates.add(new double[]{37.6280, -122.1344});



        totalDistance = calculateTotalDistance(coordinates);
        totalTime = calcTime(coordinates);
    }

    public static double calculateTotalDistance(List<double[]> coordinates) {
        int numPoints = coordinates.size();
        double totalDistance = 0.0;

        for (int i = 0; i < numPoints - 1; i++) {
            double[] point1 = coordinates.get(i);
            double[] point2 = coordinates.get(i + 1);
            double distance = calculateDistance(point1, point2);
            totalDistance += distance;
        }
        return totalDistance;
    }

    public static double calculateDistance(double[] point1, double[] point2) {
        double lon1 = Math.toRadians(point1[1]);
        double lon2 = Math.toRadians(point2[1]);
        double lat1 = Math.toRadians(point1[0]);
        double lat2 = Math.toRadians(point2[0]);

        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;

        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Earth's radius in kilometers
        double radius = 6371;

        double distance = radius * c;
        return distance;
    }

    public static double calcTime(List<double[]> coordinates){
        double timeInSec = coordinates.size()*2 - 2;
        double time = timeInSec/60;
        return time;
    }
}