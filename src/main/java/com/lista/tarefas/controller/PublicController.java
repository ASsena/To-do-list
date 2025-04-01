package com.lista.tarefas.controller;

import com.lista.tarefas.dto.PegarID;
import com.lista.tarefas.dto.TarefaDTO;
import com.lista.tarefas.dto.UsuarioDTO;
import com.lista.tarefas.service.CadastroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("lista")
public class PublicController {

    private CadastroService cadastroService;

    public PublicController(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    @PostMapping("usuario")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(cadastroService.cadastrarUsuario(usuarioDTO));
    }

    @PostMapping("tarefa")
    public ResponseEntity<?> cadastrarTarefa(@Valid @RequestBody TarefaDTO dto) {
        return ResponseEntity.ok(cadastroService.cadastrarTarefa(dto));
    }

    @PostMapping("attarefa")
    public ResponseEntity<?> listarTarefa(@RequestBody TarefaDTO dto) {
        return ResponseEntity.ok(cadastroService.atualizarTarefa(dto));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> buscarTarefa(@PathVariable Long id) {
        return ResponseEntity.ok(cadastroService.buscarTarefaPorId(id));
    }

    @GetMapping
    public ResponseEntity<?> listarTarefas() {
        return ResponseEntity.ok(cadastroService.listarTarefas());
    }


}
