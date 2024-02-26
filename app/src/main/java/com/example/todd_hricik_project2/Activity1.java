package com.example.todd_hricik_project2;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.core.app.NavUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;

public class Activity1 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    // Declare a Toolbar
    Toolbar toolbar;
    // Declare a NavigationView
    NavigationView navigationView;
    // Declare a drawer layout
    DrawerLayout drawerLayout;
    // Implement the intro fragment
    public static class IntroFragmentActivity1 extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            // Inflate the layout for this fragment;
            View v = inflater.inflate(R.layout.intro_fragment_activity_1, container, false);
            return v;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        /* Check status of any fragments
        // This was recomended by the android dev docs and not by proff. Maybe leave until last if neccessary
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.intro_fragment_activity_1, SplashActivity.class, null)
                    .commit();
        }
        */
        // Might not need this: Declare a container to hold either of the two fragments
        // LinearLayout linearLayoutIntroFragmentContainer = (LinearLayout) findViewById(R.layout.intro_fragment_activity_1);
        // Create the intro fragment
        // introFragmentActivity1 = new IntroFragmentActivity1();
        // Declare a fragment manager for activity 1
        FragmentManager introFragmentManagerActivity1 = getSupportFragmentManager();
        // Declare a FragmentTransaction for activity 1
        FragmentTransaction introFragmentTransactionActivity1 = introFragmentManagerActivity1.beginTransaction();
        // Add a fragment to the activity
        introFragmentTransactionActivity1.add(R.id.framelayout_container_activity_1, new IntroFragmentActivity1());
        // Commit the fragment to the container
        introFragmentTransactionActivity1.commit();

        // Work for drawer via NavigationView
        // Set the NavigationView by id
        navigationView = (NavigationView) findViewById(R.id.navigation_view_activity_1);
        // Set the DrawerView to
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_activity_1);
        // Instantiate a toolbar to be visible on all activities
        toolbar = (Toolbar) findViewById(R.id.my_toolbar_activity1);
        // Set the app bar to the new toolbar
        setSupportActionBar(toolbar);
        // Get a ref to the action bar
        ActionBar ab = getSupportActionBar();
        // Set the title of the app bar
        ab.setTitle("IAmDeeBee");
        // Set the color of the title of the app bar to white
        // ab.setTitleTextColor(getResources().getColor(android.R.color.white));

        // Set up drawer toggle
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(Activity1.this,
                drawerLayout,
                toolbar,
                R.string.open, R.string.close)
        {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                Toast.makeText(Activity1.this, "open", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Toast.makeText(Activity1.this, "close", Toast.LENGTH_SHORT).show();
            }
        };
        navigationView.setNavigationItemSelectedListener(this);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    // Use the prof's code to handle onCreateOptionsMenu(Menu menu) event
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the appbar_menu.xml file
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        // Get handles to the two action bar menu item "1"
        MenuItem action_bar_text_1 = menu.findItem(R.id.action_bar_text_1);
        // Get handles to the two action bar menu item "2"
        MenuItem action_bar_text_2 = menu.findItem(R.id.action_bar_text_2);
        // Get handles to the two action bar menu item "2"
        MenuItem action_bar_text_3 = menu.findItem(R.id.action_bar_text_3);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Get the ItemId of the options item selected
        int itemId = item.getItemId();
        if (itemId == R.id.action_bar_text_1) {
            // Send a toast to let the user know that they are already in activity 1
            Toast.makeText(this, "You are already in Activity 1!!", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.action_bar_text_2) {
            // Create an intent to move to activity 2
            Intent intentActivity2 = new Intent(Activity1.this, Activity2.class);
            startActivity(intentActivity2);
            return true;
        } else if (itemId == R.id.action_bar_text_3) {
            // Create an intent to move to activity 3
            Intent intentActivity3 = new Intent(Activity1.this, Activity3.class);
            startActivity(intentActivity3);
            return true;
        } else if (itemId == androidx.appcompat.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        } else return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.navigation_view_menu_item_activity_2_activity_1) {
            //
            Toast.makeText(this, "clicked drawer item1", Toast.LENGTH_SHORT).show();
            // Create an intent to move to activity 2
            Intent intentActivity2 = new Intent(Activity1.this, Activity2.class);
            startActivity(intentActivity2);
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.navigation_view_menu_item_activity_3_activity_1) {
            //
            Toast.makeText(this, "clicked drawer item2", Toast.LENGTH_SHORT).show();
            // Create an intent to move to activity 3
            Intent intentActivity3 = new Intent(Activity1.this, Activity3.class);
            startActivity(intentActivity3);
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.navigation_view_menu_item_random_madness_activity_1) {
            // Choose a random movie
            Toast.makeText(this, "clicked drawer item3", Toast.LENGTH_SHORT).show();
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
        return false;
    }
}
