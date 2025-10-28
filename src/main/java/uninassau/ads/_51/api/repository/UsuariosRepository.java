package uninassau.ads._51.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uninassau.ads._51.api.entity.Usuario;

import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsuarioAndSenha(String usuario, String senha);
}
