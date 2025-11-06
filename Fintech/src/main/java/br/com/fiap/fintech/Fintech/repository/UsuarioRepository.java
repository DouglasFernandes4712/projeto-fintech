package br.com.fiap.fintech.Fintech.repository;

import br.com.fiap.fintech.Fintech.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
