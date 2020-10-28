package com.example.projecthomescreenpreview;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;

public class PickupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup);

        BottomNavigationView topNavView = findViewById(R.id.nav_viewTop);

        topNavView.setSelectedItemId(R.id.navigation_appname);
        final Intent intentProfile = new Intent(this, ProfileActivity.class);
        final Intent intentTree = new Intent(this, TreeActivity.class);

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


    }

}
