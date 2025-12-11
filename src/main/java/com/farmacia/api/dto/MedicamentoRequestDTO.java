package com.farmacia.api.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MedicamentoRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "Fabricante é obrigatório")
    @Size(min = 3, max = 100, message = "Fabricante deve ter entre 3 e 100 caracteres")
    private String fabricante;

    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "Preço deve ser maior que zero")
    private BigDecimal preco;

    @NotNull(message = "Quantidade em estoque é obrigatória")
    @Min(value = 0, message = "Quantidade não pode ser negativa")
    private Integer quantidadeEstoque;

    @NotBlank(message = "Categoria é obrigatória")
    private String categoria;

    private String descricao;

    @NotNull(message = "Prescrição médica obrigatória é obrigatório")
    private boolean prescricaoObrigatoria;

    private LocalDateTime dataValidade;

    // Getters e Setters
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
}