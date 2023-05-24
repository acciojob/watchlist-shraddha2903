package com.driver;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    private MovieRepository movieRepository = new MovieRepository();
    public String addMovie(Movie movie) {

        movieRepository.addMovie(movie);
        return "success";
    }

    public String addDirector(Director director) {
        movieRepository.addDirector(director);
        return "Success";
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
        //List<Movie> movieList=new ArrayList<>();
        Movie movie =getMovieByName(movieName);
        //Director director = getDirectorByName(directorName);
        movieRepository.addMovieDirectorPair(movie,directorName);
        return "Success";
    }

    public Movie getMovieByName(String movieName) throws MovieNotFoundException {
        List<Movie> list=getAllMovies();
        for(Movie lt: list)
        {
            if(lt.getName().equals(movieName))
            {

                return lt;
            }
        }
        throw new MovieNotFoundException("Movie not Found with name: "+movieName);
        //return movieRepository.getMovieByName(movieName);


    }
    public Director getDirectorByName(String name) throws DirectorNotFoundException {

        Director directorList = movieRepository.getDirectorByName(name);
        if(directorList!=null)
            return directorList;
        throw new DirectorNotFoundException("Director Not Found");
    }

    public List<Movie> getMoviesByDirectorName(String name) throws DirectorNotFoundException{
        List<Movie> movieLists = movieRepository.getMovieByDirectorName(name);
        if(!movieLists.isEmpty())
        {
            return movieLists;
        }
        throw new DirectorNotFoundException("Director not Found");
    }

    public List<Movie> getAllMovies() throws MovieNotFoundException {
        List<Movie> movieList = movieRepository.getAllMovies();
        if(!movieList.isEmpty())
        {
            return movieList;
        }
        throw new MovieNotFoundException("There is no Movie");
    }

    public void deleteDirectorByName(String name) {
        movieRepository.deleteDirectorByName(name);
    }

    public void deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
    }

//    public List<Movie> getMoviesByDirectorName(String name) {
//
//    }
}
