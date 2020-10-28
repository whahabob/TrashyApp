package com.example.projecthomescreenpreview;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class TreeActivity extends AppCompatActivity {

    ViewPager viewPager;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree);
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

        //Used for the slider
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        //Changing the color of the word 'plastic' to orange and the color of the word 'glass' to blue
        TextView textview = findViewById(R.id.textMotivationalText);
        String text = (String) textview.getText();
        SpannableString ss = new SpannableString(text);
        ForegroundColorSpan fcsOrange = new ForegroundColorSpan(Color.rgb(255,130,0));
        ForegroundColorSpan fcsBlue = new ForegroundColorSpan(Color.BLUE);
        ss.setSpan(fcsOrange, 41, 48, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(fcsBlue, 62, 67, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textview.setText(ss);

        //Setting the functionality of the shareButton
        bt = (Button)findViewById(R.id.shareButton);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "My recycling behaviour has the same impact on the environment as" +
                        " planting 0,4 trees! I obtained this knowledge by using the app 'Trashy'." +
                        " It is an app that helps you to recycle and rewards you for it!";
                String shareSub = "Trashy";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(myIntent, "Share using:"));
            }
        });
    }
}