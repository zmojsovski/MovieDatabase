package com.wp.project.MovieDatabase.models;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int actorid;

    @NotEmpty(message = "Actor Name is mandatory!")
    private String name;

    @NotEmpty(message = "Actor biography is mandatory!")
    private String bio;

    @NotEmpty(message = "Actor years is mandatory!")
    private int years;

    @ManyToMany(mappedBy = "moviecast")
    List<Movie> movies;
    @ManyToMany(mappedBy = "seriescast")
    List<Series> series;

    public Actor(String name, String bio, int years, List<Movie> movies, List<Series> series) {
        this.name = name;
        this.bio = bio;
        this.years = years;
        this.movies = movies;
        this.series = series;
    }

    public Actor() {
    }

    public int getActorid() {
        return actorid;
    }

    public void setActorid(int actorid) {
        this.actorid = actorid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Series> getSeries() {
        return series;
    }

    public void setSeries(List<Series> series) {
        this.series = series;
    }
}
