package com.wp.project.MovieDatabase.service.impl;

import com.wp.project.MovieDatabase.models.Season;
import com.wp.project.MovieDatabase.models.Series;
import com.wp.project.MovieDatabase.models.exceptions.DuplicateSeasonException;
import com.wp.project.MovieDatabase.models.exceptions.DuplicateSeriesException;
import com.wp.project.MovieDatabase.models.exceptions.SeriesNotFoundException;
import com.wp.project.MovieDatabase.persistence.JpaSeriesRepository;
import com.wp.project.MovieDatabase.service.SeriesService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Service
public class SeriesServiceImpl implements SeriesService {

    private final JpaSeriesRepository jpaSeriesRepository;

    public SeriesServiceImpl(JpaSeriesRepository jpaSeriesRepository) {
       this.jpaSeriesRepository = jpaSeriesRepository;
    }


    @Override
    public List<Series> getAllSeries() {
        return jpaSeriesRepository.findAll();
    }

    @Override
    public Optional<Series> getSeriesbyId(int id) throws SeriesNotFoundException {
        return jpaSeriesRepository.findById(id);
    }

    @Override
    public Series getSeriesbyTitle(String title) throws SeriesNotFoundException {
        return  jpaSeriesRepository.getSeriesByTitle(title);
    }

    @Override
    public Series addNewSeries(Series series) throws DuplicateSeriesException {
        return jpaSeriesRepository.save(series);
    }

    @Override
    public Optional<Series> deletebyID(int id) throws SeriesNotFoundException {
        Optional<Series> series = jpaSeriesRepository.findById(id);
        jpaSeriesRepository.deleteById(id);
        return series;
    }

    @Override
    public Optional<Series> deletebyTitle(String title) throws SeriesNotFoundException {
        Optional<Series> series = jpaSeriesRepository.findByTitle(title);
        jpaSeriesRepository.deleteByTitle(title);
        return series;
    }

    @Override
    public void addNewSeason(int id, Season season) throws DuplicateSeasonException {
        Optional<Series> series1 = jpaSeriesRepository.findById(id);
        if(series1.isPresent()) {
            Series series2 = series1.get();
            series2.updateSeasonList(season);
            jpaSeriesRepository.save(series2);
        }
    }
}
