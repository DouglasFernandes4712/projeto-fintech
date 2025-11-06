package br.com.fiap.fintech.Fintech.service;

import br.com.fiap.fintech.Fintech.model.Usuario;
import br.com.fiap.fintech.Fintech.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    public UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()){
            return usuario.get();
        } else {
            throw new RuntimeException("Usuario não encontrado");
        }
    }

    public List<Usuario> buscarTodos(){
        return usuarioRepository.findAll();
    }

    public Usuario atualizar(Long id, Usuario usuario){
        Optional<Usuario> usuarioAtual = usuarioRepository.findById(id);
        if (usuarioAtual.isPresent()){
            return usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuario não encontrado");
        }
    }

    public void excluir(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()){
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuario não encontrado");
        }
    }


}
