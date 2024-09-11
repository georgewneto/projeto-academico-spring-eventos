package me.dio.eventos.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;
    @OneToOne
    private Evento evento;
    @OneToOne
    private Pessoa pessoa;

    public Inscricao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inscricao inscricao = (Inscricao) o;
        return Objects.equals(id, inscricao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
