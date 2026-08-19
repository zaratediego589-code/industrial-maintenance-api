package com.diego.maintenance.mapper;

import com.diego.maintenance.dto.TecnicoRequestDTO;
import com.diego.maintenance.dto.TecnicoResponseDTO;
import com.diego.maintenance.model.Tecnico;
import org.springframework.stereotype.Component;

@Component
public class TecnicoMapper {

    public Tecnico toEntity(TecnicoRequestDTO dto) {

        Tecnico tecnico = new Tecnico();

        tecnico.setNombre(dto.getNombre());
        tecnico.setEspecialidad(dto.getEspecialidad());
        tecnico.setEmail(dto.getEmail());

        if (dto.getActivo() == null) {
            tecnico.setActivo(true);
        } else {
            tecnico.setActivo(dto.getActivo());
        }

        return tecnico;
    }

    public TecnicoResponseDTO toResponseDTO(Tecnico tecnico) {

        return new TecnicoResponseDTO(
                tecnico.getId(),
                tecnico.getNombre(),
                tecnico.getEspecialidad(),
                tecnico.getEmail(),
                tecnico.getActivo()
        );
    }

    public void actualizarEntidad(
            Tecnico tecnico,
            TecnicoRequestDTO dto) {

        tecnico.setNombre(dto.getNombre());
        tecnico.setEspecialidad(dto.getEspecialidad());
        tecnico.setEmail(dto.getEmail());

        if (dto.getActivo() != null) {
            tecnico.setActivo(dto.getActivo());
        }
    }
}
