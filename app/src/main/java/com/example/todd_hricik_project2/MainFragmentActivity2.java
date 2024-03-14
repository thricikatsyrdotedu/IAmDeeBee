package com.example.todd_hricik_project2;
import android.content.Context;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.todd_hricik_project2.Activity2;
import com.example.todd_hricik_project2.Movie;
import com.example.todd_hricik_project2.R;
import com.example.todd_hricik_project2.RecyclerItemClickListener;
import com.example.todd_hricik_project2.SimpleRecyclerAdapter;

import java.util.Objects;
import android.content.Context;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.Objects;

import android.view.View;
// ------------- Work for the main fragment used at the beginning of Activity 2 -------------
// Implement the intro fragment element
public class MainFragmentActivity2 extends Fragment {
    private RecyclerItemClickListener clickListener;
    private SimpleRecyclerAdapter myRecyclerAdapter = new SimpleRecyclerAdapter();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.main_fragment_activity2, container, false);
        RecyclerView rv = rootView.findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        // LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        rv.setLayoutManager(layoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(myRecyclerAdapter);
        return rootView;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            clickListener = (RecyclerItemClickListener) context;
            myRecyclerAdapter.setOnItemClickListener(clickListener);
        } catch (ClassCastException ex) {
            throw new ClassCastException(context.toString() + "must implement EventTrack");
        }
    }
}
// -------------- End Work for the main fragment used at the beginning of Activity 1 --------




