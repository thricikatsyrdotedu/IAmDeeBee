package com.example.todd_hricik_project2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.ViewHolder> {
    List<Movie> list_movie;
    RecyclerItemClickListener vc=null;
    public SimpleRecyclerAdapter() {
        MovieData movieData = new MovieData();
        this.list_movie = movieData.getMoviesList();
    }
    public void setOnItemClickListener(RecyclerItemClickListener _vo){
        vc=_vo;
    }
    public void removeMovie(int position){
        list_movie.remove(position);
        this.notifyItemRemoved(position);
    }
    public void addMovie(String name, String year){
        list_movie.add(5, new Movie(name, year, R.drawable.default_poster));
        this.notifyItemInserted(5);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);
        final ViewHolder view_holder = new ViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vc!=null)
                    vc.onItemClick(v,view_holder.getAdapterPosition());
            }
        });
        v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(vc!=null)
                    vc.onItemLongClick(v,view_holder.getAdapterPosition());
                return true;
            }
        });
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie _movie = list_movie.get(position);
        holder.movie_name.setText(_movie.name);
        holder.movie_year.setText(_movie.year);
        if (_movie.resource_id != -1){
            holder.poster_img.setImageResource(_movie.resource_id);
        } else {
            Picasso.get().load(_movie.url).into(holder.poster_img);
        }
    }

    @Override
    public int getItemCount() {
        return list_movie.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView movie_name;
        public TextView movie_year;
        public ImageView poster_img;
        public ViewHolder(View view) {
            super(view);
            movie_name = (TextView)view.findViewById(R.id.movie_name);
            movie_year = (TextView)view.findViewById(R.id.movie_year);
            poster_img = (ImageView)view.findViewById(R.id.poster_photo);
        }
    }
}