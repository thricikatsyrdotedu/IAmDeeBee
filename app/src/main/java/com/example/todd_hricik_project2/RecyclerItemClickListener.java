package com.example.todd_hricik_project2;

import android.view.View;

public interface RecyclerItemClickListener {
    public void onItemClick(View clicked_view, Movie movie);
    public void onItemLongClick(View v, int position);
}