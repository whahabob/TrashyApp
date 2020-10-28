package com.example.projecthomescreenpreview;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.View;
import android.widget.Button;

public class CharityInfoActivity extends AppCompatActivity {

    private SectionStatePagerAdapter mSectionStatePagerAdapter;
    private ViewPager mViewPager;


   @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionStatePagerAdapter = new SectionStatePagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.view2);
        // set up pager
        setupViewPager(mViewPager);
    }
        private void setupViewPager(ViewPager viewPager){
            SectionStatePagerAdapter adapter = new SectionStatePagerAdapter(getSupportFragmentManager());
            adapter.addFragment(new CharityDetailsFragment(), "CharityDetailsFragment");
            adapter.addFragment(new Charity1InfoFragment(), "Charity1InfoFragment");
            adapter.addFragment(new Charity2InfoFragment(), "Charity2InfoFragment");

            viewPager.setAdapter(adapter);
        }

        public void setViewPager(int fragmentNumber)
    {
        mViewPager.setCurrentItem(fragmentNumber);
    }
   /*
    @Override
    /*
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    */

        //        Charity1InfoFragment Charity1InfoFragment = new Charity1InfoFragment();
//        FragmentManager fm = getSupportFragmentManager();
//
//        fm.beginTransaction().add(R.id.layout, Charity1InfoFragment).commit();

    }

