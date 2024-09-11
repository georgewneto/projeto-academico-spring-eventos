package me.dio.eventos.service;

import me.dio.eventos.model.Evento;
import org.springframework.stereotype.Service;

@Service
public interface EventoService {
    Iterable<Evento> buscarTodos();

    Evento buscarPorId(Long id);

    void inserir(Evento evento);

    void atualizar(Long id, Evento evento);

    void deletar(Long id);
}
