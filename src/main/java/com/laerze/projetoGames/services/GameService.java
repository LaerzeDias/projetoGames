package com.laerze.projetoGames.services;

import com.laerze.projetoGames.dto.GameMinDTO;
import com.laerze.projetoGames.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        return gameRepository.findAll().stream()
                .map(GameMinDTO::new)
                .collect(Collectors.toList());
    }
}
