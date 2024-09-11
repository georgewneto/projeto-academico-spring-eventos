package me.dio.eventos.service.impl;

import me.dio.eventos.model.Usuario;
import me.dio.eventos.repository.UsuarioRepository;
import me.dio.eventos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Iterable<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void inserir(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void atualizar(Long id, Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
