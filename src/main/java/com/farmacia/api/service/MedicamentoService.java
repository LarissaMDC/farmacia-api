package com.farmacia.api.service;

import com.farmacia.api.dto.MedicamentoRequestDTO;
import com.farmacia.api.dto.MedicamentoResponseDTO;
import com.farmacia.api.exception.MedicamentoNotFoundException;
import com.farmacia.api.model.Medicamento;
import com.farmacia.api.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    private MedicamentoResponseDTO convertToDTO(Medicamento medicamento) {
        return new MedicamentoResponseDTO(
                medicamento.getId(),
                medicamento.getNome(),
                medicamento.getFabricante(),
                medicamento.getPreco(),
                medicamento.getQuantidadeEstoque(),
                medicamento.getCategoria(),
                medicamento.getDescricao(),
                medicamento.isPrescricaoObrigatoria(),
                medicamento.getDataValidade(),
                medicamento.getDataCadastro()
        );
    }

    private Medicamento convertToEntity(MedicamentoRequestDTO dto) {
        Medicamento medicamento = new Medicamento();
        medicamento.setNome(dto.getNome());
        medicamento.setFabricante(dto.getFabricante());
        medicamento.setPreco(dto.getPreco());
        medicamento.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        medicamento.setCategoria(dto.getCategoria());
        medicamento.setDescricao(dto.getDescricao());
        medicamento.setPrescricaoObrigatoria(dto.isPrescricaoObrigatoria());
        medicamento.setDataValidade(dto.getDataValidade());
        return medicamento;
    }

    @Transactional(readOnly = true)
    public List<MedicamentoResponseDTO> findAll() {
        return medicamentoRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MedicamentoResponseDTO findById(Long id) {
        Medicamento medicamento = medicamentoRepository.findById(id)
                .orElseThrow(() -> new MedicamentoNotFoundException(id));
        return convertToDTO(medicamento);
    }

    @Transactional
    public MedicamentoResponseDTO create(MedicamentoRequestDTO dto) {
        Medicamento medicamento = convertToEntity(dto);
        Medicamento savedMedicamento = medicamentoRepository.save(medicamento);
        return convertToDTO(savedMedicamento);
    }

    @Transactional
    public MedicamentoResponseDTO update(Long id, MedicamentoRequestDTO dto) {
        Medicamento medicamento = medicamentoRepository.findById(id)
                .orElseThrow(() -> new MedicamentoNotFoundException(id));

        medicamento.setNome(dto.getNome());
        medicamento.setFabricante(dto.getFabricante());
        medicamento.setPreco(dto.getPreco());
        medicamento.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        medicamento.setCategoria(dto.getCategoria());
        medicamento.setDescricao(dto.getDescricao());
        medicamento.setPrescricaoObrigatoria(dto.isPrescricaoObrigatoria());
        medicamento.setDataValidade(dto.getDataValidade());

        Medicamento updatedMedicamento = medicamentoRepository.save(medicamento);
        return convertToDTO(updatedMedicamento);
    }

    @Transactional
    public void delete(Long id) {
        if (!medicamentoRepository.existsById(id)) {
            throw new MedicamentoNotFoundException(id);
        }
        medicamentoRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<MedicamentoResponseDTO> findByFabricante(String fabricante) {
        return medicamentoRepository.findByFabricante(fabricante)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MedicamentoResponseDTO> findByCategoria(String categoria) {
        return medicamentoRepository.findByCategoria(categoria)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MedicamentoResponseDTO> findDisponiveis() {
        return medicamentoRepository.findDisponiveis()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MedicamentoResponseDTO> searchByNome(String nome) {
        return medicamentoRepository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public MedicamentoResponseDTO atualizarEstoque(Long id, Integer quantidade) {
        Medicamento medicamento = medicamentoRepository.findById(id)
                .orElseThrow(() -> new MedicamentoNotFoundException(id));

        if (medicamento.getQuantidadeEstoque() + quantidade < 0) {
            throw new IllegalArgumentException("Quantidade em estoque não pode ser negativa");
        }

        medicamento.setQuantidadeEstoque(medicamento.getQuantidadeEstoque() + quantidade);
        Medicamento updatedMedicamento = medicamentoRepository.save(medicamento);
        return convertToDTO(updatedMedicamento);
    }
}