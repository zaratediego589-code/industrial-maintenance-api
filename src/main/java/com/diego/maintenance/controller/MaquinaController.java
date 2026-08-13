package com.diego.maintenance.controller;

import com.diego.maintenance.dto.MaquinaRequestDTO;
import com.diego.maintenance.dto.MaquinaResponseDTO;
import com.diego.maintenance.service.MaquinaService;

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

import java.util.List;

@RestController
@RequestMapping("/api/maquinas")
public class MaquinaController {

    private final MaquinaService maquinaService;

    // Inyección de dependencia
    public MaquinaController(MaquinaService maquinaService) {
        this.maquinaService = maquinaService;
    }

    // GET - Obtener todas las máquinas
    // GET http://localhost:8080/api/maquinas
    @GetMapping
    public List<MaquinaResponseDTO> obtenerTodas() {
        return maquinaService.obtenerTodas();
    }

    // GET - Obtener una máquina por ID
    // GET http://localhost:8080/api/maquinas/1
    @GetMapping("/{id}")
    public ResponseEntity<MaquinaResponseDTO> obtenerPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                maquinaService.obtenerPorId(id)
        );
    }

    // POST - Crear una máquina
    // POST http://localhost:8080/api/maquinas
    @PostMapping
    public ResponseEntity<MaquinaResponseDTO> crear(
            @Valid @RequestBody MaquinaRequestDTO dto) {

        MaquinaResponseDTO nuevaMaquina =
                maquinaService.guardar(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevaMaquina);
    }

    // PUT - Actualizar una máquina
    // PUT http://localhost:8080/api/maquinas/1
    @PutMapping("/{id}")
    public ResponseEntity<MaquinaResponseDTO> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody MaquinaRequestDTO dto) {

        return ResponseEntity.ok(
                maquinaService.actualizar(id, dto)
        );
    }

    // DELETE - Eliminar una máquina
    // DELETE http://localhost:8080/api/maquinas/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id) {

        maquinaService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}
