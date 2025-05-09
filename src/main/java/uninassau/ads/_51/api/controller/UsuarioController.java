package uninassau.ads._51.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uninassau.ads._51.api.dto.UsuarioRequestDTO;
import uninassau.ads._51.api.entity.Usuario;
import uninassau.ads._51.api.services.UsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "LoginController", description = "Controller responsável por controlar as operaçoes de usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    private static final String MENSAGEM_SUCESSO = "Usuario valido!";
    private static final String MENSAGEM_ERRO = "Usuário inexistente!";

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(value = "/cadastro-usuario", method = RequestMethod.POST)
    public void criarUsuarrio(@RequestBody UsuarioRequestDTO usuarioResquestDTO){
        usuarioService.criarUsuario(usuarioResquestDTO);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(value = "/validar-login", method = RequestMethod.GET)
    public ResponseEntity<String> validarLogin(String usuario, String senha) {
        Optional<Usuario> usuarioOptional = usuarioService.validarUsuarioSenha(usuario, senha);
        if (usuarioOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(MENSAGEM_ERRO);
        }

        return ResponseEntity.status(HttpStatus.OK).body(MENSAGEM_SUCESSO);
    }

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> getUsuarios(){
        return ResponseEntity.ok().body(usuarioService.findAllUsuarios());
    }

    @RequestMapping(value = "/usuarios", method = RequestMethod.POST)
    public void saveUsuarios(String usuario, String senha){
        var usuarioEntity = new Usuario(usuario, senha);
        usuarioService.saveUsuarios(usuarioEntity);
    }
}