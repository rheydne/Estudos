package com.rheydne.springboot.services.impl;

import com.rheydne.springboot.models.Usuario;
import com.rheydne.springboot.services.UsuarioService;
import com.rheydne.springboot.services.repositories.UsuarioRepository;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getById(@NonNull Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario create(@NonNull Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(@NonNull Long id, @NonNull Usuario usuario) {
        Usuario user = usuarioRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado para o id: " + id));
        BeanUtils.copyProperties(usuario, user);
        user.setId(id);
        return usuarioRepository.save(user);
    }

    @Override
    public void deleteById(@NonNull Long id) {
        usuarioRepository.deleteById(id);
    }
}
