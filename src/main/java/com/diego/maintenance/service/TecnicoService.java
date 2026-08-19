package com.diego.maintenance.service;

import com.diego.maintenance.dto.TecnicoRequestDTO;
import com.diego.maintenance.dto.TecnicoResponseDTO;
import com.diego.maintenance.exception.ResourceNotFoundException;
import com.diego.maintenance.mapper.TecnicoMapper;
import com.diego.maintenance.model.Tecnico;
import com.diego.maintenance.repository.TecnicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnicoService {

    private final TecnicoRepository tecnicoRepository;
    private final TecnicoMapper tecnicoMapper;

    public TecnicoService(
            TecnicoRepository tecnicoRepository,
            TecnicoMapper tecnicoMapper) {

        this.tecnicoRepository = tecnicoRepository;
        this.tecnicoMapper = tecnicoMapper;
    }

    public List<TecnicoResponseDTO> obtenerTodos() {

        return tecnicoRepository.findAll()
                .stream()
                .map(tecnicoMapper::toResponseDTO)
                .toList();
    }

    public TecnicoResponseDTO obtenerPorId(Long id) {

        Tecnico tecnico = tecnicoRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Técnico no encontrado con id: " + id
                        )
                );

        return tecnicoMapper.toResponseDTO(tecnico);
    }

    public TecnicoResponseDTO guardar(TecnicoRequestDTO dto) {

        Tecnico tecnico = tecnicoMapper.toEntity(dto);

        Tecnico guardado = tecnicoRepository.save(tecnico);

        return tecnicoMapper.toResponseDTO(guardado);
    }

    public TecnicoResponseDTO actualizar(
            Long id,
            TecnicoRequestDTO dto) {

        Tecnico tecnico = tecnicoRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Técnico no encontrado con id: " + id
                        )
                );

        tecnicoMapper.actualizarEntidad(tecnico, dto);

        Tecnico actualizado = tecnicoRepository.save(tecnico);

        return tecnicoMapper.toResponseDTO(actualizado);
    }

    public void eliminar(Long id) {

        Tecnico tecnico = tecnicoRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Técnico no encontrado con id: " + id
                        )
                );

        tecnicoRepository.delete(tecnico);
    }
}
