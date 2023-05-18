package com.lspeixoto.gamelist.dto;

import com.lspeixoto.gamelist.entities.GameList;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO() {
    }

    public GameListDTO(GameList list) {
        BeanUtils.copyProperties(list, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameListDTO gameList)) return false;
        return Objects.equals(getId(), gameList.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
