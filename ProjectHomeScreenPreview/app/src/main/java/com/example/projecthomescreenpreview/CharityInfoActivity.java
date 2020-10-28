package com.example.projecthomescreenpreview;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class CharityInfoActivity extends AppCompatActivity {

    private SectionStatePagerAdapter mSectionStatePagerAdapter;
    private ViewPager mViewPager;


   @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity_info);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

       mSectionStatePagerAdapter = new SectionStatePagerAdapter(getSupportFragmentManager());
       mViewPager = (ViewPager) findViewById(R.id.view2);
       // set up pager
       setupViewPager(mViewPager);

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


    }

