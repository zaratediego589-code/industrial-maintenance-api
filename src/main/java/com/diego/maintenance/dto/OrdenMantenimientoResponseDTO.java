package com.diego.maintenance.dto;

import com.diego.maintenance.enums.EstadoOrden;

import java.time.LocalDate;

public class OrdenMantenimientoResponseDTO {

    private Long id;
    private String descripcion;
    private LocalDate fecha;
    private EstadoOrden estado;

    private Long maquinaId;
    private String maquinaNombre;

    private Long tecnicoId;
    private String tecnicoNombre;

    public OrdenMantenimientoResponseDTO(
            Long id,
            String descripcion,
            LocalDate fecha,
            EstadoOrden estado,
            Long maquinaId,
            String maquinaNombre,
            Long tecnicoId,
            String tecnicoNombre) {

        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
        this.maquinaId = maquinaId;
        this.maquinaNombre = maquinaNombre;
        this.tecnicoId = tecnicoId;
        this.tecnicoNombre = tecnicoNombre;
    }

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public Long getMaquinaId() {
        return maquinaId;
    }

    public String getMaquinaNombre() {
        return maquinaNombre;
    }

    public Long getTecnicoId() {
        return tecnicoId;
    }

    public String getTecnicoNombre() {
        return tecnicoNombre;
    }
}
