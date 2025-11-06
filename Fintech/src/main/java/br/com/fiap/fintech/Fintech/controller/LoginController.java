package br.com.fiap.fintech.Fintech.controller;

import br.com.fiap.fintech.Fintech.model.LoginModel;
import br.com.fiap.fintech.Fintech.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")

public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LoginModel salvar(@RequestBody LoginModel login) {
        return loginService.salvar(login);
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public LoginModel buscarPorId(@PathVariable Long id) {
        return this.loginService.buscarPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LoginModel> buscarTodos() {
        return this.loginService.buscarTodos();
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public LoginModel atualizar(@PathVariable Long id, @RequestBody LoginModel login) {
        return this.loginService.atualizar(id, login);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        this.loginService.excluir(id);
    }
}
