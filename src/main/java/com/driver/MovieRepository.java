package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieRepository {
    private Map<String,Movie> movies = new HashMap<>();
    private Map<String,Director> directors = new HashMap<>();
    private Map<String, List<Movie>> moviesDirectorPair = new HashMap<>();
    public void addMovie(Movie movie) {
        movies.put(movie.getName(),movie);
    }

    public void addDirector(Director director) {
        directors.put(director.getName(),director);
    }

    public void addMovieDirectorPair(Movie movie, String directorName) {
        List<Movie> list = new ArrayList<>();
        //check if movieDirectorPair object is null
        if(moviesDirectorPair!=null)
        {
            //if director already present
            if(moviesDirectorPair.containsKey(directorName))
            {
                list = moviesDirectorPair.get(directorName);
            }
        }
        list.add(movie);
        moviesDirectorPair.put(directorName,new ArrayList<>(list));
    }

    public Movie getMovieByName(String movieName) {
        Movie res=null;
        for(Map.Entry<String,Movie> hm : movies.entrySet())
        {
            if(hm.equals(movieName)){
                res=hm.getValue();
            }
        }
//        if(movies.containsKey(movieName))
//        {
//            return movies.get(movieName);
//        }
        return res;
    }
    public Director getDirectorByName(String name) {
        //Director res=null;
        if(directors.containsKey(name))
            return directors.get(name);
        return null;
    }

    public List<Movie> getMovieByDirectorName(String name) {
        if(moviesDirectorPair.containsKey(name))
        {
            return moviesDirectorPair.get(name);
        }
        return null;
    }

    public List<Movie> getAllMovies() {
        if(!movies.isEmpty())
        {
            List<Movie>  mvList= new ArrayList<>();
            for(Map.Entry<String,Movie> hm : movies.entrySet())
            {
                mvList.add(hm.getValue());
            }
            return mvList;
        }
        return null;
    }

    public void deleteDirectorByName(String name) {
        if(directors.containsKey(name))
        {
            directors.remove(name);
        }
    }

    public void deleteAllDirectors() {
        if(!moviesDirectorPair.isEmpty())
        {
            moviesDirectorPair.clear();
        }
    }
}
