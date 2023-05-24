package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    private MovieService movieService=new MovieService();
    //1 task
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie)
    {
        return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.CREATED);
    }

    //2 task
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director)
    {
        return new ResponseEntity<>(movieService.addDirector(director),HttpStatus.CREATED);
    }

//    3 task
    @PostMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movieName,@RequestParam String directorName)
    {
        return new ResponseEntity<>(movieService.addMovieDirectorPair(movieName,directorName),HttpStatus.CREATED);
    }

    //4 task
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name)
    {
        Movie movieByName=movieService.getMovieByName(name);
        return new ResponseEntity<>(movieByName,HttpStatus.FOUND);
    }
    //5 task
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name)
    {
        return new ResponseEntity<>(movieService.getDirectorByName(name),HttpStatus.FOUND);
    }
    //6 task
    @GetMapping("/get-movies-by-director-name/{name}")
    public ResponseEntity<List<Movie>> getMoviesByDirectorName(@PathVariable String name)
    {
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(name),HttpStatus.OK);
    }

    //7 task
    @GetMapping("/get-all-movies")
    public  List<Movie> findAllMovies()
    {
        return movieService.getAllMovies();
    }

    //8 task
    @DeleteMapping("/delete-director-by-name")
    public  ResponseEntity<String> deleteDirectorByName(@RequestParam String name)
    {
        movieService.deleteDirectorByName(name);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors()
    {
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }



}
