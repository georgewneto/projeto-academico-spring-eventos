package me.dio.eventos.service.impl;

import me.dio.eventos.model.Inscricao;
import me.dio.eventos.repository.InscricaoRepository;
import me.dio.eventos.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscricaoServiceImpl implements InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Override
    public Iterable<Inscricao> buscarTodos() {
        return inscricaoRepository.findAll();
    }

    @Override
    public Inscricao buscarPorId(Long id) {
        return inscricaoRepository.findById(id).orElse(null);
    }

    @Override
    public void inserir(Inscricao inscricao) {
        inscricaoRepository.save(inscricao);
    }

    @Override
    public void atualizar(Long id, Inscricao inscricao) {
        inscricaoRepository.save(inscricao);
    }

    @Override
    public void deletar(Long id) {
        inscricaoRepository.deleteById(id);
    }
}
