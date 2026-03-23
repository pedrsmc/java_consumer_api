package com.projeto.service;

import com.projeto.model.Usuario;
import com.projeto.repository.*;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UsuarioServices {
    UsuarioRepository usuarioRepository = new UsuarioRepository();
    ObjectMapper mapper = new ObjectMapper();

    public List<Usuario> listarUsuarios() throws Exception {
        String json = usuarioRepository.listarUsuarios();

        List<Usuario> usuarios = mapper.readValue(
                json,
                new TypeReference<List<Usuario>>() {
                });

        return usuarios;
    }

    public Usuario buscarUsuario(String id) throws Exception {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID do usuário não pode ser vazio");
        }

        String json = usuarioRepository.buscarUsuario(id);
        Usuario usuario = mapper.readValue(json, Usuario.class);
        return usuario;
    }

    public Usuario cadastrarUsuario(Usuario usuario) throws Exception {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }

        if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do usuário é obrigatório");
        }

        if (usuario.getEmail() == null || !usuario.getEmail().contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }

        if (usuario.getTel() == null || usuario.getTel().trim().isEmpty()) {
            throw new IllegalArgumentException("Telefone é obrigatório");
        }

        if (usuario.getIdade() <= 0 || usuario.getIdade() > 150) {
            throw new IllegalArgumentException("Idade inválida (deve ser entre 1 e 150)");
        }

        String json = mapper.writeValueAsString(usuario);
        String resposta = usuarioRepository.cadastrarUsuario(json);
        Usuario usuarioCriado = mapper.readValue(resposta, Usuario.class);

        return usuarioCriado;
    }

    public Usuario alterarUsuario(String id, Usuario usuario) throws Exception {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID do usuário não pode ser vazio");
        }

        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }

        Usuario usuarioExistente = buscarUsuario(id);

        if (usuario.getNome() != null && !usuario.getNome().trim().isEmpty()) {
            usuarioExistente.setNome(usuario.getNome());
        }

        if (usuario.getEmail() != null && usuario.getEmail().contains("@")) {
            usuarioExistente.setEmail(usuario.getEmail());
        }

        if (usuario.getTel() != null && !usuario.getTel().trim().isEmpty()) {
            usuarioExistente.setTel(usuario.getTel());
        }

        if (usuario.getIdade() > 0 && usuario.getIdade() <= 150) {
            usuarioExistente.setIdade(usuario.getIdade());
        }

        String json = mapper.writeValueAsString(usuarioExistente);
        String resposta = usuarioRepository.alterarUsuario(id, json);

        return mapper.readValue(resposta, Usuario.class);
    }

    public int removerUsuario(String id) throws Exception {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID do usuário não pode ser vazio");
        }

        int resposta = usuarioRepository.removerUsuario(id);
        return resposta;
    }
}