package com.lista.tarefas.entities;

import com.lista.tarefas.dto.TarefaDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;

// Define que a classe é uma entidade JPA, mapeando-a para uma tabela no banco de dados.
@Entity  
@Table(name = "tb_tarefas")  
public class Tarefa {  

    // Define o campo "id" como chave primária da entidade e configura a geração automática do valor.
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;  

    // Define um relacionamento Many-to-One com a entidade Usuario, indicando que várias tarefas podem pertencer a um único usuário.
    @ManyToOne  
    private Usuario usuario;  

    // Campos da entidade que armazenam informações sobre a tarefa.
    private String descricao;  
    private String nomeSetor;  
    private Prioridade prioridade;  
    private Status status;  
    private LocalDateTime dataCadastro;  

    // Construtor completo da classe, utilizado para instanciar objetos da entidade com todos os atributos preenchidos.
    public Tarefa(Long id, String descricao, String nomeSetor, Prioridade prioridade, Status status, Usuario usuario, LocalDateTime dataCadastro) {  
        this.id = id;  
        this.usuario = usuario;  
        this.descricao = descricao;  
        this.nomeSetor = nomeSetor;  
        this.prioridade = prioridade;  
        this.status = status;  
        this.dataCadastro = dataCadastro;  
    }  

    // Construtor vazio, necessário para o funcionamento do JPA.
    public Tarefa() {}  

    // Métodos getters e setters para acessar e modificar os atributos da classe.

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

    // Método que atualiza os atributos da tarefa com base nos valores recebidos de um DTO (Data Transfer Object).
    public void atualizarTarefa(TarefaDTO dto) {  
        if(dto.getDescricao() != null){  
            this.setDescricao(dto.getDescricao());  
        }  
        if(dto.getNomeSetor() != null){  
            this.setNomeSetor(dto.getNomeSetor());  
        }  
        if(dto.getPrioridade() != null){  
            this.setPrioridade(dto.getPrioridade());  
        }  
        if(dto.getStatus() != null){  
            this.setStatus(dto.getStatus());  
        }  
    }  
}  
