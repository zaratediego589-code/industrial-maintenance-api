package com.diego.maintenance.mapper;

import com.diego.maintenance.dto.OrdenMantenimientoResponseDTO;
import com.diego.maintenance.model.OrdenMantenimiento;
import org.springframework.stereotype.Component;

@Component
public class OrdenMantenimientoMapper {

    public OrdenMantenimientoResponseDTO toResponseDTO(
            OrdenMantenimiento orden) {

        return new OrdenMantenimientoResponseDTO(
                orden.getId(),
                orden.getDescripcion(),
                orden.getFecha(),
                orden.getEstado(),
                orden.getMaquina().getId(),
                orden.getMaquina().getNombre(),
                orden.getTecnico().getId(),
                orden.getTecnico().getNombre()
        );
    }
}
