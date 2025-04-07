package com.tbbt.episodios.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EpisodioDTO {
    private String name;
    private Integer season;
    private int number;

    @JsonProperty("image")
    private Imagem imagem;

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Imagem getImagem() {
        return imagem;
    }

    public void setImagem(Imagem imagem) {
        this.imagem = imagem;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class  Imagem {
        private String original;

        public String getOriginal(){
            return original;
        }

        public void serOriginal(String original) {
            this.original = original;
        }
        
    }
}
