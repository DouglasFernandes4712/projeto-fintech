package br.com.fiap.fintech.Fintech.controller;

import br.com.fiap.fintech.Fintech.model.TransacaoModel;
import br.com.fiap.fintech.Fintech.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransacaoModel salvar(@RequestBody TransacaoModel transacao) {
        return transacaoService.salvar(transacao);
    }

    // Buscar todos
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TransacaoModel> buscarTodos() {
        return transacaoService.buscarTodos();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransacaoModel buscaPorId(@PathVariable Long id) {
        return transacaoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransacaoModel atualizar(@PathVariable Long id, @RequestBody TransacaoModel transacao) {
        return transacaoService.atualizar(id, transacao);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        transacaoService.excluir(id);
    }
}