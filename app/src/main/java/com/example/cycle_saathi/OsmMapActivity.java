package com.example.cycle_saathi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.io.File;
import java.util.List;

public class OsmMapActivity extends AppCompatActivity implements LocationListener {

    private MapView map;
    private IMapController mapController;

    private static final String TAG = "OsmActivity";


    private static final int PERMISSION_REQUEST_CODE = 1;

    private LocationManager locationManager;
    private LocationListener locationListener;
    MyLocationNewOverlay mLocationOverlay;

    Button stopBtn;

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
        //setting this before the layout is inflated is a good idea
        //it 'should' ensure that the map has a writable location for the map cache, even without permissions
        //if no tiles are displayed, you can try overriding the cache path using Configuration.getInstance().setCachePath
        //see also StorageUtils
        //note, the load method also sets the HTTP User Agent to your application's package name, abusing osm's tile servers will get you banned based on this string

        /*  if (BuildConfig.VERSION.SDK_INT >= 23) {
            if (isStoragePermissionGranted()){

            }
        }*/

        //inflate and create the map
        map = findViewById(R.id.mapView);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);
        mapController = map.getController();
        mapController.setZoom(20);
        GeoPoint startPoint = new GeoPoint(27.6940685,85.2780092);
        mapController.setCenter(startPoint);


        stopBtn = findViewById(R.id.stopBtn);
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(OsmMapActivity.this, DetailsActivity.class);
                startActivity(in);
            }
        });

        /*this.mLocationOverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(OsmMapActivity.this),map);
        this.mLocationOverlay.enableMyLocation();
        map.getOverlays().add(this.mLocationOverlay);*/

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
        try {
            // Request location updates with a desired time and distance interval
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, this);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    public void onResume() {
        super.onResume();
        if (map != null)
            map.onResume(); // Resume the map view

    }


    public void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }


    /*public boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG, "Permission is granted");
                return true;
            } else {

                Log.v(TAG, "Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG, "Permission is granted");
            return true;
        }
    }*/

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.v(TAG, "Permission: " + permissions[0] + "was " + grantResults[0]);
            //resume tasks needing this permission
        }
    }


    //LOCATION LISTENER METHODS
    @Override
    public void onLocationChanged(Location location) {
        // Handle the updated location here
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        Log.println(Log.ERROR,"msg","latitude = "+latitude);
        Log.println(Log.ERROR,"msg","Longitude = "+longitude);

        // Use the obtained latitude and longitude to update the map view or perform other actions
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