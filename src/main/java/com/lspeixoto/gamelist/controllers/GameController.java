package com.lspeixoto.gamelist.controllers;

import com.lspeixoto.gamelist.dto.GameMinDTO;
import com.lspeixoto.gamelist.entities.Game;
import com.lspeixoto.gamelist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    public GameService service;

    @GetMapping
    public ResponseEntity<List<GameMinDTO>> findAll() {

        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Game> findById(@PathVariable Long id) {
        Game game = service.findById(id);

        return ResponseEntity.ok().body(game);
    }
}
