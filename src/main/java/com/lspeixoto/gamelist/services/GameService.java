package com.lspeixoto.gamelist.services;

import com.lspeixoto.gamelist.dto.GameMinDTO;
import com.lspeixoto.gamelist.entities.Game;
import com.lspeixoto.gamelist.repositories.GameRepository;
import com.lspeixoto.gamelist.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    public GameRepository repository;

    public List<GameMinDTO> findAll() {

        List<Game> games = repository.findAll();

        return games.stream().map(GameMinDTO::new).toList();
    }

    public Game findById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
