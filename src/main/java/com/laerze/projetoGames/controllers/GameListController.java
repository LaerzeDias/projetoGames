package com.laerze.projetoGames.controllers;

import com.laerze.projetoGames.dto.GameListDTO;
import com.laerze.projetoGames.dto.GameMinDTO;
import com.laerze.projetoGames.dto.ReplacementDTO;
import com.laerze.projetoGames.services.GameListService;
import com.laerze.projetoGames.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gamesLists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{id}")
    public GameListDTO findById(@PathVariable Long id) {
        return gameListService.findById(id);
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/reordering")
    public void reorder(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.reorderList(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
