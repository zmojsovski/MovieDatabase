package com.wp.project.MovieDatabase.web.rest;

import com.wp.project.MovieDatabase.models.Movie;
import com.wp.project.MovieDatabase.models.exceptions.DuplicateMovieException;
import com.wp.project.MovieDatabase.models.exceptions.MovieNotFoundException;
import com.wp.project.MovieDatabase.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin({"*","localhost:3000"})
@RestController
@RequestMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieResource {

private final MovieService movieService;

@Autowired
    public MovieResource(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping
    public List<Movie> getMovies(){
    return movieService.getAllMovies();
    }

    @GetMapping("/{title}")
    public Movie getMoviebyTitle(@PathVariable String title) throws MovieNotFoundException {
    return movieService.getMoviebyTitle(title);
    }

    @GetMapping("/{id}")
    public Optional<Movie> getMoviebyId(@PathVariable Integer id) throws MovieNotFoundException {
   Optional<Movie> movie1 = movieService.getMoviebyId(id);
   return movie1;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewMovie(@Valid @RequestBody Movie movie, HttpServletResponse response) throws DuplicateMovieException {
Movie movie1 = movieService.addNewMovie(movie);
response.setHeader("Location", "/movies/"+ movie1.getMovieid());
    }

    @DeleteMapping("/{id}")
    public void deleteMoviebyID(@PathVariable int id) throws MovieNotFoundException{
    movieService.deletebyID(id);
    }

    @DeleteMapping("/{title}")
    public void deleteMoviebyTitle(@PathVariable String title) throws  MovieNotFoundException{
    movieService.deletebyTitle(title);
    }
}
