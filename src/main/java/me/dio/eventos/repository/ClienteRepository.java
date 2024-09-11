package me.dio.eventos.repository;

import me.dio.eventos.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository <Cliente, Long> {
}
