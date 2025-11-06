package br.com.fiap.fintech.Fintech.service;


import br.com.fiap.fintech.Fintech.model.TransacaoModel;
import br.com.fiap.fintech.Fintech.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public TransacaoModel salvar (TransacaoModel transacao) {
        return transacaoRepository.save(transacao);
    }

    public TransacaoModel buscarPorId (Long id){
        Optional<TransacaoModel> transacao = transacaoRepository.findById(id);
        if (transacao.isPresent()){
            return transacao.get();
        }else{
            throw new RuntimeException("Transação não encontrada.");
        }
    }

    public List<TransacaoModel> buscarTodos () {
        return transacaoRepository.findAll();
    }

    public TransacaoModel atualizar (Long id, TransacaoModel transacao) {
        Optional<TransacaoModel>transacaoAtual = transacaoRepository.findById(id);
        if (transacaoAtual.isPresent()){
            return transacaoRepository.save(transacao);
        } else {
            throw new RuntimeException("Transação não encontrada.");
        }
    }

    public void excluir (Long id){
        Optional<TransacaoModel> transacao = transacaoRepository.findById(id);
        if (transacao.isPresent()){
            transacaoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Transação não encontrada.");
        }
    }
}