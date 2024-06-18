package com.dio.projeto.design_patterns.service;

import com.dio.projeto.design_patterns.model.entity.Usuario;

/**
* Interface que define o padrão Strategy no domínio de cliente.
* Com isso, se necessário, podemos ter multiplas implementações dessa mesma interface.
* @author  Thiago José lopes
* */
public interface UserService {
    Iterable<Usuario> buscarTodos();
    Usuario buscarPorId(Long id);
    void inserir(Usuario usuario);
    void atualizar(Long id, Usuario usuario);
    void deletar(Long id);
}
