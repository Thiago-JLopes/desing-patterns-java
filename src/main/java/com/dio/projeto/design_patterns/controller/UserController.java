package com.dio.projeto.design_patterns.controller;

import com.dio.projeto.design_patterns.model.entity.Usuario;
import com.dio.projeto.design_patterns.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("us")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Iterable<Usuario>> buscarTodos(){
        return ResponseEntity.ok(userService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(Long id){
        return ResponseEntity.ok(userService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> inserir(Usuario usuario){
        userService.inserir(usuario);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(Long id, Usuario usuario){
        userService.atualizar(id, usuario);
        return ResponseEntity.ok(usuario);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deletar(Long id){
        userService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
