package com.example.todd_hricik_project2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import java.util.List;

public class Activity2 extends AppCompatActivity implements RecyclerItemClickListener{

    Toolbar toolbar;
    private RecyclerView recycler_view;
    private SimpleRecyclerAdapter adapter_items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        // Instantiate a toolbar to be visible on all activities
        toolbar = (Toolbar) findViewById(R.id.my_toolbar_activity2);
        // Set the app bar to the new toolbar
        setSupportActionBar(toolbar);
        // Get a ref to the action bar
        ActionBar ab = getSupportActionBar();
        // Enanble the back button to take you back to home
        ab.setDisplayHomeAsUpEnabled(true);
        // Set the title of the app bar
        ab.setTitle("IAmDeeBee");
        // Set the color of the title of the app bar to white
        // ab.setTitleTextColor(getResources().getColor(android.R.color.white));

        // -------------------------- Work on RecyclerView -------------------------------------
        recycler_view = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recycler_view.setLayoutManager(layoutManager);
        adapter_items = new SimpleRecyclerAdapter();
        adapter_items.setOnItemClickListener(this);
        recycler_view.setAdapter(adapter_items);
        // ------------------------ End Work on RecyclerView -----------------------------------
    }
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
            // Send a toast to let the user know that they are already in activity 1
            Intent intentActivity2 = new Intent(Activity2.this, Activity1.class);
            startActivity(intentActivity2);
            return true;
        } else if (itemId == R.id.action_bar_text_2) {
            // Send a toast to let the user know that they are already in activity 2
            Toast.makeText(this, "You are already in Activity 2!!", Toast.LENGTH_SHORT).show();
            return true;
        }  else if (itemId == R.id.action_bar_text_3) {
            // Create an intent to move to activity 3
            Intent intentActivity3 = new Intent(Activity2.this, Activity3.class);
            startActivity(intentActivity3);
            return true;
        } else if (itemId == androidx.appcompat.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        else return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(View v, int position) {
        Toast t= Toast.makeText(getApplicationContext(),"Click pos"+Integer.toString(position), Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onItemLongClick(View v, int position) {
        adapter_items.removeMovie(position);
    }
}
