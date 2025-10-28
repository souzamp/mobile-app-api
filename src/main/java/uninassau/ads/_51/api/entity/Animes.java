package uninassau.ads._51.api.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "animes")
public class Animes implements Serializable {
    private static final long serialVersionUID = -2420346134960559062L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String genero;

    public Animes(Long id, String nome, String genero) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
    }

    public Animes() {}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}

