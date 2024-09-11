package me.dio.eventos.service;

import me.dio.eventos.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {
    Iterable<Usuario> buscarTodos();

    Usuario buscarPorId(Long id);

    void inserir(Usuario usuario);

    void atualizar(Long id, Usuario usuario);

    void deletar(Long id);
}
