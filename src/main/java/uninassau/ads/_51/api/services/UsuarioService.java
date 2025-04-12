package uninassau.ads._51.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uninassau.ads._51.api.UsuariosRepository;
import uninassau.ads._51.api.entity.Usuario;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);
    @Autowired
    private UsuariosRepository usuariosRepository;

    public UsuarioService() {}

    public void saveUsuarios(Usuario usuarios) {
        log.info("Salvando usuário: {}", usuarios);
        usuariosRepository.save(usuarios);

        log.info("Usuário salvo com sucesso!");
    }

    public List<Usuario> findAllUsuarios() {
        return usuariosRepository.findAll();
    }

    public Optional<Usuario> validarUsuarioSenha(String usuario, String senha) {
        return usuariosRepository.findByUsuarioAndSenha(usuario, senha);
    }
}
