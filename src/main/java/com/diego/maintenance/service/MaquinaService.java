package com.diego.maintenance.service;

import com.diego.maintenance.model.Maquina;
import com.diego.maintenance.repository.MaquinaRepository;
import org.springframework.stereotype.Service;
import com.diego.maintenance.exception.ResourceNotFoundException;
import com.diego.maintenance.dto.MaquinaRequestDTO;
import com.diego.maintenance.dto.MaquinaResponseDTO;
import com.diego.maintenance.mapper.MaquinaMapper;

import java.util.List;

@Service
public class MaquinaService {

    private final MaquinaRepository maquinaRepository;
    private final MaquinaMapper maquinaMapper;

    public MaquinaService(
            MaquinaRepository maquinaRepository,
            MaquinaMapper maquinaMapper) {

        this.maquinaRepository = maquinaRepository;
        this.maquinaMapper = maquinaMapper;
    }

    public List<MaquinaResponseDTO> obtenerTodas() {

        return maquinaRepository.findAll()
                .stream()
                .map(maquinaMapper::toResponseDTO)
                .toList();
    }

    public MaquinaResponseDTO guardar(
            MaquinaRequestDTO dto) {

        Maquina maquina = maquinaMapper.toEntity(dto);

        Maquina guardada = maquinaRepository.save(maquina);

        return maquinaMapper.toResponseDTO(guardada);
    }

    public MaquinaResponseDTO obtenerPorId(Long id) {

        Maquina maquina = maquinaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Máquina no encontrada con id: " + id
                        )
                );

        return maquinaMapper.toResponseDTO(maquina);
    }

    public void eliminar(Long id) {

        Maquina maquina = maquinaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Máquina no encontrada con id: " + id
                        )
                );

        maquinaRepository.delete(maquina);
    }

    public MaquinaResponseDTO actualizar(
            Long id,
            MaquinaRequestDTO dto) {

        Maquina maquina = maquinaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Máquina no encontrada con id: " + id
                        )
                );

        maquinaMapper.actualizarEntidad(maquina, dto);

        Maquina actualizada = maquinaRepository.save(maquina);

        return maquinaMapper.toResponseDTO(actualizada);
    }
}