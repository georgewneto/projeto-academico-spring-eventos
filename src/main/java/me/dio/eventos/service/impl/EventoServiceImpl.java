package me.dio.eventos.service.impl;

import me.dio.eventos.model.Evento;
import me.dio.eventos.repository.EventoRepository;
import me.dio.eventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public Iterable<Evento> buscarTodos() {
        return eventoRepository.findAll();
    }

    @Override
    public Evento buscarPorId(Long id) {
        Optional<Evento> evento = eventoRepository.findById(id);
        return evento.orElse(null);
    }

    @Override
    public void inserir(Evento evento) {
        eventoRepository.save(evento);
    }

    @Override
    public void atualizar(Long id, Evento evento) {
        eventoRepository.save(evento);
    }

    @Override
    public void deletar(Long id) {
        eventoRepository.deleteById(id);
    }
}
