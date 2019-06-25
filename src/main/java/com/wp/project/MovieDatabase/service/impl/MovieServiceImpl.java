package com.wp.project.MovieDatabase.service.impl;

import com.wp.project.MovieDatabase.models.Movie;
import com.wp.project.MovieDatabase.models.exceptions.DuplicateMovieException;
import com.wp.project.MovieDatabase.models.exceptions.MovieNotFoundException;
import com.wp.project.MovieDatabase.persistence.JpaMovieRepository;
import com.wp.project.MovieDatabase.service.MovieService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final JpaMovieRepository jpaMovieRepository;

    public MovieServiceImpl(JpaMovieRepository jpaMovieRepository) {
        this.jpaMovieRepository = jpaMovieRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return jpaMovieRepository.findAll();
    }

    @Override
    public Optional<Movie> getMoviebyId(int id) throws MovieNotFoundException {
        return jpaMovieRepository.findById(id);
    }

    @Override
    public Movie getMoviebyTitle(String title) throws MovieNotFoundException {
        return jpaMovieRepository.findByTitle(title);
    }

    @Override
    public Movie addNewMovie(Movie movie) throws DuplicateMovieException {
        return jpaMovieRepository.save(movie);
    }

    @Override
    public Optional<Movie> deletebyID(int id) throws MovieNotFoundException {
        Optional<Movie> movie = jpaMovieRepository.findById(id);
        jpaMovieRepository.deleteById(id);
        return movie;
    }

    @Override
    public Movie deletebyTitle(String title) throws MovieNotFoundException {
        Movie movie = jpaMovieRepository.findByTitle(title);
        jpaMovieRepository.deleteByTitle(title);
        return movie;
    }
}
