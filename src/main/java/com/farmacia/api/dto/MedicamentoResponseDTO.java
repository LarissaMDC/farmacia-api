package com.farmacia.api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MedicamentoResponseDTO {

    private Long id;
    private String nome;
    private String fabricante;
    private BigDecimal preco;
    private Integer quantidadeEstoque;
    private String categoria;
    private String descricao;
    private boolean prescricaoObrigatoria;
    private LocalDateTime dataValidade;
    private LocalDateTime dataCadastro;

    // Construtor
    public MedicamentoResponseDTO() {}

    public MedicamentoResponseDTO(Long id, String nome, String fabricante,
                                  BigDecimal preco, Integer quantidadeEstoque,
                                  String categoria, String descricao,
                                  boolean prescricaoObrigatoria,
                                  LocalDateTime dataValidade,
                                  LocalDateTime dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
        this.descricao = descricao;
        this.prescricaoObrigatoria = prescricaoObrigatoria;
        this.dataValidade = dataValidade;
        this.dataCadastro = dataCadastro;
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
}