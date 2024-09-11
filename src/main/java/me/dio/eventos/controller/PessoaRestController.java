package me.dio.eventos.controller;

import me.dio.eventos.model.Inscricao;
import me.dio.eventos.model.Pessoa;
import me.dio.eventos.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pessoa")
public class PessoaRestController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<Iterable<Pessoa>> buscarTodos() {
        return ResponseEntity.ok(pessoaService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Pessoa> inserir(@RequestBody Pessoa pessoa) {
        pessoaService.inserir(pessoa);
        return ResponseEntity.ok(pessoa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        pessoaService.atualizar(id, pessoa);
        return ResponseEntity.ok(pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pessoaService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
