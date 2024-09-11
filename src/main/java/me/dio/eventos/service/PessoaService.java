package me.dio.eventos.service;

import me.dio.eventos.model.Pessoa;
import org.springframework.stereotype.Service;

@Service
public interface PessoaService {
    Iterable<Pessoa> buscarTodos();

    Pessoa buscarPorId(Long id);

    void inserir(Pessoa pessoa);

    void atualizar(Long id, Pessoa pessoa);

    void deletar(Long id);
}
