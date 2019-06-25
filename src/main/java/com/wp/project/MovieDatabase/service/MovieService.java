package com.wp.project.MovieDatabase.service;

import com.wp.project.MovieDatabase.models.Movie;
import com.wp.project.MovieDatabase.models.exceptions.DuplicateMovieException;
import com.wp.project.MovieDatabase.models.exceptions.MovieNotFoundException;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> getAllMovies();

    Optional<Movie> getMoviebyId(int id) throws MovieNotFoundException;

    Movie getMoviebyTitle(String title) throws  MovieNotFoundException;

    Movie addNewMovie(Movie movie) throws DuplicateMovieException;

    Optional<Movie> deletebyID(int id) throws MovieNotFoundException;

    Movie deletebyTitle(String title) throws  MovieNotFoundException;

}
