package com.wp.project.MovieDatabase.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieid;

    @NotEmpty(message = "title is mandatory")
    @Size(min=3)
    private String title;

    @NotEmpty(message = "description is mandatory")
    private String synopsis;

    @NotEmpty(message = "genre is mandatory")
    private String genre;

    @ManyToMany
    @JoinTable(name ="MovieCast",
            joinColumns = @JoinColumn(name = "movieid"),
            inverseJoinColumns = @JoinColumn(name = "actorid"))
    List<Actor> moviecast;

    public Movie(String title, String synopsis, String genre, List<Actor> moviecast, String title1, String synopsis1, String genre1) {
        this.title = title;
        this.synopsis = synopsis;
        this.genre = genre;
        this.moviecast = moviecast;
        this.title = title1;
        this.synopsis = synopsis1;
        this.genre = genre1;
    }

    public Movie() {
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Actor> getMoviecast() {
        return moviecast;
    }

    public void setMoviecast(List<Actor> moviecast) {
        this.moviecast = moviecast;
    }
}
