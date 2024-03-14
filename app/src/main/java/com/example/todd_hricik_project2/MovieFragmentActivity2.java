package com.example.todd_hricik_project2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.todd_hricik_project2.R;
import com.squareup.picasso.Picasso;

// ------------- Work for the movie fragment in  Activity 2 --------------------------------
// Implement the intro fragment element
public class MovieFragmentActivity2 extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_movie_activity2, container, false);
        TextView textView1 = (TextView) rootView.findViewById(R.id.fragment_movie_activity2_textview1);
        TextView textView2 = (TextView) rootView.findViewById(R.id.fragment_movie_activity2_textview2);
        TextView textView3 = (TextView) rootView.findViewById(R.id.fragment_movie_activity2_textview3);
        TextView textView4 = (TextView) rootView.findViewById(R.id.fragment_movie_activity2_textview4);
        TextView textView5 = (TextView) rootView.findViewById(R.id.fragment_movie_activity2_textview5);
        Bundle b = getArguments();
        ImageView imageView = (ImageView) rootView.findViewById(R.id.moviefragment);
        textView1.setText(b.getString("param1", "NA"));
        textView2.setText(b.getString("param2", "-9999"));
        int resource_id = b.getInt("param3", -1);
        if (resource_id != -1){
            imageView.setImageResource(resource_id);
        } else {
            Picasso.get().load(b.getString("param4")).into(imageView);
        }

        textView3.setText("param3");
        // textView4.setText(b.getString("param4", "NA"));
        textView5.setText(b.getString("param5", "NA"));
        return rootView;
    }
}
// -------------- End Work for the movie fragment of Activity 1 -------------------------*/
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
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.RecyclerView;
//
///**
// * A simple {@link Fragment} subclass.
// * Use the {@link MovieFragmentActivity1#newInstance} factory method to
// * create an instance of this fragment.
// */
//
//// public class MovieFragmentActivity2 extends Fragment {
//
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    // public static final String ARG_TITLE = "title";
//    // public static final String ARG_YEAR = "year";
//    // public static final String POSTER_ID = "poster";
//    // public static final String URL = "poster";
//    // public static final String DESCRIPTION = "desc";
// //   private static final String ARG_PARAM1 = "param1";
//  //  private static final String ARG_PARAM2 = "param2";
//
////    private static final String ARG_PARAM3 = "param3";
////    private static final String ARG_PARAM4 = "param4";
//
////    private static final String ARG_PARAM5 = "param5";
//
//
//    // TODO: Rename and change types of parameters
////    private String mParam1;
////    private String mParam2;
////    private Integer mParam3;
// //   private String mParam4;
////    private String mParam5;
////    public MovieFragmentActivity2() {
//        // Required empty public constructor
////    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
////    * @param param1 Parameter 1.
////     * @param param2 Parameter 2.
////     * @param param3 Parameter 3.
////     * @param param4 Parameter 5.
////     * @param param5 Parameter 4.
////     * @return A new instance of fragment MovieFragmentActivity1.
//     */
//    // TODO: Rename and change types and number of parameters
///*
//    public static MovieFragmentActivity2 newInstance(String param1, String param2, Integer param3,
//                                                     String param4, String param5) {
//        MovieFragmentActivity2 fragment = new MovieFragmentActivity2();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        args.putInt(ARG_PARAM3, param3.intValue());
//        args.putString(ARG_PARAM4, param4);
//        args.putString(ARG_PARAM5, param5);
//        fragment.setArguments(args);
//        return fragment;
//    }
//*/
///*
// */
///*
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//            mParam3 = getArguments().getInt(ARG_PARAM3);
//            mParam4 = getArguments().getString(ARG_PARAM4);
//            mParam5 = getArguments().getString(ARG_PARAM5);
//        }
//    }
//*/
//    /*
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View v = inflater.inflate(R.layout.fragment_movie_activity2, container, false);
//
//        TextView textView1 = v.findViewById(R.id.fragment_movie_activity2_textview1);
//        TextView textView2 = v.findViewById(R.id.fragment_movie_activity2_textview2);
//        TextView textView3 = v.findViewById(R.id.fragment_movie_activity2_textview3);
//        TextView textView4 = v.findViewById(R.id.fragment_movie_activity2_textview4);
//        TextView textView5 = v.findViewById(R.id.fragment_movie_activity2_textview5);
//
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//            mParam3 = getArguments().getInt(ARG_PARAM3);
//            mParam4 = getArguments().getString(ARG_PARAM4);
//            mParam5 = getArguments().getString(ARG_PARAM5);
//        }
//
//        // Set the text in the TextViews within the fragment
//        textView1.setText(mParam1);
//        textView2.setText(mParam2);
//        textView3.setText(mParam3.toString());
//        textView4.setText(mParam4);
//        textView5.setText(mParam5);
//
//        return v;
//    }
//
//}
//*/
