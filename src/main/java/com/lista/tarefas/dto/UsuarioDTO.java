package com.lista.tarefas.dto;

import com.lista.tarefas.entities.Usuario;

import java.time.LocalDateTime;

import java.time.LocalDateTime; // Importação necessária para usar LocalDateTime

/**
 * Classe DTO (Data Transfer Object) para representar um usuário.
 * Utilizada para transferir dados entre camadas da aplicação sem expor a entidade original.
 */
public class UsuarioDTO {

    private Long id; // Identificador único do usuário
    private String nome; // Nome do usuário
    private String email; // Email do usuário
    private LocalDateTime dataCadastro; // Data e hora do cadastro do usuário

    /**
     * Construtor padrão sem argumentos.
     * Necessário para frameworks que exigem um construtor vazio, como JPA e Jackson.
     */
    public UsuarioDTO() {}

    /**
     * Construtor que recebe nome, email e data de cadastro.
     * Usado para criar uma instância do DTO a partir de dados individuais.
     *
     * @param nome Nome do usuário
     * @param email Email do usuário
     * @param dataCadastro Data e hora do cadastro
     */
    public UsuarioDTO(String nome, String email, LocalDateTime dataCadastro) {
        this.nome = nome;
        this.email = email;
        this.dataCadastro = dataCadastro;
    }

    /**
     * Construtor que recebe um objeto da entidade Usuario.
     * Usado para converter uma entidade em um DTO, garantindo que apenas os
     * dados necessários sejam expostos.
     *
     * @param usuario Objeto da entidade Usuario
     */
    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        // O campo dataCadastro não é copiado, talvez por não ser necessário no DTO.
    }

    /**
     * Retorna o ID do usuário.
     * @return ID do usuário
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID do usuário.
     * @param id Novo ID do usuário
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o nome do usuário.
     * @return Nome do usuário
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do usuário.
     * @param nome Novo nome do usuário
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o email do usuário.
     * @return Email do usuário
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do usuário.
     * @param email Novo email do usuário
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna a data de cadastro do usuário.
     * @return Data de cadastro do usuário
     */
    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    /**
     * Define a data de cadastro do usuário.
     * @param dataCadastro Nova data de cadastro do usuário
     */
    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}

