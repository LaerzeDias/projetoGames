package com.laerze.projetoGames.services;

import com.laerze.projetoGames.dto.GameListDTO;
import com.laerze.projetoGames.entities.GameList;
import com.laerze.projetoGames.projections.GameMinProjection;
import com.laerze.projetoGames.repositories.GameListRepository;
import com.laerze.projetoGames.repositories.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

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

    @Transactional
    public void reorderList(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> gameList = gameRepository.findByList(listId);
        var game = gameList.remove(sourceIndex);
        gameList.add(destinationIndex, game);
        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);
        gameList.forEach(g -> {
            int index = gameList.indexOf(g);
            if (index >= min && index <= max) {
                gameListRepository.updateBelongingPosition(listId, g.getId(), index);
            }
        });
    }
}
