package com.wp.project.MovieDatabase.persistence;

import com.wp.project.MovieDatabase.models.Series;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaSeriesRepository extends JpaRepository<Series,Integer> {
    Series getSeriesByTitle(String title);

    Optional<Series> findByTitle(String title);

    void deleteByTitle(String title);
}
