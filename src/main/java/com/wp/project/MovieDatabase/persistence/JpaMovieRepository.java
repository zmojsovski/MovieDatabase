package com.wp.project.MovieDatabase.persistence;

import com.wp.project.MovieDatabase.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaMovieRepository extends JpaRepository<Movie,Integer> {

    Movie findByTitle(String title);

    Movie deleteByTitle(String title);

}
