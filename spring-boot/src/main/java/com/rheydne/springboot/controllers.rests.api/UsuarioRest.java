package com.rheydne.springboot.controllers.rests.api;

import com.rheydne.springboot.models.Usuario;
import com.rheydne.springboot.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsuarioRest {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioRest(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        List<Usuario> users = usuarioService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id) {
        Usuario user = usuarioService.getById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        Usuario user = usuarioService.create(usuario);
        return ResponseEntity.ok(user);
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario user = usuarioService.update(id, usuario);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }
}
