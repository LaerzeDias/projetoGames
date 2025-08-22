package com.laerze.projetoGames.services;

import com.laerze.projetoGames.dto.GameDTO;
import com.laerze.projetoGames.dto.GameMinDTO;
import com.laerze.projetoGames.entities.Game;
import com.laerze.projetoGames.repositories.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        return gameRepository.findAll().stream()
                .map(GameMinDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jogo de id " + id + " não encontrado."));
        return new GameDTO(game);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long id) {
        return gameRepository.findByList(id).stream()
                .map(GameMinDTO::new)
                .toList();
    }
}
