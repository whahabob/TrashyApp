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

public class ShopActivity extends AppCompatActivity {
    ImageButton imageButton_Charity;
    private Button btn_CashOut;
    // above 07/10
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
                                System.out.println("kom hier gewoon");
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


//Button with Lambada that links this activity to the profile activity
// Not used as it requires lambada to be selected and configured
        /*Button btn_CashOut = findViewById(R.id.btn_CashOut);
        btn_CashOut.setOnClickListener(v -> {

            //btn_CashOut.setOnClickListener(v -> {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        });
        */

        Button btn_CashOut = findViewById(R.id.btn_CashOut);
        btn_CashOut.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfileActivity();
            }
        });

        imageButton_Charity = (ImageButton) findViewById(R.id.imageButton_Charity);
        imageButton_Charity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBuyingActivity();


            }
        });
    }
    private void openProfileActivity(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);

    }
    private void openBuyingActivity() {
        Intent intent = new Intent(ShopActivity.this, BuyingActivity.class);
        startActivity(intent);

    };
}

