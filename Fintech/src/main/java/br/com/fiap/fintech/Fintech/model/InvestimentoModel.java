package br.com.fiap.fintech.Fintech.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_INVESTIMENTO")
public class InvestimentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_INVESTIMENTO")
    @SequenceGenerator(name = "SEQ_INVESTIMENTO", sequenceName = "SEQ_INVESTIMENTO", allocationSize = 1)
    @Column(name = "id_investimento")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "T_USUARIO_id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "ds_tipo_investimento")
    private String tipoInvestimento;

    @Column(name = "vl_investimento")
    private double valorInvestimento;

    @Column(name = "ds_rentabilidade")
    private double rentabilidade;

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

    public String getTipoInvestimento() {
        return tipoInvestimento;
    }

    public void setTipoInvestimento(String tipoInvestimento) {
        this.tipoInvestimento = tipoInvestimento;
    }

    public double getValorInvestimento() {
        return valorInvestimento;
    }

    public void setValorInvestimento(double valorInvestimento) {
        this.valorInvestimento = valorInvestimento;
    }

    public double getRentabilidade() {
        return rentabilidade;
    }

    public void setRentabilidade(double rentabilidade) {
        this.rentabilidade = rentabilidade;
    }
}