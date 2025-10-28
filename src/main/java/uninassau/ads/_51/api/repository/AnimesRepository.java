package uninassau.ads._51.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uninassau.ads._51.api.entity.Animes;

import java.util.List;

public interface AnimesRepository extends JpaRepository<Animes, Long> {
    default List<Animes> consultarProdutos() {
        return findAll();
    }
}
