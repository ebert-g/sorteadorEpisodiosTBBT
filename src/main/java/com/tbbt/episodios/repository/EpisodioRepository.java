package com.tbbt.episodios.repository;

import com.tbbt.episodios.model.Episodio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodioRepository extends JpaRepository<Episodio, Long> {
    
}
