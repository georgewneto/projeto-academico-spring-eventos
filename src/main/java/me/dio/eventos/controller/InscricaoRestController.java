package me.dio.eventos.controller;

import me.dio.eventos.model.Inscricao;
import me.dio.eventos.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("inscricoes")
public class InscricaoRestController {

    @Autowired
    private InscricaoService inscricaoService;

    @GetMapping
    public ResponseEntity<Iterable<Inscricao>> buscarTodos() {
        return ResponseEntity.ok(inscricaoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscricao> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(inscricaoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Inscricao> inserir(@RequestBody Inscricao inscricao) {
        inscricaoService.inserir(inscricao);
        return ResponseEntity.ok(inscricao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inscricao> atualizar(@PathVariable Long id, @RequestBody Inscricao inscricao) {
        inscricaoService.atualizar(id, inscricao);
        return ResponseEntity.ok(inscricao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        inscricaoService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
