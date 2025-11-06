package br.com.fiap.fintech.Fintech.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_LOGIN")
public class LoginModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LOGIN")
    @SequenceGenerator(name = "SEQ_LOGIN", sequenceName = "SEQ_LOGIN", allocationSize = 1)
    @Column(name = "id_login", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "T_USUARIO_id_usuario", nullable = false, unique = true)
    private Usuario usuario;


    @Column(name = "ds_metodo_senha")
    private String dsMetodoSenha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDsMetodoSenha() {
        return dsMetodoSenha;
    }

    public void setDsMetodoSenha(String dsMetodoSenha) {
        this.dsMetodoSenha = dsMetodoSenha;
    }

}
