package br.com.fiap.fintech.Fintech.controller;

import br.com.fiap.fintech.Fintech.model.InvestimentoModel;
import br.com.fiap.fintech.Fintech.service.InvestimentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/investimento"})
public class InvestimentoController {
    @Autowired
    private InvestimentoService investimentoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvestimentoModel salvar(@RequestBody InvestimentoModel investimento) {
        return this.investimentoService.salvar(investimento);
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public InvestimentoModel buscarPorId(@PathVariable Long id) {
        return investimentoService.buscarPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InvestimentoModel> buscarTodos() {
        return investimentoService.buscarTodos();
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public InvestimentoModel atualizar(@PathVariable Long id, @RequestBody InvestimentoModel investimento) {
        return investimentoService.atualizar(id, investimento);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        investimentoService.excluir(id);
    }
}
