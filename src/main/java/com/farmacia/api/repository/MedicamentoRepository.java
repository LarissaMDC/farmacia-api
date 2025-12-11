package com.farmacia.api.repository;

import com.farmacia.api.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

    List<Medicamento> findByFabricante(String fabricante);

    List<Medicamento> findByCategoria(String categoria);

    List<Medicamento> findByPrescricaoObrigatoria(boolean prescricaoObrigatoria);

    @Query("SELECT m FROM Medicamento m WHERE m.quantidadeEstoque > 0")
    List<Medicamento> findDisponiveis();

    @Query("SELECT m FROM Medicamento m WHERE m.preco BETWEEN :min AND :max")
    List<Medicamento> findByPrecoBetween(@Param("min") Double min, @Param("max") Double max);

    Optional<Medicamento> findByNome(String nome);

    @Query("SELECT m FROM Medicamento m WHERE LOWER(m.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Medicamento> findByNomeContainingIgnoreCase(@Param("nome") String nome);
}