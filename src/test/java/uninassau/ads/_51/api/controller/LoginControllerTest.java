package uninassau.ads._51.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LoginController.class)
class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void validarLogin_ShouldReturnSuccess_WhenUsernameAndPasswordAreValid() throws Exception {
        mockMvc.perform(get("/validar-login")
                        .param("username", "validUser")
                        .param("password", "validPassword")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Login efetuado com sucesso!"));
    }

    @Test
    void validarLogin_ShouldReturnUnauthorized_WhenUsernameIsEmpty() throws Exception {
        mockMvc.perform(get("/validar-login")
                        .param("username", "")
                        .param("password", "validPassword")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized())
                .andExpect(content().string("Usuário inexistente!"));
    }

    @Test
    void validarLogin_ShouldReturnUnauthorized_WhenPasswordIsEmpty() throws Exception {
        mockMvc.perform(get("/validar-login")
                        .param("username", "validUser")
                        .param("password", "")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized())
                .andExpect(content().string("Usuário inexistente!"));
    }

    @Test
    void validarLogin_ShouldReturnUnauthorized_WhenBothUsernameAndPasswordAreEmpty() throws Exception {
        mockMvc.perform(get("/validar-login")
                        .param("username", "")
                        .param("password", "")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized())
                .andExpect(content().string("Usuário inexistente!"));
    }
}