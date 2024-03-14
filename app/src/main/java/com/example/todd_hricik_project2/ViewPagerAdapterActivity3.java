package com.example.todd_hricik_project2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class ViewPagerAdapterActivity3 extends FragmentStateAdapter {
    MovieData movieData;

    // public ViewPagerAdapterActivity3(FragmentManager fm, MovieData movieData)
    // public ViewPagerAdapterActivity3(FragmentManager fragmentActivity, ArrayList<Movie> _movieData) {
    public ViewPagerAdapterActivity3(@NonNull FragmentActivity fragmentActivity, MovieData _movieData) {
        // super(fm);
        super(fragmentActivity);
        // this.list_movie = list_m;
        movieData = _movieData;
    }
/*
    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new MovieFragmentActivity3();
        Bundle args = new Bundle();
        // args.putString(MovieFragmentActivity3.ARG_TITLE, movieData.getItem(position).name);
        // args.putString(MovieFragmentActivity3.ARG_YEAR, movieData.getItem(position).year);
        // args.putInt(MovieFragmentActivity3.POSTER_ID, movieData.getItem(position).resource_id);
        // args.putString(MovieFragmentActivity3.DESCRIPTION, movieData.getItem(position).desc);
        // args.putString(MovieFragmentActivity3.URL, movieData.getItem(position).url);

        // args.putString(MovieFragmentActivity3.ARG_PARAM1, list_movie.get(position).getName());
        // args.putString(MovieFragmentActivity3.ARG_PARAM1, list_movie.get(position).name);
        args.putString(MovieFragmentActivity3.ARG_PARAM1, movieData.getItem(position).name);
        // args.putString(MovieFragmentActivity3.ARG_PARAM2, list_movie.get(position).getYear());
        // args.putString(MovieFragmentActivity3.ARG_PARAM2, list_movie.get(position).year);
        args.putString(MovieFragmentActivity3.ARG_PARAM2, movieData.getItem(position).year);
        // args.putString(MovieFragmentActivity3.ARG_PARAM3, list_movie.get(position).getDesc());
        // args.putString(MovieFragmentActivity3.ARG_PARAM3, list_movie.get(position).desc);
        args.putString(MovieFragmentActivity3.ARG_PARAM3, movieData.getItem(position).desc);
        fragment.setArguments(args);
        return fragment;
    }
*/
    /*
    @Override
    public int getCount() {
        // return list_movie.size();
        return movieData.getSize();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // return list_movie.get(position).getName());
        // return list_movie.get(position).name;
        return movieData.getItem(position).name;
    }
    */
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new MovieFragmentActivity3();
        Bundle args = new Bundle();

        args.putString(MovieFragmentActivity3.ARG_PARAM1, movieData.getItem(position).name);
        args.putString(MovieFragmentActivity3.ARG_PARAM2, movieData.getItem(position).year);
        args.putInt(MovieFragmentActivity3.ARG_PARAM3, movieData.getItem(position).resource_id);
        args.putString(MovieFragmentActivity3.ARG_PARAM4, movieData.getItem(position).year);
        args.putString(MovieFragmentActivity3.ARG_PARAM5, movieData.getItem(position).desc);
        fragment.setArguments(args);

        /*
        args.putString(MovieFragmentActivity3.ARG_TITLE, movieData.getItem(position).name);
        args.putString(MovieFragmentActivity3.ARG_YEAR, movieData.getItem(position).year);
        args.putInt(MovieFragmentActivity3.POSTER_ID, movieData.getItem(position).resource_id);
        args.putString(MovieFragmentActivity3.DESCRIPTION, movieData.getItem(position).desc);
        args.putString(MovieFragmentActivity3.URL, movieData.getItem(position).url);
        */
        return fragment;
    }
    @Override
    public int getItemCount() {
        // return 0;
        return movieData.getSize();
    }
}