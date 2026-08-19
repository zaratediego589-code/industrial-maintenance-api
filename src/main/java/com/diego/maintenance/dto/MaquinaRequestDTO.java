package com.diego.maintenance.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import com.diego.maintenance.enums.EstadoMaquina;
import jakarta.validation.constraints.NotNull;

public class MaquinaRequestDTO {

    @NotBlank(message = "El nombre de la máquina es obligatorio")
    @Size(min = 3, max = 100,
            message = "El nombre debe tener entre 3 y 100 caracteres")
    private String nombre;

    @NotBlank(message = "El tipo de máquina es obligatorio")
    private String tipo;

    @NotNull(message = "El estado de la máquina es obligatorio")
    private EstadoMaquina estado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public EstadoMaquina getEstado() {
        return estado;
    }

    public void setEstado(EstadoMaquina estado) {
        this.estado = estado;
    }
}
