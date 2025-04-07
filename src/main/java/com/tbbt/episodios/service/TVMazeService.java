package com.tbbt.episodios.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TVMazeService {
    private final WebClient webClient;

    public TVMazeService() {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.tvmaze.com")
                .build();
    }

    public String buscarEpisodios(){
        String resposta = webClient.get().uri("/shows/66/episodes").retrieve().bodyToMono(String.class).block();
        return resposta;
    }
}