//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
///*
//import android.content.Context;
//import android.os.Bundle;
//import android.transition.Fade;
//import android.transition.Slide;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.core.view.ViewCompat;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentTransaction;
//import androidx.recyclerview.widget.DefaultItemAnimator;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//import androidx.recyclerview.widget.StaggeredGridLayoutManager;
//
//import java.util.Objects;
//
//public class MainFragmentActivity2 extends Fragment implements  RecyclerItemClickListener {
//
//    private RecyclerItemClickListener clickListener;
//    private SimpleRecyclerAdapter myRecyclerAdapter;
//
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View rootView = inflater.inflate(R.layout.main_fragment_activity2, container, false);
//        RecyclerView rv = rootView.findViewById(R.id.recycler_view);
//
//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
//        // LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        layoutManager.scrollToPosition(0);
//        rv.setLayoutManager(layoutManager);
//        rv.setItemAnimator(new DefaultItemAnimator());
//        myRecyclerAdapter = new SimpleRecyclerAdapter();
//        rv.setAdapter(myRecyclerAdapter);
//        return rootView;
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        try {
//            clickListener = (RecyclerItemClickListener) context;
//            myRecyclerAdapter.setOnItemClickListener(clickListener);
//        } catch (ClassCastException ex) {
//            throw new ClassCastException(context.toString() + "must implement EventTrack");
//        }
//    }
//
//    @Override
//    public void onItemClick(View clicked_view, Movie movie) {
//            // MainFragmentActivity2 detailFragment = new MainFragmentActivity2();
//            MovieFragmentActivity2 detailFragment = new MovieFragmentActivity2();
//            Bundle args = new Bundle();
//            args.putString("param1", movie.name);
//            args.putString("param2", movie.year);
//            args.putInt("param3", movie.resource_id);
//            args.putString("param4", movie.url);
//            args.putString("param5", movie.desc);
//            detailFragment.setArguments(args);
//            // Get a handle on another fragment designed for a movie
//            // MovieFragmentActivity2 movieFragment = MovieFragmentActivity2
//            //        .newInstance(movie.name, movie.year, movie.resource_id,
//            //                 movie.url, movie.desc);
//
//            // Declare a fragment manager
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            // Declare a fragmentTransaction
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//            // Swap the previous fragment out and the new movie fragment fragment in
//            if(twoPane) {
//                // Don't worry about transtion for now
//                detailFragment.setEnterTransition(new Slide(Gravity.TOP));
//                // Don't worry about transtion for now
//                detailFragment.setExitTransition(new Slide(Gravity.BOTTOM));
//                // Replace the old fragment in the main container with a new fragment
//                getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
//                        .replace(R.id.detail_container, detailFragment).addToBackStack(null).commit();
//            }
//            else {
//                // Don't worry about transtion for now
//                detailFragment.setEnterTransition(new Fade());
//                // Don't worry about transtion for now
//                detailFragment.setExitTransition(new Fade());
//                // Don't worry about transtion for now
//                // detailFragment.setSharedElementReturnTransition(new DetailsTransition());
//                getSupportFragmentManager().beginTransaction()
//                        .addSharedElement(shared_view, Objects.requireNonNull(ViewCompat.getTransitionName(shared_view)))
//                        .replace(R.id.main_container, detailFragment).addToBackStack(null).commit();
//                // Replace the old fragment with a new one
////            fragmentTransaction.setReorderingAllowed(true).replace(R.id.detail_container, movieFragment );
//            }
//            // fragmentTransaction.setTransition( TRANSIT_FRAGMENT_OPEN );
//            // Commit the fragment to the container where TRANSIT_FRAGMENT_OPEN is some constant value
//            fragmentTransaction.commit();
//            // Toast t= Toast.makeText(getApplicationContext(),"Click pos"+Integer.toString(position), Toast.LENGTH_SHORT);
//            // t.show();
//        }
//    }
//
//    @Override
//    public void onItemLongClick(View v, int position) {
//        return;
//    }
//}
//    // -----------------------------------------------------------------------------------------
//
////
////import android.content.Context;
////import android.os.Bundle;
////import android.view.LayoutInflater;
////import android.view.View;
////import android.view.ViewGroup;
////import android.widget.TextView;
////import androidx.fragment.app.Fragment;
////import androidx.recyclerview.widget.DefaultItemAnimator;
////import androidx.recyclerview.widget.LinearLayoutManager;
////import androidx.recyclerview.widget.RecyclerView;
////import androidx.recyclerview.widget.StaggeredGridLayoutManager;
////
/////**
////// * A simple {@link Fragment} subclass.
////// * Use the {@link MovieFragmentActivity1#newInstance} factory method to
////// * create an instance of this fragment.
////// */
////
////
////
////public class MainFragmentActivity2 extends Fragment {
////
////    private RecyclerItemClickListener clickListener;
////    private SimpleRecyclerAdapter myRecyclerAdapter = new SimpleRecyclerAdapter();
////    ;
////
////    public MainFragmentActivity2() {
////        // Required empty public constructor
////    }
////
////    /**
////     * Use this factory method to create a new instance of
////     * this fragment using the provided parameters.
////     *
//////     * @param param1 Parameter 1.
//////     * @param param2 Parameter 2.
//////     * @param param3 Parameter 3.
//////     * @param param4 Parameter 5.
//////     * @param param5 Parameter 4.
//////     * @return A new instance of fragment MovieFragmentActivity1.
////     */
////     // TODO: Rename and change types and number of parameters
////     // public static MainFragmentActivity2 newInstance(int param1, String param2, String param3,
////     //                                                 String param4, String param5) {
////     public static MainFragmentActivity2 newInstance() {
////        MainFragmentActivity2 fragment = new MainFragmentActivity2();
////        Bundle args = new Bundle();
//////        args.putInt(ARG_PARAM1, param1);
//////        args.putString(ARG_PARAM2, param2);
//////        args.putString(ARG_PARAM3, param3);
//////        args.putString(ARG_PARAM4, param4);
//////        args.putString(ARG_PARAM5, param5);
////        fragment.setArguments(args);
////        return fragment;
////    }
////
////    @Override
////    public void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        if (getArguments() != null) {
//////            mParam1 = getArguments().getInt(ARG_PARAM1);
//////            mParam2 = getArguments().getString(ARG_PARAM2);
//////            mParam3 = getArguments().getString(ARG_PARAM3);
//////            mParam4 = getArguments().getString(ARG_PARAM4);
//////            mParam5 = getArguments().getString(ARG_PARAM5);
////        }
////    }
////    @Override
////    public View onCreateView(LayoutInflater inflater, ViewGroup container,
////                             Bundle savedInstanceState) {
////        // Inflate the layout for this fragment
////        View v = inflater.inflate(R.layout.main_fragment_activity2, container, false);
////        RecyclerView rv = v.findViewById(R.id.recycler_view);
////
////        // StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
////        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
////        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
////        layoutManager.scrollToPosition(0);
////        rv.setLayoutManager(layoutManager);
////        rv.setItemAnimator(new DefaultItemAnimator());
////
/////*
////        TextView textView1 = v.findViewById(R.id.fragment_movie_activity2_textview1);
////        TextView textView2 = v.findViewById(R.id.fragment_movie_activity2_textview2);
////        TextView textView3 = v.findViewById(R.id.fragment_movie_activity2_textview3);
////        TextView textView4 = v.findViewById(R.id.fragment_movie_activity2_textview4);
////        TextView textView5 = v.findViewById(R.id.fragment_movie_activity2_textview5);
////*/
/////*
////        if (getArguments() != null) {
////            mParam1 = getArguments().getInt(ARG_PARAM1);
////            mParam2 = getArguments().getString(ARG_PARAM2);
////            mParam3 = getArguments().getString(ARG_PARAM3);
////            mParam4 = getArguments().getString(ARG_PARAM4);
////            mParam5 = getArguments().getString(ARG_PARAM5);
////        }
/////*
////        // Set the text in the TextViews within the fragment
////        textView1.setText(mParam1);
////        textView2.setText(mParam2);
////        textView3.setText(mParam3);
////        textView2.setText(mParam4);
////        textView3.setText(mParam5);
////*/
////        return rv;
////    }
////    @Override public void onAttach(Context context) {
////        super.onAttach(context);
////        try {
////            clickListener = (RecyclerItemClickListener) context;
////            myRecyclerAdapter.setOnItemClickListener(clickListener);
////        }
////        catch (ClassCastException ex) {
////            throw new ClassCastException(context.toString()+"must implement EventTrack");
////        }
////    }
////}
////
////
