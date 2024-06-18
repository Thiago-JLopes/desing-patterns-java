package com.dio.projeto.design_patterns.model.repository;

import com.dio.projeto.design_patterns.model.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
