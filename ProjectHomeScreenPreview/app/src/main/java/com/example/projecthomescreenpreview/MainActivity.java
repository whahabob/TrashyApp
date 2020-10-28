package com.example.projecthomescreenpreview;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.projecthomescreenpreview.maps.MapsActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        BottomNavigationView topNavView = findViewById(R.id.nav_viewTop);

        topNavView.setSelectedItemId(R.id.navigation_appname);
        final Intent intentInfo = new Intent(this, InfoActivity.class);
        final Intent intentProfile = new Intent(this, ProfileActivity.class);
        final Intent intentPickup = new Intent(this, PickupActivity.class);
        final Intent intentMaps = new Intent(this, MapsActivity.class);
        final Intent intentShop = new Intent(this, ShopActivity.class);
        final Intent intentCalander = new Intent(this, CalanderActivity.class);
        final Intent intentTree = new Intent(this, TreeActivity.class);
        final Intent intentMain = new Intent(this, MainActivity.class);
        final Intent intentBarcode = new Intent(this, BarcodeActivity.class);



        topNavView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_profile:
                                startActivity(intentProfile);
                                item.setCheckable(false);
                                break;
                            case R.id.navigation_appname:
                                System.out.println("kom hier gewoon");
                                break;
                            case R.id.navigation_tree:
                                startActivity(intentTree);
                                item.setCheckable(false);
                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + item.getItemId());
                        }
                        return true;
                    }
                });
        navView.setSelectedItemId(R.id.navigation_home);
        navView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_barcode:
                                item.setCheckable(false);
                                startActivity(intentBarcode);
                                break;
                            case R.id.navigation_home:
                                item.setCheckable(false);
                                startActivity(intentMain);
                                break;
                            case R.id.navigation_notifications:
                                item.setCheckable(false);
                                startActivity(intentMain);
                                break;
                        }
                        return true;
                    }
                });

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
       /*
            AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
            R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
            .build();
        */

        CreateOnClickListeners();
    }

    private void CreateOnClickListeners()
    {
        Button btn_TL = findViewById(R.id.imageButton_topLeft);
        ImageButton btn_DL = findViewById(R.id.imageButton_downLeft);
        ImageButton btn_TR = findViewById(R.id.imageButton_topRight);
        ImageButton btn_MR = findViewById(R.id.imageButton_middleRight);
        ImageButton btn_BR = findViewById(R.id.imageButton_bottomRight);


        btn_TL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topLeft_OnClick(v);
            }
        });

        btn_DL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downLeft_OnClick(v);
            }
        });

        btn_TR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topRight_OnClick(v);
            }
        });

        btn_MR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                middleRight_OnClick(v);
            }
        });

        btn_BR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomRight_OnClick(v);
            }
        });
    }

    private void topRight_OnClick(View v) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    private void middleRight_OnClick(View v) {
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

    private void downLeft_OnClick(View v) {
        Intent intent = new Intent(this, ShopActivity.class);
        startActivity(intent);
    }

    private void bottomRight_OnClick(View v) {
        Intent intent = new Intent(this, PickupActivity.class);
        startActivity(intent);
    }

    public void topLeft_OnClick(View v) {
        Intent intent = new Intent(this, CalanderActivity.class);
        startActivity(intent);

    }

}
