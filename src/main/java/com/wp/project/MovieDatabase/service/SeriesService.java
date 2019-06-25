package com.wp.project.MovieDatabase.service;

import com.wp.project.MovieDatabase.models.Season;
import com.wp.project.MovieDatabase.models.Series;
import com.wp.project.MovieDatabase.models.exceptions.DuplicateSeasonException;
import com.wp.project.MovieDatabase.models.exceptions.DuplicateSeriesException;
import com.wp.project.MovieDatabase.models.exceptions.SeriesNotFoundException;

import java.util.List;
import java.util.Optional;

public interface SeriesService {

    List<Series> getAllSeries();

    Optional<Series> getSeriesbyId(int id) throws SeriesNotFoundException;

    Series getSeriesbyTitle(String title) throws SeriesNotFoundException;

    Series addNewSeries(Series series) throws DuplicateSeriesException;

    Optional<Series> deletebyID(int id) throws SeriesNotFoundException;

    Optional<Series> deletebyTitle(String title) throws  SeriesNotFoundException;

    void addNewSeason(int id, Season season) throws DuplicateSeasonException;

}
