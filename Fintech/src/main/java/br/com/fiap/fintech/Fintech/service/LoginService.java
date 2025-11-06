package br.com.fiap.fintech.Fintech.service;


import br.com.fiap.fintech.Fintech.model.LoginModel;
import br.com.fiap.fintech.Fintech.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public LoginModel salvar(LoginModel login) {
        return loginRepository.save(login);
    }

    public LoginModel buscarPorId(Long id) {
        Optional<LoginModel> login = loginRepository.findById(id);
        if (login.isPresent()) {
            return login.get();
        } else {
            throw new RuntimeException("Login não encontrado!");
        }
    }

    public List<LoginModel> buscarTodos() {
        return this.loginRepository.findAll();
    }

    public LoginModel atualizar(Long id, LoginModel login) {
        Optional<LoginModel> loginAtual = loginRepository.findById(id);
        if (loginAtual.isPresent()) {
            return loginRepository.save(login);
        } else {
            throw new RuntimeException("Login não encontrado!");
        }
    }

    public void excluir(Long id) {
        Optional<LoginModel> login = loginRepository.findById(id);
        if (login.isPresent()) {
            this.loginRepository.deleteById(id);
        } else {
            throw new RuntimeException("Login não encontrado!");
        }
    }

}
