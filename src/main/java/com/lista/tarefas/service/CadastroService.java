package com.lista.tarefas.service;

import com.lista.tarefas.dto.PegarID;
import com.lista.tarefas.dto.TarefaDTO;
import com.lista.tarefas.dto.UsuarioDTO;
import com.lista.tarefas.entities.Prioridade;
import com.lista.tarefas.repository.TarefaRepository;
import com.lista.tarefas.repository.UsuarioRepository;
import com.lista.tarefas.entities.Status;
import com.lista.tarefas.entities.Tarefa;
import com.lista.tarefas.entities.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service // Indica que essa classe é um serviço do Spring, gerenciado pelo contexto da aplicação
public class CadastroService {

    // Repositórios para acesso ao banco de dados
    private UsuarioRepository usuarioRepository;
    private TarefaRepository tarefaRepository;

    // Construtor que recebe os repositórios como dependências e os inicializa
    public CadastroService(UsuarioRepository usuarioRepository, TarefaRepository tarefaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.tarefaRepository = tarefaRepository;
    }

    // Método para cadastrar um novo usuário
    public UsuarioDTO cadastrarUsuario(UsuarioDTO dto) {
        Usuario usuario = new Usuario(); // Cria um novo usuário
        usuario.setNome(dto.getNome()); // Define o nome do usuário
        usuario.setEmail(dto.getEmail()); // Define o e-mail do usuário
        usuarioRepository.save(usuario); // Salva o usuário no banco de dados
        return new UsuarioDTO(usuario); // Retorna um DTO do usuário salvo
    }

    // Método para cadastrar uma nova tarefa
    public TarefaDTO cadastrarTarefa(TarefaDTO dto) {
        var user = usuarioRepository.getReferenceById(dto.getIdUser()); // Obtém a referência do usuário pelo ID

        Tarefa tarefa = new Tarefa(); // Cria uma nova tarefa
        tarefa.setDescricao(dto.getDescricao()); // Define a descrição da tarefa
        tarefa.setDataCadastro(LocalDateTime.now()); // Define a data de cadastro como o momento atual
        tarefa.setPrioridade(Prioridade.BAIXA); // Define a prioridade como BAIXA
        tarefa.setNomeSetor(dto.getNomeSetor()); // Define o setor da tarefa
        tarefa.setStatus(Status.A_FAZER); // Define o status como "A FAZER"
        tarefa.setUsuario(user); // Associa a tarefa ao usuário encontrado

        tarefaRepository.save(tarefa); // Salva a tarefa no banco de dados

        return new TarefaDTO(tarefa); // Retorna um DTO da tarefa salva
    }

    @Transactional // Garante que a atualização seja feita dentro de uma transação
    public TarefaDTO atualizarTarefa(TarefaDTO dto) {
        var user = usuarioRepository.getReferenceById(dto.getIdUser()); // Obtém o usuário pelo ID
        var tarefaFind = tarefaRepository.findById(dto.getId()); // Busca a tarefa pelo ID

        tarefaFind.get().atualizarTarefa(dto); // Atualiza os dados da tarefa com as informações do DTO
        tarefaRepository.save(tarefaFind.get()); // Salva a tarefa atualizada no banco de dados

        return new TarefaDTO(tarefaFind.get()); // Retorna um DTO da tarefa atualizada
    }

    // Método para buscar todas as tarefas de um usuário específico pelo ID
    public List<Tarefa> buscarTarefaPorId(Long id) {
        var usuario = usuarioRepository.findById(id); // Busca o usuário pelo ID
        List<Tarefa> tarefas = tarefaRepository.findAll().stream() // Obtém todas as tarefas
            .filter(tarefa -> tarefa.getUsuario().getId() == usuario.get().getId()) // Filtra as tarefas do usuário específico
            .collect(Collectors.toList()); // Converte a stream em uma lista

        return tarefas; // Retorna a lista de tarefas do usuário
    }

    // Método para listar todas as tarefas do banco de dados
    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll(); // Retorna todas as tarefas cadastradas
    }
}
