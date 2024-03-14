package com.example.todd_hricik_project2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class Activity3 extends AppCompatActivity {
//    Toolbar myToolbar;
    // ArrayList<Movie> movie_list;
    MovieData movieData;
    ViewPagerAdapterActivity3 viewPagerAdapterActivity3;
    ViewPager2 viewPager;
    public class DepthPageTransformer implements ViewPager2.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            if (position < -1) {
                view.setAlpha(0);
                ;
            } else if (position <= 0) {
                view.setAlpha(1);
                view.setTranslationX(0);
                view.setScaleX(1);
                view.setScaleY(1);
            } else if (position <= 1) {
                view.setAlpha(1 - position);
                view.setTranslationX(pageWidth * -position);
                float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);
            } else {
                view.setAlpha(0);
            }
        }
    }


/*
    public class ZoomOutPageTransformer implements ViewPager.PageTransformer{

    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        // movie_list = new ArrayList<Movie>();
        movieData = new MovieData();
        // viewPagerAdapterActivity3 = new ViewPagerAdapterActivity3(getSupportFragmentManager(), movieData);
        viewPagerAdapterActivity3 = new ViewPagerAdapterActivity3(this, movieData);
        viewPager = (ViewPager2) findViewById(R.id.viewpager_activity3);
        viewPager.setAdapter(viewPagerAdapterActivity3);
        // viewPager.setPageTransformer(true, new DepthPageTransformer());
        viewPager.setPageTransformer((ViewPager2.PageTransformer) (new DepthPageTransformer()));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout_activity3);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(movieData.getItem(position).name)).attach();
        // tabLayout.setupWithViewPager(viewPager);

        // Instantiate a toolbar to be visible on all activities
        // myToolbar = (Toolbar) findViewById(R.id.my_toolbar_activity3);
        // Set the app bar to the new toolbar
        // setSupportActionBar(myToolbar);
        // Get a ref to the action bar
        // ActionBar ab = getSupportActionBar();
        // Enanble the back button to take you back to home
        // ab.setDisplayHomeAsUpEnabled(true);
        // Set the title of the app bar
        // ab.setTitle("IAmDeeBee");
        // Set the color of the title of the app bar to white
        // ab.setTitleTextColor(getResources().getColor(android.R.color.white));

    }
/*
    // Use the prof's code to handle onCreateOptionsMenu(Menu menu) event
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the appbar_menu.xml file
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        // Get handles to the two action bar menu item "1"
        MenuItem action_bar_text_1 = menu.findItem(R.id.action_bar_text_1);
        // Get handles to the two action bar menu item "1"
        MenuItem action_bar_text_2 = menu.findItem(R.id.action_bar_text_2);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Get the ItemId of the options item selected
        int itemId = item.getItemId();

        if (itemId == R.id.action_bar_text_1) {
            // Create an intent to move to activity 1
            Intent intentActivity1 = new Intent(Activity3.this, Activity1.class);
            startActivity(intentActivity1);
            return true;
        } else if (itemId == R.id.action_bar_text_2) {
            // Create an intent to move to activity 2
            Intent intentActivity2 = new Intent(Activity3.this, Activity2.class);
            startActivity(intentActivity2);
            return true;
        } else if (itemId == R.id.action_bar_text_3) {
            // Send a toast to let the user know that they are already in activity 3
            Toast.makeText(this, "You are already in Activity 3!!", Toast.LENGTH_SHORT).show();
            return true;
        }else if (itemId == androidx.appcompat.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        else return super.onOptionsItemSelected(item);
    }
*/
    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0){
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish9) on theis activity and pops the back stack
            super.onBackPressed();
        } else {
            // Otherwise select the previous step.
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }
}


