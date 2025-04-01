package com.lista.tarefas.controller;

import com.lista.tarefas.dto.PegarID;
import com.lista.tarefas.dto.TarefaDTO;
import com.lista.tarefas.dto.UsuarioDTO;
import com.lista.tarefas.service.CadastroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Classe responsével por gerenciar as requisições para a rota /lista
@RestController
@RequestMapping("lista")
public class PublicController {
    //Variável do CadastroService pertencente a classe PublicController
    private CadastroService cadastroService;

    //Contrutor para inserir a dependência CadastroService na variável cadastroService
    public PublicController(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    //Método para a requisição post para a rota /lista/usuario que serve para cadastrar um usuário

    @PostMapping("usuario")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(cadastroService.cadastrarUsuario(usuarioDTO));
    }

    //Método para a requisição post para a rota /lista/tarefa que serve para cadastrar uma tarefa
    @PostMapping("tarefa")
    public ResponseEntity<?> cadastrarTarefa(@Valid @RequestBody TarefaDTO dto) {
        return ResponseEntity.ok(cadastroService.cadastrarTarefa(dto));
    }

    //Método para a requisição post para a rota /lista/attarefa que serve para atualizar as informações da tarefa
    @PostMapping("attarefa")
    public ResponseEntity<?> listarTarefa(@RequestBody TarefaDTO dto) {
        return ResponseEntity.ok(cadastroService.atualizarTarefa(dto));
    }

    //Método para mapear a requisição get para a rota /lista/{id} que recebe o id do usuário e, se ele for existente, retorna as suas informações
    @GetMapping("{id}")
    public ResponseEntity<?> buscarTarefa(@PathVariable Long id) {
        return ResponseEntity.ok(cadastroService.buscarTarefaPorId(id));
    }

    //Método que retorna todas as tarefas cadastradas
    @GetMapping
    public ResponseEntity<?> listarTarefas() {
        return ResponseEntity.ok(cadastroService.listarTarefas());
    }


}
