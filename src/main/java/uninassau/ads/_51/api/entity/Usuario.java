package uninassau.ads._51.api.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Table(name = "usuario")
@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = -2420346134960559062L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "USUARIO", length = 30, nullable = false, unique = true)
    private String usuario;

    @Column(name = "SENHA", length = 6, nullable = false, unique = false)
    private String senha;

    public Usuario() {
    }

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }
    public String getSenha() {
        return senha;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setUsuario(String username) {
        this.usuario = username;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "id=" + id + ", username=" + usuario + ", password=" + senha + '}';
    }

}
