package com.rheydne.springboot.services;

import com.rheydne.springboot.models.Usuario;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface UsuarioService {
    List<Usuario> getAll();

    Usuario getById(@NonNull Long id);

    @Transactional
    Usuario create(@NonNull Usuario usuario);

    @Transactional
    Usuario update(@NonNull Long id, @NonNull Usuario usuario);

    @Transactional
    void deleteById(@NonNull Long id);
}
