package com.tbbt.episodios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tbbt.episodios.service.TVMazeService;

@RestController
@RequestMapping("/tvmaze")
public class TVMazeController {
    
    @Autowired
    private TVMazeService tvMazeService;

    @GetMapping("/episodios")
    public String buscarEpisodios(){
        return tvMazeService.buscarEpisodios();
    }
    
}
