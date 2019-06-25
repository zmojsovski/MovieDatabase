package com.wp.project.MovieDatabase.web.rest;

import com.wp.project.MovieDatabase.models.Season;
import com.wp.project.MovieDatabase.models.Series;
import com.wp.project.MovieDatabase.models.exceptions.DuplicateSeasonException;
import com.wp.project.MovieDatabase.models.exceptions.DuplicateSeriesException;
import com.wp.project.MovieDatabase.models.exceptions.SeriesNotFoundException;
import com.wp.project.MovieDatabase.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin({"*", "localhost:3000"})
@RestController
@RequestMapping(value = "/series", produces = MediaType.APPLICATION_JSON_VALUE)
public class SeriesResource {

    private final SeriesService seriesService;

    @Autowired
    public SeriesResource(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @GetMapping
    public List<Series> getSeries(){
     return seriesService.getAllSeries();
    }

    @GetMapping(value = "/{id}")
    public Optional<Series> getSeriesbyId(@PathVariable int id) throws SeriesNotFoundException {
        return seriesService.getSeriesbyId(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewSeries(@Valid @RequestBody Series series, HttpServletResponse response) throws DuplicateSeriesException {
        Series series1 = seriesService.addNewSeries(series);
        response.setHeader("Location", "/series/"+ series1.getSeriesid());
    }

    @DeleteMapping("/{id}")
    public void deleteSeriesbyID(@PathVariable int id) throws SeriesNotFoundException{
        seriesService.deletebyID(id);
    }

    @DeleteMapping("/{title}")
    public void deleteSeriesbyTitle(@PathVariable String title) throws SeriesNotFoundException {
        seriesService.deletebyTitle(title);
    }

    @PutMapping("/{id}/addSeason")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewSeason(@Valid @RequestBody Season season, @PathVariable int id) throws DuplicateSeasonException {
        seriesService.addNewSeason(id,season);
    }
}
