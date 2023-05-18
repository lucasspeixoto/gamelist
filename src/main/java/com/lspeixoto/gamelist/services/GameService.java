package com.lspeixoto.gamelist.services;

import com.lspeixoto.gamelist.dto.GameDTO;
import com.lspeixoto.gamelist.dto.GameMinDTO;
import com.lspeixoto.gamelist.entities.Game;
import com.lspeixoto.gamelist.projections.GameMinProjection;
import com.lspeixoto.gamelist.repositories.GameRepository;
import com.lspeixoto.gamelist.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    public GameRepository repository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {

        List<Game> games = repository.findAll();

        return games.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {

        Game game = repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        return new GameDTO(game);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {

        List<GameMinProjection> games = repository.searchByList(listId);

        return games.stream().map(GameMinDTO::new).toList();
    }
}
