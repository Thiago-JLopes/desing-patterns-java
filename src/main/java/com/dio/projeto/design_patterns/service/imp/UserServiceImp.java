package com.dio.projeto.design_patterns.service.imp;

import com.dio.projeto.design_patterns.model.entity.Endereco;
import com.dio.projeto.design_patterns.model.entity.Usuario;
import com.dio.projeto.design_patterns.model.repository.EnderecoRepository;
import com.dio.projeto.design_patterns.model.repository.UsuarioRepository;
import com.dio.projeto.design_patterns.service.UserService;
import com.dio.projeto.design_patterns.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImp implements UserService {
    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ViaCepService viaCepService;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.get();
    }

    @Override
    public void inserir(Usuario usuario) {
        salvarClienteComCep(usuario);
    }

    @Override
    public void atualizar(Long id, Usuario usuario) {
        Optional<Usuario> usuarioBd = usuarioRepository.findById(id);
        if (usuarioBd.isPresent()) {
            salvarClienteComCep(usuario);
        }
    }

    @Override
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    private void salvarClienteComCep(Usuario usuario) {
        // Verificar se o Endereco do usuario já existe (pelo CEP).
        String cep = usuario.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        usuario.setEndereco(endereco);
        // Inserir Usuario, vinculando o Endereco (novo ou existente).
        usuarioRepository.save(usuario);
    }
}
