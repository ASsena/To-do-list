package com.lista.tarefas.dto;

import com.lista.tarefas.entities.Prioridade;
import com.lista.tarefas.entities.Status;
import com.lista.tarefas.entities.Tarefa;

import java.time.LocalDateTime;
/**
 * Classe DTO (Data Transfer Object) para representar uma tarefa.
 * Essa classe é usada para transferir dados de uma entidade Tarefa de forma segura e otimizada.
 */
public class TarefaDTO {

    // Atributos da classe, representando os dados de uma tarefa
    private Long id; // Identificador único da tarefa
    private LocalDateTime dataCadastro; // Data e hora do cadastro da tarefa
    private Long idUser; // Identificador do usuário responsável pela tarefa
    private String descricao; // Descrição detalhada da tarefa
    private String nomeSetor; // Nome do setor ao qual a tarefa pertence
    private Prioridade prioridade; // Nível de prioridade da tarefa (ex: ALTA, MÉDIA, BAIXA)
    private Status status; // Estado atual da tarefa (ex: PENDENTE, CONCLUÍDO)

    /**
     * Construtor que inicializa todos os atributos da classe.
     * 
     * @param id            Identificador da tarefa
     * @param dataCadastro  Data de cadastro da tarefa
     * @param idUser        Identificador do usuário responsável
     * @param descricao     Descrição da tarefa
     * @param nomeSetor     Nome do setor da tarefa
     * @param prioridade    Prioridade da tarefa
     * @param status        Status da tarefa
     */
    public TarefaDTO(Long id, LocalDateTime dataCadastro, Long idUser, String descricao, String nomeSetor, Prioridade prioridade, Status status) {
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.idUser = idUser;
        this.descricao = descricao;
        this.nomeSetor = nomeSetor;
        this.prioridade = prioridade;
        this.status = status;
    }

    /**
     * Construtor que recebe um objeto da entidade Tarefa e inicializa os atributos
     * com base nos dados da entidade.
     * 
     * @param tarefa Objeto da entidade Tarefa
     */
    public TarefaDTO(Tarefa tarefa) {
        this.id = tarefa.getId();
        this.dataCadastro = tarefa.getDataCadastro();
        this.descricao = tarefa.getDescricao();
        this.nomeSetor = tarefa.getNomeSetor();
        this.prioridade = tarefa.getPrioridade();
        this.status = tarefa.getStatus();
        this.idUser = tarefa.getUsuario().getId();
    }

    /**
     * Construtor vazio (padrão), útil para frameworks que necessitam de um 
     * construtor sem parâmetros, como o Jackson para serialização e desserialização.
     */
    public TarefaDTO() {}

    // Métodos getters e setters para acessar e modificar os atributos da classe

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
