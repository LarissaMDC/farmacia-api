package com.farmacia.api.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "medicamentos")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String fabricante;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(nullable = false, name = "quantidade_estoque")
    private Integer quantidadeEstoque;

    @Column(nullable = false)
    private String categoria;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "prescricao_obrigatoria")
    private Boolean prescricaoObrigatoria = false;

    @Column(name = "data_validade")
    private LocalDateTime dataValidade;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao = LocalDateTime.now();

    // Constructors
    public Medicamento() {}

    public Medicamento(String nome, String fabricante, BigDecimal preco,
                       Integer quantidadeEstoque, String categoria,
                       String descricao, Boolean prescricaoObrigatoria,
                       LocalDateTime dataValidade) {
        this.nome = nome;
        this.fabricante = fabricante;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
        this.descricao = descricao;
        this.prescricaoObrigatoria = prescricaoObrigatoria;
        this.dataValidade = dataValidade;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public Integer getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public boolean isPrescricaoObrigatoria() { return prescricaoObrigatoria; }
    public void setPrescricaoObrigatoria(boolean prescricaoObrigatoria) {
        this.prescricaoObrigatoria = prescricaoObrigatoria;
    }

    public LocalDateTime getDataValidade() { return dataValidade; }
    public void setDataValidade(LocalDateTime dataValidade) {
        this.dataValidade = dataValidade;
    }

    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataAtualizacao() { return dataAtualizacao; }
    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}