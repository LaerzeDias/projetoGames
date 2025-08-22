package com.laerze.projetoGames.services;

import com.laerze.projetoGames.dto.GameListDTO;
import com.laerze.projetoGames.entities.GameList;
import com.laerze.projetoGames.repositories.GameListRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        return gameListRepository.findAll().stream()
                .map(GameListDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id) {
        GameList gameList = gameListRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lista de id " + id + " não encontrada."));
        return new GameListDTO(gameList);
    }
}
