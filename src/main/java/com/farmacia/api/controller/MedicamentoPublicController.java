package com.farmacia.api.controller;

import com.farmacia.api.dto.MedicamentoResponseDTO;
import com.farmacia.api.service.MedicamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/medicamentos")
@Tag(name = "Medicamentos Público", description = "Endpoints públicos para consulta de medicamentos")
public class MedicamentoPublicController {

    @Autowired
    private MedicamentoService medicamentoService;

    @Operation(summary = "Listar todos os medicamentos", description = "Retorna todos os medicamentos cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medicamentos listados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping
    public ResponseEntity<List<MedicamentoResponseDTO>> getAll() {
        List<MedicamentoResponseDTO> medicamentos = medicamentoService.findAll();
        return ResponseEntity.ok(medicamentos);
    }

    @Operation(summary = "Buscar medicamento por ID", description = "Retorna um medicamento específico pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medicamento encontrado"),
            @ApiResponse(responseCode = "404", description = "Medicamento não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoResponseDTO> getById(
            @Parameter(description = "ID do medicamento") @PathVariable Long id) {
        MedicamentoResponseDTO medicamento = medicamentoService.findById(id);
        return ResponseEntity.ok(medicamento);
    }

    @Operation(summary = "Buscar medicamentos por fabricante", description = "Retorna medicamentos de um fabricante específico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medicamentos encontrados"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/fabricante/{fabricante}")
    public ResponseEntity<List<MedicamentoResponseDTO>> getByFabricante(
            @Parameter(description = "Nome do fabricante") @PathVariable String fabricante) {
        List<MedicamentoResponseDTO> medicamentos = medicamentoService.findByFabricante(fabricante);
        return ResponseEntity.ok(medicamentos);
    }

    @Operation(summary = "Buscar medicamentos por categoria", description = "Retorna medicamentos de uma categoria específica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medicamentos encontrados"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<MedicamentoResponseDTO>> getByCategoria(
            @Parameter(description = "Categoria do medicamento") @PathVariable String categoria) {
        List<MedicamentoResponseDTO> medicamentos = medicamentoService.findByCategoria(categoria);
        return ResponseEntity.ok(medicamentos);
    }

    @Operation(summary = "Listar medicamentos disponíveis", description = "Retorna apenas medicamentos com estoque disponível")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medicamentos listados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/disponiveis")
    public ResponseEntity<List<MedicamentoResponseDTO>> getDisponiveis() {
        List<MedicamentoResponseDTO> medicamentos = medicamentoService.findDisponiveis();
        return ResponseEntity.ok(medicamentos);
    }

    @Operation(summary = "Pesquisar medicamentos por nome", description = "Busca medicamentos pelo nome (case insensitive)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medicamentos encontrados"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/pesquisar")
    public ResponseEntity<List<MedicamentoResponseDTO>> searchByNome(
            @Parameter(description = "Termo de pesquisa") @RequestParam String nome) {
        List<MedicamentoResponseDTO> medicamentos = medicamentoService.searchByNome(nome);
        return ResponseEntity.ok(medicamentos);
    }
}