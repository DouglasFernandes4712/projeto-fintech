package br.com.fiap.fintech.Fintech.repository;

import br.com.fiap.fintech.Fintech.model.InvestimentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestimentoRepository extends JpaRepository<InvestimentoModel, Long> {
}
