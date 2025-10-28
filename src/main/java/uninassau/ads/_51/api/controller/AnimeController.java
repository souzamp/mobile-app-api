package uninassau.ads._51.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uninassau.ads._51.api.dto.AnimesDTO;
import uninassau.ads._51.api.entity.Animes;
import uninassau.ads._51.api.services.AnimeService;

import java.util.List;

@RestController
@RequestMapping("/animes")
@CrossOrigin(origins = "*")
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    @GetMapping
    public List<Animes> listar() {
//        return List.of(
//                new Produto(1L, "Notebook", 3500.0),
//                new Produto(2L, "Mouse", 120.0),
//                new Produto(3L, "Monitor", 980.0)
//        );

        return animeService.consultarAnimes();
    }

    @PostMapping
    public Animes salvar(@RequestBody AnimesDTO animesDTO) {
        return animeService.salvarProduto(animesDTO);
    }
}

