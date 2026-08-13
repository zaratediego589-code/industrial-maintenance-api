package com.diego.maintenance.mapper;

import com.diego.maintenance.dto.MaquinaRequestDTO;
import com.diego.maintenance.dto.MaquinaResponseDTO;
import com.diego.maintenance.model.Maquina;
import org.springframework.stereotype.Component;

@Component
public class MaquinaMapper {

    public Maquina toEntity(MaquinaRequestDTO dto) {

        Maquina maquina = new Maquina();

        maquina.setNombre(dto.getNombre());
        maquina.setTipo(dto.getTipo());
        maquina.setEstado(dto.getEstado());

        return maquina;
    }

    public MaquinaResponseDTO toResponseDTO(Maquina maquina) {

        return new MaquinaResponseDTO(
                maquina.getId(),
                maquina.getNombre(),
                maquina.getTipo(),
                maquina.getEstado()
        );
    }

    public void actualizarEntidad(
            Maquina maquina,
            MaquinaRequestDTO dto) {

        maquina.setNombre(dto.getNombre());
        maquina.setTipo(dto.getTipo());
        maquina.setEstado(dto.getEstado());
    }
}
