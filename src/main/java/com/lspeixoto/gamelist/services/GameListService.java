package com.lspeixoto.gamelist.services;

import com.lspeixoto.gamelist.dto.GameDTO;
import com.lspeixoto.gamelist.dto.GameListDTO;
import com.lspeixoto.gamelist.dto.GameMinDTO;
import com.lspeixoto.gamelist.entities.Game;
import com.lspeixoto.gamelist.entities.GameList;
import com.lspeixoto.gamelist.repositories.GameListRepository;
import com.lspeixoto.gamelist.repositories.GameRepository;
import com.lspeixoto.gamelist.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    public GameListRepository repository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {

        List<GameList> list = repository.findAll();

        return list.stream().map(GameListDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id) {

        GameList list = repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        return new GameListDTO(list);
    }
}
