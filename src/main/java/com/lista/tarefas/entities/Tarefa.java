package com.lista.tarefas.entities;

import com.lista.tarefas.dto.TarefaDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Usuario usuario;
//    private Long Idusuario;
    private String descricao;
    private String nomeSetor;
    private Prioridade prioridade;
    private Status status;
    private LocalDateTime dataCadastro;

    public Tarefa(Long id, String descricao, String nomeSetor, Prioridade prioridade, Status status, Usuario usuario, LocalDateTime dataCadastro) {
        this.id = id;
        this.usuario = usuario;
        this.descricao = descricao;
        this.nomeSetor = nomeSetor;
        this.prioridade = prioridade;
        this.status = status;
        this.dataCadastro = dataCadastro;
    }

    public Tarefa() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }


    public void atualizarTarefa(TarefaDTO dto) {
        if(dto.getDescricao() != null){
            this.setDescricao(dto.getDescricao());
        }if(dto.getNomeSetor() != null){
            this.setNomeSetor(dto.getNomeSetor());
        }if(dto.getPrioridade() != null){
            this.setPrioridade(dto.getPrioridade());
        }if(dto.getStatus() != null){
            this.setStatus(dto.getStatus());
        }
    }
}
