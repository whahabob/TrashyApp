package com.example.projecthomescreenpreview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //Nav bars
        BottomNavigationView bottomNavView = findViewById(R.id.nav_view);
        BottomNavigationView topNavView = findViewById(R.id.nav_viewTop);
        topNavView.setSelectedItemId(R.id.navigation_appname);
        final Intent intentProfile = new Intent(this, ProfileActivity.class);
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
                                //Do nothing
                                break;
                            case R.id.navigation_tree:
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

        VideoView videoView = findViewById(R.id.videoView);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);


    }

}
