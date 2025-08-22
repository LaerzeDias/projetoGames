package com.laerze.projetoGames.dto;

import com.laerze.projetoGames.entities.GameList;

public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO() {}

    public GameListDTO(GameList gameList) {
        name = gameList.getName();
        id = gameList.getId();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
