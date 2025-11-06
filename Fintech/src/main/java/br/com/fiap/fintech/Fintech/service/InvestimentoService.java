package br.com.fiap.fintech.Fintech.service;

import br.com.fiap.fintech.Fintech.model.InvestimentoModel;
import br.com.fiap.fintech.Fintech.repository.InvestimentoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestimentoService {
    @Autowired
    private InvestimentoRepository investimentoRepository;

    public InvestimentoModel salvar(InvestimentoModel investimento) {
        return investimentoRepository.save(investimento);
    }

    public InvestimentoModel buscarPorId(Long id) {
        Optional<InvestimentoModel> investimento = this.investimentoRepository.findById(id);
        if (investimento.isPresent()) {
            return investimento.get();
        } else {
            throw new RuntimeException("Investimento não encontrado!");
        }
    }

    public List<InvestimentoModel> buscarTodos() {
        return this.investimentoRepository.findAll();
    }

    public InvestimentoModel atualizar(Long id, InvestimentoModel investimento) {
        Optional<InvestimentoModel> investimentoAtual = investimentoRepository.findById(id);
        if (investimentoAtual.isPresent()) {
            return investimentoRepository.save(investimento);
        } else {
            throw new RuntimeException("Investimento não encontrado!");
        }
    }

    public void excluir(Long id) {
        Optional<InvestimentoModel> investimento = investimentoRepository.findById(id);
        if (investimento.isPresent()) {
            this.investimentoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Investimento não encontrado!");
        }
    }
}