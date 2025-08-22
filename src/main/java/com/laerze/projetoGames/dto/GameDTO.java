package com.laerze.projetoGames.dto;

import com.laerze.projetoGames.entities.Game;

public class GameDTO {

    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameDTO() {}

    public GameDTO(Game game) {
        this.id = game.getId();
        this.title = game.getTitle();
        this.year = game.getYear();
        this.genre = game.getGenre();
        this.platforms = game.getPlatforms();
        this.score = game.getScore();
        this.imgUrl = game.getImgUrl();
        this.shortDescription = game.getShortDescription();
        this.longDescription = game.getLongDescription();
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Double getScore() {
        return score;
    }

    public String getPlatforms() {
        return platforms;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }
}
