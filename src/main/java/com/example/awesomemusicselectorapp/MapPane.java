package com.example.awesomemusicselectorapp;

import android.annotation.TargetApi;
import android.location.Location;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import com.example.awesomemusicselectorapp.R;

public class MapPane extends ActionBarActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    private LatLng loc;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_pane);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mMap = mapFragment.getMap();
        mMap.setMyLocationEnabled(true);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_map_pane, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(final GoogleMap map) {
        mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
                loc = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(loc));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 12));
                map.addMarker(new MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_record))
                        .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
                        .position(new LatLng(41.889, -87.622)));
            }
        });


        //map.moveCamera(CameraUpdateFactory.newLatLngZoom((new LatLng(41.889, -87.622)), 10));


        // You can customize the marker image using images bundled with
        // your app, or dynamically generated bitmaps.

    }
}
