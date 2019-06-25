package com.wp.project.MovieDatabase.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int seasonid;

    @NotEmpty(message = "Season title is mandatory!")
    private String title;

    @NotEmpty(message = "Number of episodes is mandatory!")
    private int episodes;

    public Season(String title, int episodes) {
        this.title = title;
        this.episodes = episodes;
    }

    public Season() {
    }

    public int getSeasonid() {
        return seasonid;
    }

    public void setSeasonid(int seasonid) {
        this.seasonid = seasonid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }
}
