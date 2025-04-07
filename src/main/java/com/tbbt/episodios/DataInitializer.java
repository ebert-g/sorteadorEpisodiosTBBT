package com.tbbt.episodios;

import com.tbbt.episodios.dto.EpisodioDTO;
import com.tbbt.episodios.model.Episodio;
import com.tbbt.episodios.repository.EpisodioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final EpisodioRepository episodioRepository;

    public DataInitializer(EpisodioRepository episodioRepository) {
        this.episodioRepository = episodioRepository;
    }

    @Override
    public void run(String... args) {
        if (episodioRepository.count() == 0) {
            RestTemplate restTemplate = new RestTemplate();

            // URL da API do TVmaze para episódios de The Big Bang Theory (ID 66)
            String url = "https://api.tvmaze.com/shows/66/episodes";

            try {
                // Busca e converte o JSON da API em um array de EpisodioDTO
                EpisodioDTO[] episodiosDTO = restTemplate.getForObject(url, EpisodioDTO[].class);

                if (episodiosDTO != null) {
                    for (EpisodioDTO dto : episodiosDTO) {
                        Episodio episodio = new Episodio();
                        episodio.setNome(dto.getName());
                        episodio.setTemporada(dto.getSeason());
                        episodio.setNumero(dto.getNumber());

                        // Verifica se há imagem e usa a versão "original"
                        if (dto.getImagem() != null) {
                            episodio.setImagem(dto.getImagem().getOriginal());
                        } else {
                            episodio.setImagem(null);
                        }

                        // Salva no banco
                        episodioRepository.save(episodio);
                    }
                    System.out.println("✔ Banco populado com sucesso!");
                }

            } catch (Exception e) {
                System.out.println("❌ Erro ao buscar episódios da API: " + e.getMessage());
            }
        } else {
            System.out.println("📦 Banco de dados já está populado. Nenhuma ação necessária.");
        }
    }
}
