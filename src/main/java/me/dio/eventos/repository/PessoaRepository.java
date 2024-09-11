package me.dio.eventos.repository;

import me.dio.eventos.model.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
}
