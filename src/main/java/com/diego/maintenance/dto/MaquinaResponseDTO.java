package com.diego.maintenance.dto;

public class MaquinaResponseDTO {

    private Long id;
    private String nombre;
    private String tipo;
    private String estado;

    public MaquinaResponseDTO(
            Long id,
            String nombre,
            String tipo,
            String estado) {

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

    public String getEstado() {
        return estado;
    }
}