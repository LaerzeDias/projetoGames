package com.laerze.projetoGames.repositories;

import com.laerze.projetoGames.entities.Game;
import com.laerze.projetoGames.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(nativeQuery = true, value = """
		SELECT games.id, games.title, games.game_year AS year, games.img_url AS imgUrl,
		games.short_description AS shortDescription, belonging.position
		FROM games
		INNER JOIN belonging ON games.id = belonging.game_id
		WHERE belonging.list_id = :listId
		ORDER BY belonging.position
		""")
    List<GameMinProjection> findByList(Long listId);
}
