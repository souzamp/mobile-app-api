package uninassau.ads._51.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@Tag(name = "LoginController", description = "Controller responsável por fazer validações de login")
public class LoginController {

    private static final String MENSAGEM_SUCESSO = "Login efetuado com sucesso!";
    private static final String MENSAGEM_ERRO = "Usuário inexistente!";

    @RequestMapping(value = "/validar-login", method = RequestMethod.GET)
    public ResponseEntity<String> validarLogin(String username, String password) {
        if (isLoginValido(username, password)) {
            return ResponseEntity.ok().body(MENSAGEM_SUCESSO);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(MENSAGEM_ERRO);
    }

    private boolean isLoginValido(String username, String password) {
        return !Strings.isBlank(username) &&  !Strings.isBlank(password);
    }
}