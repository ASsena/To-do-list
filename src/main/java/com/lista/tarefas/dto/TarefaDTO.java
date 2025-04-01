package com.lista.tarefas.dto;

import com.lista.tarefas.entities.Prioridade;
import com.lista.tarefas.entities.Status;
import com.lista.tarefas.entities.Tarefa;

import java.time.LocalDateTime;

public class TarefaDTO {

    private Long id;
    private LocalDateTime dataCadastro;
    private Long idUser;
    private String descricao;
    private String nomeSetor;
    private Prioridade prioridade;
    private Status status;

    public TarefaDTO(Long id, LocalDateTime dataCadastro, Long idUser, String descricao, String nomeSetor, Prioridade prioridade, Status status) {
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.idUser = idUser;
        this.descricao = descricao;
        this.nomeSetor = nomeSetor;
        this.prioridade = prioridade;
        this.status = status;
    }

    public TarefaDTO(Tarefa tarefa) {
        this.id = tarefa.getId();
        this.dataCadastro = tarefa.getDataCadastro();
        this.descricao = tarefa.getDescricao();
        this.nomeSetor = tarefa.getNomeSetor();
        this.prioridade = tarefa.getPrioridade();
        this.status = tarefa.getStatus();
        this.idUser = tarefa.getUsuario().getId();
    }

    public TarefaDTO() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
