package com.example.projecthomescreenpreview;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

public class TreeActivity extends AppCompatActivity {

    ViewPager viewPager;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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