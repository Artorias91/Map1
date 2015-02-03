package com.example.mattia.map1;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
/*
public class MapsActivity extends FragmentActivity {
    GoogleMap mMap;
    GMapV2Direction md;

    LatLng fromPosition = new LatLng(39.297694, 9.212160);
    LatLng toPosition = new LatLng(39.296398, 9.210594);




    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        md = new GMapV2Direction();
        mMap = ((MapFragment) getFragmentManager()
                .findFragmentById(R.id.map)).getMap();

        LatLng coordinates = new LatLng(39.296502, 9.212464);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 16));


        mMap.addMarker(new MarkerOptions().position(fromPosition).title("Start"));
        mMap.addMarker(new MarkerOptions().position(toPosition).title("End"));

        Document doc = md.getDocument(fromPosition, toPosition, GMapV2Direction.MODE_WALKING);
        int duration = md.getDurationValue(doc);
        String distance = md.getDistanceText(doc);
        String start_address = md.getStartAddress(doc);
        String copy_right = md.getCopyRights(doc);

        ArrayList<LatLng> directionPoint = md.getDirection(doc);
        PolylineOptions rectLine = new PolylineOptions().width(3).color(Color.RED);

        for(int i = 0 ; i < directionPoint.size() ; i++) {
            rectLine.add(directionPoint.get(i));
        }

        mMap.addPolyline(rectLine);
        mMap.getUiSettings().setZoomControlsEnabled(true);
    }
}
*/



public class MapsActivity extends FragmentActivity
//    implements OnMapReadyCallback
{

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();

//        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        //add a marker on map
//        this.onMapReady(mMap);

        //make a marker draggable on map
//        mMap.addMarker(new MarkerOptions()
//                .position(new LatLng(20,20))
//                .draggable(true));


    }


//    @Override
//    public void onMapReady(GoogleMap map) {
//        map.addMarker(new MarkerOptions()
//                .position(new LatLng(10,10))
//                .title("Hello world"));
//    }


    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }




    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
//            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
//                    .getMap();
            mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                    .getMap();

            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }


    private void setUpMap() {

//        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));

        Marker start = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(39.297660, 9.212102))
                .title("start"));

        Marker end = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(39.295601, 9.210106))
                .title("end"));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(39.296763, 9.210728), 16));

//        mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 20, null);


//        mMap.setTrafficEnabled(true);
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);

    }
}



