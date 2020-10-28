package com.example.projecthomescreenpreview;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;

public class BarcodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);
        //Top nav bar
        BottomNavigationView topNavView = findViewById(R.id.nav_viewTop);
        BottomNavigationView bottomNavView = findViewById(R.id.nav_view);
        topNavView.setSelectedItemId(R.id.navigation_appname);
        final Intent intentProfile = new Intent(this, ProfileActivity.class);
        final Intent intentTree = new Intent(this, TreeActivity.class);
        final Intent intentMain = new Intent(this, MainActivity.class);

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
        bottomNavView.setSelectedItemId(R.id.navigation_home);
        bottomNavView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_barcode:
                                item.setCheckable(false);
                                System.out.println("Stay on page (test message)");
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
    }

}
