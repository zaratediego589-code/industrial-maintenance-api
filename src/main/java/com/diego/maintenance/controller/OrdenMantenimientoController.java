package com.diego.maintenance.controller;

import com.diego.maintenance.dto.OrdenMantenimientoRequestDTO;
import com.diego.maintenance.dto.OrdenMantenimientoResponseDTO;
import com.diego.maintenance.service.OrdenMantenimientoService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.diego.maintenance.enums.EstadoOrden;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenMantenimientoController {

    private final OrdenMantenimientoService ordenService;

    public OrdenMantenimientoController(
            OrdenMantenimientoService ordenService) {

        this.ordenService = ordenService;
    }

    // GET - Obtener todas las órdenes
    @GetMapping
    public List<OrdenMantenimientoResponseDTO> obtenerTodas(
            @RequestParam(required = false) EstadoOrden estado,
            @RequestParam(required = false) Long tecnicoId,
            @RequestParam(required = false) Long maquinaId) {

        if (estado != null) {
            return ordenService.obtenerPorEstado(estado);
        }

        if (tecnicoId != null) {
            return ordenService.obtenerPorTecnico(tecnicoId);
        }

        if (maquinaId != null) {
            return ordenService.obtenerPorMaquina(maquinaId);
        }

        return ordenService.obtenerTodas();
    }

    // GET - Obtener una orden por ID
    @GetMapping("/{id}")
    public ResponseEntity<OrdenMantenimientoResponseDTO> obtenerPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                ordenService.obtenerPorId(id)
        );
    }

    // POST - Crear una orden
    @PostMapping
    public ResponseEntity<OrdenMantenimientoResponseDTO> crear(
            @Valid @RequestBody OrdenMantenimientoRequestDTO dto) {

        OrdenMantenimientoResponseDTO nuevaOrden =
                ordenService.guardar(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevaOrden);
    }

    // PUT - Actualizar una orden
    @PutMapping("/{id}")
    public ResponseEntity<OrdenMantenimientoResponseDTO> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody OrdenMantenimientoRequestDTO dto) {

        return ResponseEntity.ok(
                ordenService.actualizar(id, dto)
        );
    }

    // DELETE - Eliminar una orden
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id) {

        ordenService.eliminar(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/paginadas")
    public Page<OrdenMantenimientoResponseDTO> obtenerPaginadas(
            Pageable pageable) {

        return ordenService.obtenerPaginadas(pageable);
    }
}
