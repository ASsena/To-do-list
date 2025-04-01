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

@Service
public class CadastroService {

    private UsuarioRepository usuarioRepository;
    private TarefaRepository tarefaRepository;

    public CadastroService(UsuarioRepository usuarioRepository, TarefaRepository tarefaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.tarefaRepository = tarefaRepository;
    }

    public UsuarioDTO cadastrarUsuario(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuarioRepository.save(usuario);
        return new UsuarioDTO(usuario);
    }

    public TarefaDTO cadastrarTarefa(TarefaDTO dto) {

        var user = usuarioRepository.getReferenceById(dto.getIdUser());

        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setDataCadastro(LocalDateTime.now());
        tarefa.setPrioridade(Prioridade.BAIXA);
        tarefa.setNomeSetor(dto.getNomeSetor());
        tarefa.setStatus(Status.A_FAZER);
        tarefa.setUsuario(user);

        tarefaRepository.save(tarefa);

        return new TarefaDTO(tarefa);
    }
    @Transactional
    public TarefaDTO atualizarTarefa(TarefaDTO dto) {
        var user = usuarioRepository.getReferenceById(dto.getIdUser());
        var tarefaFind = tarefaRepository.findById(dto.getId());
        tarefaFind.get().atualizarTarefa(dto);
        tarefaRepository.save(tarefaFind.get());
        return new TarefaDTO(tarefaFind.get());
    }

    public List<Tarefa> buscarTarefaPorId(Long id) {
        var usuario = usuarioRepository.findById(id);
        List<Tarefa> tarefas = tarefaRepository.findAll().stream().filter(tarefa -> tarefa.getUsuario().getId() == usuario.get().getId()).collect(Collectors.toList());
        return tarefas;
    }

    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }
}
