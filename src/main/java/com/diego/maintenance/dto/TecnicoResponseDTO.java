package com.diego.maintenance.dto;

public class TecnicoResponseDTO {

    private Long id;
    private String nombre;
    private String especialidad;
    private String email;
    private Boolean activo;

    public TecnicoResponseDTO(
            Long id,
            String nombre,
            String especialidad,
            String email,
            Boolean activo) {

        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.email = email;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getActivo() {
        return activo;
    }
}