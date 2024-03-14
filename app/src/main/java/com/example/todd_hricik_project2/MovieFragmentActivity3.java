package com.example.todd_hricik_project2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MovieFragmentActivity1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MovieFragmentActivity3 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";
    public static final String ARG_PARAM3 = "param3";
    public static final String ARG_PARAM4 = "param4";
    public static final String ARG_PARAM5 = "param5";

    /*
    // public static final String ARG_TITLE = "title";
    public static final String ARG_TITLE = "param1";
    // public static final String ARG_YEAR = "year";
    public static final String ARG_YEAR = "param2";
    // public static final String POSTER_ID = "poster";
    public static final String POSTER_ID = "param3";
    // public static final String URL = "poster";
    public static final String URL = "param4";
    // public static final String DESCRIPTION = "desc";
    public static final String DESCRIPTION = "param5";
    */

    // TODO: Rename and change types of parameters

    private String mParam1;
    private String mParam2;
    private Integer mParam3;
    private String mParam4;
    private String mParam5;


    public MovieFragmentActivity3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @param param3 Parameter 3.
     * @param param4 Parameter 4.
     * @param param5 Parameter 5.
     * @return A new instance of fragment MovieFragmentActivity3.
     */
    // TODO: Rename and change types and number of parameters
    public static MovieFragmentActivity3 newInstance(String param1, String param2,
                                                        Integer param3, String param4, String param5) {
    /*
    public static MovieFragmentActivity3 newInstance(String param1  , int param2,
                                                    String param3, String param4, String param5) {
    */
        MovieFragmentActivity3 fragment = new MovieFragmentActivity3();
        Bundle args = new Bundle();

        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, param3);
        args.putString(ARG_PARAM4, param4);
        args.putString(ARG_PARAM5, param5);

        /*
        args.putString(ARG_TITLE, param1);
        args.putString(ARG_YEAR, param2);
        args.putInt(POSTER_ID, param3);
        args.putString(URL, param4);
        args.putString(DESCRIPTION, param5);
        */
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getInt(ARG_PARAM3);
            mParam4 = getArguments().getString(ARG_PARAM4);
            mParam5 = getArguments().getString(ARG_PARAM5);
            /*
            mParam1 = getArguments().getString(ARG_TITLE);
            mParam2 = getArguments().getString(ARG_YEAR);
            mParam3 = getArguments().getInt(POSTER_ID);
            mParam4 = getArguments().getString(URL);
            mParam5 = getArguments().getString(DESCRIPTION);
            */
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // View rootView = inflater.inflate(R.layout.fragment_collection_object, container, false);

        View rootView = inflater.inflate(R.layout.fragment_movie_activity3, container, false);
        Bundle args = getArguments();
        // ImageView poster = rootView.findViewById(R.id.movie_poster);
        /*
        int resource_id = args.getInt(POSTER_ID, -1);
        if(resource_id == - 1){
        poster.setImageResource(resource_id);
        } else {
            Picasso.get().load(args.getString(URL)).into(poster);
        }
        TextView movieTitle = (TextView) rootView.findViewById(R.id.movie_title);
        movieTitle.setText(args.getString(ARG_TITLE));
        TextView movieYear = (TextView) rootView.findViewById(R.id.movie_year);
        movieYear.setText(args.getInt(ARG_YEAR));
        TextView descText =  (TextView) rootView.findViewById(R.id.descText);
        descText.setText(args.getString(DESCRIPTION));
        */

        TextView textView1 = rootView.findViewById(R.id.fragment_movie_activity3_textview1);
        TextView textView2 = rootView.findViewById(R.id.fragment_movie_activity3_textview2);
        TextView textView3 = rootView.findViewById(R.id.fragment_movie_activity3_textview3);
        TextView textView4 = rootView.findViewById(R.id.fragment_movie_activity3_textview4);
        TextView textView5 = rootView.findViewById(R.id.fragment_movie_activity3_textview5);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getInt(ARG_PARAM3);
            mParam4 = getArguments().getString(ARG_PARAM4);
            mParam5 = getArguments().getString(ARG_PARAM5);
            /*
            mParam1 = getArguments().getString(ARG_TITLE);
            mParam2 = getArguments().getString(ARG_YEAR);
            mParam3 = getArguments().getInt(POSTER_ID);
            mParam4 = getArguments().getString(URL);
            mParam5 = getArguments().getString(DESCRIPTION);
            */
        }

        // Set the text in the TextViews within the fragment

        textView1.setText(mParam1);
        textView2.setText(mParam2);
        textView3.setText(mParam3.toString());
        textView4.setText(mParam4);
        textView5.setText(mParam5);

        return rootView;
    }
}