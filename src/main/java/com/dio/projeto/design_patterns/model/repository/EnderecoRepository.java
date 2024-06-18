package com.dio.projeto.design_patterns.model.repository;

import com.dio.projeto.design_patterns.model.entity.Endereco;
import org.springframework.data.repository.CrudRepository;

public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
