package com.lspeixoto.gamelist.controllers;

import com.lspeixoto.gamelist.dto.GameDTO;
import com.lspeixoto.gamelist.dto.GameListDTO;
import com.lspeixoto.gamelist.dto.GameMinDTO;
import com.lspeixoto.gamelist.services.GameListService;
import com.lspeixoto.gamelist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    public GameListService gameListservice;

    @Autowired
    public GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAll() {

        return ResponseEntity.ok(gameListservice.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GameListDTO> findById(@PathVariable Long id) {
        GameListDTO list = gameListservice.findById(id);

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{listId}/games")
    public ResponseEntity<List<GameMinDTO>> findByList(@PathVariable Long listId) {
        List<GameMinDTO> games = gameService.findByList(listId);

        return ResponseEntity.ok().body(games);
    }
}
