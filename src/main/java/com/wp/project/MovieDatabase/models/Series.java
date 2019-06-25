package com.wp.project.MovieDatabase.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int seriesid;

    @NotEmpty(message = "title is mandator")
    @Size(min=3)
    private String title;

    @NotEmpty(message = "description is mandatory")
    private String synopsis;

    @NotEmpty(message = "genre is mandatory")
    private String genre;

    @OneToMany
    private List<Season> seasons;

    @ManyToMany
    @JoinTable(name = "SeriesCast",
    joinColumns = @JoinColumn(name = "seriesid"),
    inverseJoinColumns = @JoinColumn(name = "actorid"))
    private List<Actor> seriescast;

    public Series(String title, String synopsis, String genre, List<Season> seasons, List<Actor> seriescast) {
        this.title = title;
        this.synopsis = synopsis;
        this.genre = genre;
        this.seasons = seasons;
        this.seriescast = seriescast;
    }

    public Series() {
    }

    public int getSeriesid() {
        return seriesid;
    }

    public void setSeriesid(int seriesid) {
        this.seriesid = seriesid;
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

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

    public List<Actor> getSeriescast() {
        return seriescast;
    }

    public void setSeriescast(List<Actor> seriescast) {
        this.seriescast = seriescast;
    }

    public void updateSeasonList(Season season){
        seasons.add(season);
    }
}
