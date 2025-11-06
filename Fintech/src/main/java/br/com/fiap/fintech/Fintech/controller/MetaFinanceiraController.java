package br.com.fiap.fintech.Fintech.controller;

import br.com.fiap.fintech.Fintech.model.MetaFinanceira;
import br.com.fiap.fintech.Fintech.service.MetaFinanceiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metafinanceira")
public class MetaFinanceiraController {

    @Autowired
    private MetaFinanceiraService metaFinanceiraService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MetaFinanceira salvar(@RequestBody MetaFinanceira metaFinanceira){
        return metaFinanceiraService.salvar(metaFinanceira);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MetaFinanceira buscarPorId(@PathVariable Long id){
        return metaFinanceiraService.buscarPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MetaFinanceira> buscarTodos(){
        return metaFinanceiraService.buscarTodos();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MetaFinanceira atualizar(@PathVariable Long id, @RequestBody MetaFinanceira metaFinanceira){
        return metaFinanceiraService.atualizar(id, metaFinanceira);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        metaFinanceiraService.excluir(id);
    }

}
