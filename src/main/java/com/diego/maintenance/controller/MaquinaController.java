package com.diego.maintenance.controller;

import com.diego.maintenance.model.Maquina;
import com.diego.maintenance.service.MaquinaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/maquinas")
public class MaquinaController {

    private final MaquinaService maquinaService;

    public MaquinaController(MaquinaService maquinaService) {
        this.maquinaService = maquinaService;
    }

    @GetMapping
    public List<Maquina> obtenerTodas() {
        return maquinaService.obtenerTodas();
    }

    @PostMapping
    public ResponseEntity<Maquina> crear(
            @Valid @RequestBody Maquina maquina) {

        Maquina nuevaMaquina = maquinaService.guardar(maquina);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevaMaquina);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maquina> obtenerPorId(@PathVariable Long id) {

        Maquina maquina = maquinaService.obtenerPorId(id);

        return ResponseEntity.ok(maquina);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        maquinaService.eliminar(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maquina> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Maquina maquina) {

        Maquina actualizada = maquinaService.actualizar(id, maquina);

        return ResponseEntity.ok(actualizada);
    }
}
