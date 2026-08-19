package com.diego.maintenance.controller;

import com.diego.maintenance.dto.TecnicoRequestDTO;
import com.diego.maintenance.dto.TecnicoResponseDTO;
import com.diego.maintenance.service.TecnicoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tecnicos")
public class TecnicoController {

    private final TecnicoService tecnicoService;

    public TecnicoController(TecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }

    @GetMapping
    public List<TecnicoResponseDTO> obtenerTodos() {
        return tecnicoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TecnicoResponseDTO> obtenerPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                tecnicoService.obtenerPorId(id)
        );
    }

    @PostMapping
    public ResponseEntity<TecnicoResponseDTO> crear(
            @Valid @RequestBody TecnicoRequestDTO dto) {

        TecnicoResponseDTO nuevoTecnico =
                tecnicoService.guardar(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevoTecnico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TecnicoResponseDTO> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody TecnicoRequestDTO dto) {

        return ResponseEntity.ok(
                tecnicoService.actualizar(id, dto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id) {

        tecnicoService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}
