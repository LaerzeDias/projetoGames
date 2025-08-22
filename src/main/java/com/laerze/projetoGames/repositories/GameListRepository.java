package com.laerze.projetoGames.repositories;

import com.laerze.projetoGames.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {}
