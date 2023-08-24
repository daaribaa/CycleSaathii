package com.example.cycle_saathi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;

import android.content.Context;
import android.content.Intent;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.overlay.Marker;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class OsmMapActivity extends AppCompatActivity implements LocationListener {

    private MapView map;
    private IMapController mapController;
    private static final String TAG = "LatLong";
    private static final int PERMISSION_REQUEST_CODE = 1;
    private LocationManager locationManager;
    private LocationListener locationListener;
    MyLocationNewOverlay mLocationOverlay;
    Button stopBtn;

    private Timer locationTimer;
    private TimerTask locationTask;


    public List<double[]> coordinates = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_osm_map);

        //handle permissions first, before map is created. not depicted here

        File directory = new File("/storage/emulated/0/osmdroid/tiles");
        if (!directory.exists()) {
            boolean success = directory.mkdirs();
            if (!success) {
                // Directory creation failed, handle the error
            }
        }


        //load/initialize the osmdroid configuration, this can be done
        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));


        //inflate and create the map
        map = findViewById(R.id.mapView);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);
        mapController = map.getController();
        mapController.setZoom(20);


        stopBtn = findViewById(R.id.stopBtn);
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(OsmMapActivity.this, DetailsActivity.class);
                in.putExtra("coordinatesList", coordinates.toArray(new double[0][]));
                startActivity(in);
            }
        });


        // Check if location permission is granted
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            initializeLocationManager();
            //startLocationUpdates();
        } else {
            // Request location permission from the user
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSION_REQUEST_CODE);
        }
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // Request location updates with a desired time and distance interval
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, this);


    }


    private void initializeLocationManager() {
        if (locationManager != null) {
            // Check if location permission is granted
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                startLocationUpdates();
            } else {
                // Request location permission from the user
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        PERMISSION_REQUEST_CODE);
            }
        } else {
            System.out.println("No Location Manager");
        }
    }

    private void startLocationUpdates() {
        locationTimer = new Timer();
        locationTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    if (lastKnownLocation != null) {
                        // Get the latitude and longitude from the last known location
                        double latitude = lastKnownLocation.getLatitude();
                        double longitude = lastKnownLocation.getLongitude();

                        coordinates.add(new double[]{latitude,longitude});

                        // Print the latitude and longitude in the logcat
                        Log.d(TAG, "Latitude: " + latitude + ", Longitude: " + longitude);

                        // Use the obtained latitude and longitude here
                        // Update the map view or perform other actions based on the current location
                    }
                } catch (SecurityException e) {
                    e.printStackTrace();
                }
            }
        };

        // Schedule the location updates every 2 seconds
        locationTimer.scheduleAtFixedRate(locationTask, 0, 2000);
    }


    public void onResume() {
        super.onResume();
        if (map != null)
            map.onResume(); // Resume the map view

    }

    public void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);

        // Cancel the location updates
        if (locationTimer != null) {
            locationTimer.cancel();
            locationTimer = null;
        }
        if (locationTask != null) {
            locationTask.cancel();
            locationTask = null;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Location permission granted, start location updates
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, this);
                }
            } else {
                // Location permission denied, handle accordingly
                // You can display a message or take alternative actions
            }
        }
    }


    //LOCATION LISTENER METHODS
    @Override
    public void onLocationChanged(Location location) {
        // Handle the updated location here
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();

        coordinates.add(new double[]{latitude,longitude});

        Log.d(TAG, coordinates.toString());
        // Use the obtained latitude and longitude to update the map view or perform other actions


        // Create a new marker with the updated location
        Marker marker = new Marker(map);
        marker.setPosition(new GeoPoint(latitude, longitude));
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(marker);

        // Refresh the map view to display the marker
        map.invalidate();
    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // Handle location provider status changes here
    }
    @Override
    public void onProviderEnabled(String provider) {
        // Handle location provider enabled here
    }
    @Override
    public void onProviderDisabled(String provider) {
        // Handle location provider disabled here
    }
    @Override
    public void onLocationChanged(@NonNull List<Location> locations) {
        LocationListener.super.onLocationChanged(locations);
    }
    @Override
    public void onFlushComplete(int requestCode) {
        LocationListener.super.onFlushComplete(requestCode);
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

}