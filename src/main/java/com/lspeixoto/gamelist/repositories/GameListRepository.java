package com.lspeixoto.gamelist.repositories;

import com.lspeixoto.gamelist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GameListRepository extends JpaRepository<GameList, Long> {


}
