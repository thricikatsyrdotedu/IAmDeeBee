package com.example.todd_hricik_project2;

import static android.text.TextUtils.replace;
import static androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN;

import static com.example.todd_hricik_project2.MovieFragmentActivity3.ARG_PARAM1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class Activity2 extends AppCompatActivity implements RecyclerItemClickListener {
    /* ---------------------- Declare some activity scoped variables -----------------------*/
    Toolbar toolbar;
    private RecyclerView recycler_view;
    private SimpleRecyclerAdapter adapter_items;
    private boolean twoPane;
    private MovieData movieData;
    /* ---------------------- End Declare some activity scoped variables -----------------------*/



    /* -------------- Begin Work on onCreate() method of Activity 2 --------------------------------*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        if(savedInstanceState==null)
        {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setReorderingAllowed(true);
            fragmentTransaction.add(R.id.main_container, new MainFragmentActivity2())
                    .addToBackStack(null).commit();
        }

        // Create an instance of the MovieData class
        movieData = new MovieData();
        twoPane = false;
        // check to see if there is a detail container available
        if(findViewById(R.id.detail_container) != null)
        {
            twoPane = true;
        }
        /* -------------------- Work for fragments in Activity 2 onCreate() --------------------------- */
        // Declare a main fragment for the master container
        // MovieFragmentActivity2 movieFragmentActivity2 =  MovieFragmentActivity2.newInstance(1, "A", "A", "A", "A");
        // MainFragmentActivity2 mainFragmentActivity2 =  MainFragmentActivity2.newInstance(1, "A", "A", "A", "A");

        // Declare a fragment manager for activity 2
//        FragmentManager fragmentManager = getSupportFragmentManager();
        // Declare a FragmentTransaction for activity 2
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Add a fragment to the activity
//        fragmentTransaction.setReorderingAllowed(true)
//                 .add(R.id.main_container, new MainFragmentActivity2(), null).addToBackStack(null);
        // Commit the fragment to the container
//        fragmentTransaction.commit();
        // Add a movie fragment to the detail fragment if on a large two pane screen
        // if(twoPane) {
            // Put a movie fragment in the detail fragment view
        // }
        /* -------------------- End Work for fragments in Activity 1 onCreate() --------------------------- */

        // -------------------- Work on Toolbar -------------------------------------------------
        // Instantiate a toolbar to be visible on all activities
//        toolbar = (Toolbar) findViewById(R.id.my_toolbar_activity2);
        // Set the app bar to the new toolbar
//        setSupportActionBar(toolbar);
        // Get a ref to the action bar
//        ActionBar ab = getSupportActionBar();
        // Enanble the back button to take you back to home
//        ab.setDisplayHomeAsUpEnabled(true);
        // Set the title of the app bar
//        ab.setTitle("IAmDeeBee");
        // Set the color of the title of the app bar to white
        // ab.setTitleTextColor(getResources().getColor(android.R.color.white));
        // -------------------------- End Work on Toolbar ---------------------------------------

        // -------------------------- Work on RecyclerView -------------------------------------
    /*
        recycler_view = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recycler_view.setLayoutManager(layoutManager);
        adapter_items = new SimpleRecyclerAdapter();
        adapter_items.setOnItemClickListener(this);
        recycler_view.setAdapter(adapter_items);
    */
        // ------------------------ End Work on RecyclerView -----------------------------------
    }

    @Override
    public void onItemClick(View shared_view, Movie movie) {
            // MainFragmentActivity2 detailFragment = new MainFragmentActivity2();
            Fragment detailFragment = new MovieFragmentActivity2();
            Bundle args = new Bundle();
            args.putString("param1", movie.name);
            args.putString("param2", movie.year);
            args.putInt("param3", movie.resource_id);
            args.putString("param4", movie.url);
            args.putString("param5", movie.desc);
            detailFragment.setArguments(args);
            // Get a handle on another fragment designed for a movie
            // MovieFragmentActivity2 movieFragment = MovieFragmentActivity2
            //        .newInstance(movie.name, movie.year, movie.resource_id,
            //                 movie.url, movie.desc);

            // Declare a fragment manager
            FragmentManager fragmentManager = getSupportFragmentManager();
            // Declare a fragmentTransaction
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            // Swap the previous fragment out and the new movie fragment fragment in
            if(twoPane) {
                // Don't worry about transtion for now
                detailFragment.setEnterTransition(new Slide(Gravity.TOP));
                // Don't worry about transtion for now
                detailFragment.setExitTransition(new Slide(Gravity.BOTTOM));
                // Replace the old fragment in the main container with a new fragment
                getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                        .replace(R.id.detail_container, detailFragment).addToBackStack(null).commit();
            }
            else {
                // Don't worry about transtion for now
                detailFragment.setEnterTransition(new Fade());
                // Don't worry about transtion for now
                detailFragment.setExitTransition(new Fade());
                // Don't worry about transtion for now
                // detailFragment.setSharedElementReturnTransition(new DetailsTransition());
                getSupportFragmentManager().beginTransaction()
//                        .addSharedElement(shared_view, Objects.requireNonNull(ViewCompat.getTransitionName(shared_view)))
                        .replace(R.id.main_container, detailFragment).addToBackStack(null).commit();
                // Replace the old fragment with a new one
//            fragmentTransaction.setReorderingAllowed(true).replace(R.id.detail_container, movieFragment );
            }
            // fragmentTransaction.setTransition( TRANSIT_FRAGMENT_OPEN );
            // Commit the fragment to the container where TRANSIT_FRAGMENT_OPEN is some constant value
            fragmentTransaction.commit();
            // Toast t= Toast.makeText(getApplicationContext(),"Click pos"+Integer.toString(position), Toast.LENGTH_SHORT);
            // t.show();
        }

    @Override
    public void onItemLongClick(View v, int position) {

    }
    // Use the prof's code to handle onCreateOptionsMenu(Menu menu) event
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        // Inflate the appbar_menu.xml file
//        getMenuInflater().inflate(R.menu.appbar_menu, menu);
//        // Get handles to the two action bar menu item "1"
//        MenuItem action_bar_text_1 = menu.findItem(R.id.action_bar_text_1);
//        // Get handles to the two action bar menu item "1"
//        MenuItem action_bar_text_2 = menu.findItem(R.id.action_bar_text_2);
//        return true;
//    }
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        // Get the ItemId of the options item selected
//        int itemId = item.getItemId();
//        if (itemId == R.id.action_bar_text_1) {
//            // Send a toast to let the user know that they are already in activity 1
//            Intent intentActivity2 = new Intent(Activity2.this, Activity1.class);
//            startActivity(intentActivity2);
//            return true;
//        } else if (itemId == R.id.action_bar_text_2) {
//            // Send a toast to let the user know that they are already in activity 2
//            Toast.makeText(this, "You are already in Activity 2!!", Toast.LENGTH_SHORT).show();
//            return true;
//        }  else if (itemId == R.id.action_bar_text_3) {
//            // Create an intent to move to activity 3
//            Intent intentActivity3 = new Intent(Activity2.this, Activity3.class);
//            startActivity(intentActivity3);
//            return true;
//        } else if (itemId == androidx.appcompat.R.id.home) {
//            NavUtils.navigateUpFromSameTask(this);
//            return true;
//        }
//        else return super.onOptionsItemSelected(item);
//    }

    /*
    @Override
    public void onItemClick(View shared_view, Movie movie) {
        // MainFragmentActivity2 detailFragment = new MainFragmentActivity2();
        MovieFragmentActivity2 detailFragment = new MovieFragmentActivity2();
        Bundle args = new Bundle();
        args.putString("param1", movie.name);
        args.putString("param2", movie.year);
        args.putInt("param3", movie.resource_id);
        args.putString("param4", movie.url);
        args.putString("param5", movie.desc);
        detailFragment.setArguments(args);
        // Get a handle on another fragment designed for a movie
        // MovieFragmentActivity2 movieFragment = MovieFragmentActivity2
        //        .newInstance(movie.name, movie.year, movie.resource_id,
        //                 movie.url, movie.desc);

        // Declare a fragment manager
        FragmentManager fragmentManager = getSupportFragmentManager();
        // Declare a fragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Swap the previous fragment out and the new movie fragment fragment in
        if(twoPane) {
            // Don't worry about transtion for now
            detailFragment.setEnterTransition(new Slide(Gravity.TOP));
            // Don't worry about transtion for now
            detailFragment.setExitTransition(new Slide(Gravity.BOTTOM));
            // Replace the old fragment in the main container with a new fragment
            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                    .replace(R.id.detail_container, detailFragment).addToBackStack(null).commit();
        }
        else {
            // Don't worry about transtion for now
            detailFragment.setEnterTransition(new Fade());
            // Don't worry about transtion for now
            detailFragment.setExitTransition(new Fade());
            // Don't worry about transtion for now
            // detailFragment.setSharedElementReturnTransition(new DetailsTransition());
            getSupportFragmentManager().beginTransaction()
                    .addSharedElement(shared_view, Objects.requireNonNull(ViewCompat.getTransitionName(shared_view)))
                            .replace(R.id.main_container, detailFragment).addToBackStack(null).commit();
            // Replace the old fragment with a new one
//            fragmentTransaction.setReorderingAllowed(true).replace(R.id.detail_container, movieFragment );
        }
        // fragmentTransaction.setTransition( TRANSIT_FRAGMENT_OPEN );
        // Commit the fragment to the container where TRANSIT_FRAGMENT_OPEN is some constant value
        fragmentTransaction.commit();
        // Toast t= Toast.makeText(getApplicationContext(),"Click pos"+Integer.toString(position), Toast.LENGTH_SHORT);
        // t.show();
    }
    */
    /*
    @Override
    public void onItemLongClick(View v, int position) {
        adapter_items.removeMovie(position);
    }
    */
}
