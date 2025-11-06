package br.com.fiap.fintech.Fintech.repository;

import br.com.fiap.fintech.Fintech.model.TransacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository <TransacaoModel, Long> {
}
