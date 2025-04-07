function sortearEpisodio() {
    fetch("/api/episodios/aleatorio")
        .then((response) => response.json())
        .then((episodio) => {
            const resultado = document.getElementById("resultado");
            resultado.innerHTML = `
          <div class="card shadow-sm mx-auto w-100" style="max-width: 24rem;">
            <img src="${episodio.imagem}" class="card-img-top" alt="Imagem do episódio" />
            <div class="card-body">
              <h5 class="card-title">${episodio.nome}</h5>
              <p class="card-text">Temporada ${episodio.temporada} | Episódio ${episodio.numero}</p>
            </div>
          </div>
        `;
        })
        .catch((error) => console.error("Erro ao buscar episódio:", error));
}
