package com.farmacia.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MedicamentoNotFoundException extends RuntimeException {

    public MedicamentoNotFoundException(Long id) {
        super("Medicamento não encontrado com ID: " + id);
    }

    public MedicamentoNotFoundException(String message) {
        super(message);
    }
}