package com.diego.maintenance.dto;

import com.diego.maintenance.enums.EstadoMaquina;

public class MaquinaResponseDTO {

    private Long id;
    private String nombre;
    private String tipo;
    private EstadoMaquina estado;

    public MaquinaResponseDTO(
            Long id,
            String nombre,
            String tipo,
            EstadoMaquina estado) {

        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public EstadoMaquina getEstado() {
        return estado;
    }
}