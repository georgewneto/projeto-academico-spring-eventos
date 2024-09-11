package me.dio.eventos.service;

import me.dio.eventos.model.Inscricao;
import org.springframework.stereotype.Service;

@Service
public interface InscricaoService {
    Iterable<Inscricao> buscarTodos();

    Inscricao buscarPorId(Long id);

    void inserir(Inscricao inscricao);

    void atualizar(Long id, Inscricao inscricao);

    void deletar(Long id);
}
