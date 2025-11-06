package br.com.fiap.fintech.Fintech.service;

import br.com.fiap.fintech.Fintech.model.MetaFinanceira;
import br.com.fiap.fintech.Fintech.repository.MetaFinanceiraRepository;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetaFinanceiraService {

    @Autowired
    private MetaFinanceiraRepository metaFinanceiraRepository;

    public MetaFinanceira salvar(MetaFinanceira metaFinanceira){
        return metaFinanceiraRepository.save(metaFinanceira);
    }

    public MetaFinanceira buscarPorId(Long id){
        Optional<MetaFinanceira> metaFinanceira = metaFinanceiraRepository.findById(id);
        if (metaFinanceira.isPresent()){
            return metaFinanceira.get();
        } else {
            throw new RuntimeException("Meta financeira não encontrado!");
        }
    }

    public List<MetaFinanceira> buscarTodos(){
        return metaFinanceiraRepository.findAll();
    }

    public MetaFinanceira atualizar(Long id, MetaFinanceira metaFinanceira){
        Optional<MetaFinanceira> metaFinanceiraAtual = metaFinanceiraRepository.findById(id);
        if (metaFinanceiraAtual.isPresent()){
            return metaFinanceiraRepository.save(metaFinanceira);
        } else {
            throw new RuntimeException("Meta financeira não encontrado!");
        }
    }

    public void excluir(Long id){
        Optional<MetaFinanceira> metaFinanceira = metaFinanceiraRepository.findById(id);
        if (metaFinanceira.isPresent()){
            metaFinanceiraRepository.deleteById(id);
        } else {
            throw new RuntimeException("Meta financeira não encontrado!");
        }
    }
}
