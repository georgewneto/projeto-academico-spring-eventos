package me.dio.eventos.repository;

import me.dio.eventos.model.Inscricao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscricaoRepository extends CrudRepository<Inscricao, Long> {
}
