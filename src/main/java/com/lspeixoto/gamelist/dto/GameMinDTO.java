package com.lspeixoto.gamelist.dto;

import com.lspeixoto.gamelist.entities.Game;

import java.util.Objects;

public class GameMinDTO {

    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO() {
    }

    public GameMinDTO(Game entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.year = entity.getYear();
        this.imgUrl = entity.getImgUrl();
        this.shortDescription = entity.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameMinDTO game)) return false;
        return Objects.equals(getId(), game.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
