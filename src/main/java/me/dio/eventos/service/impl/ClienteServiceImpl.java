package me.dio.eventos.service.impl;

import me.dio.eventos.model.Cliente;
import me.dio.eventos.repository.ClienteRepository;
import me.dio.eventos.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        if (clienteRepository.findById(id).isEmpty()) {
            return null;
        }
        return clienteRepository.findById(id).get();
    }

    @Override
    public void inserir(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        if (clienteRepository.findById(id).isEmpty()) {
            return;
        }
        clienteRepository.save(cliente);
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}
