package com.farmacia.api.controller;

import com.farmacia.api.dto.MedicamentoRequestDTO;
import com.farmacia.api.dto.MedicamentoResponseDTO;
import com.farmacia.api.service.MedicamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fornecedor/medicamentos")
@Tag(name = "Medicamentos Fornecedor", description = "Endpoints para gerenciamento completo de medicamentos (CRUD)")
public class MedicamentoFornecedorController {

    @Autowired
    private MedicamentoService medicamentoService;

    @Operation(summary = "Criar novo medicamento", description = "Cadastra um novo medicamento no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Medicamento criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PostMapping
    public ResponseEntity<MedicamentoResponseDTO> create(
            @Parameter(description = "Dados do medicamento")
            @Valid @RequestBody MedicamentoRequestDTO medicamentoDTO) {
        MedicamentoResponseDTO createdMedicamento = medicamentoService.create(medicamentoDTO);
        return new ResponseEntity<>(createdMedicamento, HttpStatus.CREATED);
    }

    @Operation(summary = "Atualizar medicamento", description = "Atualiza um medicamento existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medicamento atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "404", description = "Medicamento não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<MedicamentoResponseDTO> update(
            @Parameter(description = "ID do medicamento") @PathVariable Long id,
            @Parameter(description = "Novos dados do medicamento")
            @Valid @RequestBody MedicamentoRequestDTO medicamentoDTO) {
        MedicamentoResponseDTO updatedMedicamento = medicamentoService.update(id, medicamentoDTO);
        return ResponseEntity.ok(updatedMedicamento);
    }

    @Operation(summary = "Deletar medicamento", description = "Remove um medicamento do sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Medicamento deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Medicamento não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID do medicamento") @PathVariable Long id) {
        medicamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Atualizar estoque", description = "Adiciona ou remove quantidade do estoque de um medicamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estoque atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Quantidade inválida"),
            @ApiResponse(responseCode = "404", description = "Medicamento não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PatchMapping("/{id}/estoque")
    public ResponseEntity<MedicamentoResponseDTO> updateEstoque(
            @Parameter(description = "ID do medicamento") @PathVariable Long id,
            @Parameter(description = "Quantidade a ser adicionada (positiva) ou removida (negativa)")
            @RequestParam Integer quantidade) {
        MedicamentoResponseDTO updatedMedicamento = medicamentoService.atualizarEstoque(id, quantidade);
        return ResponseEntity.ok(updatedMedicamento);
    }

    // Métodos de consulta também disponíveis para fornecedores
    @Operation(summary = "Listar todos os medicamentos", description = "Retorna todos os medicamentos cadastrados")
    @GetMapping
    public ResponseEntity<List<MedicamentoResponseDTO>> getAll() {
        List<MedicamentoResponseDTO> medicamentos = medicamentoService.findAll();
        return ResponseEntity.ok(medicamentos);
    }

    @Operation(summary = "Buscar medicamento por ID", description = "Retorna um medicamento específico pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoResponseDTO> getById(@PathVariable Long id) {
        MedicamentoResponseDTO medicamento = medicamentoService.findById(id);
        return ResponseEntity.ok(medicamento);
    }
}