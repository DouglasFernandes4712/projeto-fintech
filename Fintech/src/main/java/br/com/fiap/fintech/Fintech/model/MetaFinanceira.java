package br.com.fiap.fintech.Fintech.model;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "T_META_FINANCEIRA")
public class MetaFinanceira {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_META_FINANCEIRA")
    @SequenceGenerator(name = "SEQ_META_FINANCEIRA", sequenceName = "SEQ_META_FINANCEIRA", allocationSize = 1)
    @Column(name = "id_meta_financeira")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "T_USUARIO_id_usuario", nullable = false)
    private Usuario usuario;


    @Column(name = "ds_meta_financeira")
    private String descricao;

    @Column(name = "vl_meta_financeira")
    private double valor;

    @Column(name = "dt_limite")
    private LocalDate dataLimite;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }
}
