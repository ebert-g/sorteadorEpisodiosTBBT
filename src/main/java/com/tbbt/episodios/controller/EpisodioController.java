package com.tbbt.episodios.controller;

import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tbbt.episodios.model.Episodio;
import com.tbbt.episodios.repository.EpisodioRepository;

@RestController
@RequestMapping("/api/episodios")
public class EpisodioController {

    private final EpisodioRepository repository;

    public EpisodioController(EpisodioRepository repository) {

        this.repository = repository;

    }

    @GetMapping
    public List<Episodio> getTodos() {
        return repository.findAll();
    }

    @GetMapping("/aleatorio")
    public Episodio getAleatorio() {
        List<Episodio> episodios = repository.findAll();
        if (episodios.isEmpty()) {
            return null;
        }
        Random rand = new Random();
        return episodios.get(rand.nextInt(episodios.size()));
    }

}
