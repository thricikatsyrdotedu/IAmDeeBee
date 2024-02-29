package com.example.todd_hricik_project2;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Model View class for Movie data
public class Movie {
    String length, name, year, cast, url, desc, director;
    Double rating;
    Integer resource_id;
    public Movie(String name,String year,int id)
    {
        this.name = name;
        this.year = year;
        this.resource_id = id;
    }
    public Movie(String name,String year,String length, String cast, String url, String desc, String director, Double rating)
    {
        this.name = name;
        this.year = year;
        this.length = length;
        this.cast = cast;
        this.url = url;
        this.desc = desc;
        this.director = director;
        this.rating = rating;
        this.resource_id = -1;
    }
}
