package me.dio.eventos.controller;

import me.dio.eventos.model.Evento;
import me.dio.eventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("eventos")
public class EventoRestController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public ResponseEntity<Iterable<Evento>> buscarTodos() {
        return ResponseEntity.ok(eventoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(eventoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Evento> inserir(@RequestBody Evento evento) {
        eventoService.inserir(evento);
        return ResponseEntity.ok(evento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> atualizar(@PathVariable Long id, @RequestBody Evento evento) {
        eventoService.atualizar(id, evento);
        return ResponseEntity.ok(evento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        eventoService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
