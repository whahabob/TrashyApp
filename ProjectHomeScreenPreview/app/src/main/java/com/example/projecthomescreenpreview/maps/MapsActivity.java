package com.example.projecthomescreenpreview.maps;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.example.projecthomescreenpreview.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap map;
    private SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /*
    private void userLocationFAB(){
        FloatingActionButton FAB = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (locationEnabled) {
                    getCurrentLocation();
                }
            }
        });
    }
    */

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;

        // Invokes the main() method in MapData to generate the waste centres

        MapData.main();

        // Creates a string to be displayed on the map when the marker is selected

        for (WasteCentre centre : MapData.RecyclingCentres) {
            centre.markerString.append("Recycles:");

            // For each Waste Centre, adds (concatonates) each recycled material to the marker string on a new line

            if (centre.MixedGlass)
                centre.markerString.append("\nMixed Glass");

            if (centre.Paper)
                centre.markerString.append("\nPaper");

            if (centre.Cardboard)
                centre.markerString.append("\nCardboard");

            if (centre.Cans)
                centre.markerString.append("\nCans");

            if (centre.Textiles)
                centre.markerString.append("\nTextiles");

            if (centre.Shoes)
                centre.markerString.append("\nShoes");

            if (centre.Plastic)
                centre.markerString.append("\nPlastic");

            if (centre.Cartons)
                centre.markerString.append("\nCartons");

            // Puts a marker for each location on the map, pulling locations from MapData and moving the camera to it

            String markerSnippet = centre.markerString.toString();

            LatLng location = new LatLng(centre.lat, centre.lng);
            MarkerOptions markerOpt = new MarkerOptions().position(location).title(centre.AddressLine1 + ", " + centre.Postcode).snippet(markerSnippet);

            // Set infoWindow adapter view

            map.setInfoWindowAdapter(new CustomInfoWindowAdapter(MapsActivity.this));

            map.addMarker(markerOpt).showInfoWindow();
            map.moveCamera(CameraUpdateFactory.newLatLng(location));

        }
    }
}
