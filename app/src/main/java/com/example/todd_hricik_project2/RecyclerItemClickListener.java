package com.example.todd_hricik_project2;

import android.view.View;

public interface RecyclerItemClickListener {
    public void onItemClick(View v, int position);
    public void onItemLongClick(View v, int position);
}