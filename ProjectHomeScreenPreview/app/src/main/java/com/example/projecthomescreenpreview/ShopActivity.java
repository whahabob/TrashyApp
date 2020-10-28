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
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ShopActivity extends AppCompatActivity {
    ImageButton imageButton_Charity;
    ImageButton imageButton_Technology;
    Button btn_Home;
    Button btn_CashOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        //Top nav bar
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
                                //Do nothing
                                break;
                            case R.id.navigation_tree:
                                //startActivity(intentTree);
                                item.setCheckable(false);
                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + item.getItemId());
                        }
                        return true;
                    }
                });








        Button btn_CashOut = findViewById(R.id.btn_CashOut);
        btn_CashOut.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfileActivity();
            }
        });

        Button btn_Home = findViewById(R.id.btn_Home);
        btn_Home.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        imageButton_Charity = (ImageButton) findViewById(R.id.imageButton_Charity);
        imageButton_Charity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCharityInfoActivity();
            }
        });


         
    }
    private void openProfileActivity(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);

    }
    private void openCharityInfoActivity() {
        Intent intent = new Intent(ShopActivity.this, CharityInfoActivity.class);
        startActivity(intent);
    };

    private void openMainActivity() {
        Intent intent = new Intent(ShopActivity.this, MainActivity.class);
        startActivity(intent);
    };
}

