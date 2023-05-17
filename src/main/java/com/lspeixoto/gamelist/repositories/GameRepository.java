package com.lspeixoto.gamelist.repositories;

import com.lspeixoto.gamelist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
