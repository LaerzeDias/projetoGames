package com.laerze.projetoGames.repositories;

import com.laerze.projetoGames.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {}
