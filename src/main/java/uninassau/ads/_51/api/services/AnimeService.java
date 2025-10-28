package uninassau.ads._51.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uninassau.ads._51.api.dto.AnimesDTO;
import uninassau.ads._51.api.entity.Animes;
import uninassau.ads._51.api.repository.AnimesRepository;

import java.util.List;

@Service
public class AnimeService {

    @Autowired
    public AnimesRepository animesRepository;

    public AnimeService(AnimesRepository animesRepository) {
        this.animesRepository = animesRepository;
    }

    public Animes salvarProduto(AnimesDTO animesDTO) {
        Animes animes = new Animes();
        animes.setNome(animesDTO.getNome());
        animes.setGenero(animesDTO.getGenero());


        return animesRepository.save(animes);
    }

    public List<Animes> consultarAnimes() {
        return animesRepository.findAll();
    }
}
