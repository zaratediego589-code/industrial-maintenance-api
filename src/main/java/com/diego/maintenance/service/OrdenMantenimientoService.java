package com.diego.maintenance.service;

import com.diego.maintenance.dto.OrdenMantenimientoRequestDTO;
import com.diego.maintenance.dto.OrdenMantenimientoResponseDTO;
import com.diego.maintenance.exception.ResourceNotFoundException;
import com.diego.maintenance.mapper.OrdenMantenimientoMapper;
import com.diego.maintenance.model.Maquina;
import com.diego.maintenance.model.OrdenMantenimiento;
import com.diego.maintenance.model.Tecnico;
import com.diego.maintenance.repository.MaquinaRepository;
import com.diego.maintenance.repository.OrdenMantenimientoRepository;
import com.diego.maintenance.repository.TecnicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenMantenimientoService {

    private final OrdenMantenimientoRepository ordenRepository;
    private final MaquinaRepository maquinaRepository;
    private final TecnicoRepository tecnicoRepository;
    private final OrdenMantenimientoMapper ordenMapper;

    public OrdenMantenimientoService(
            OrdenMantenimientoRepository ordenRepository,
            MaquinaRepository maquinaRepository,
            TecnicoRepository tecnicoRepository,
            OrdenMantenimientoMapper ordenMapper) {

        this.ordenRepository = ordenRepository;
        this.maquinaRepository = maquinaRepository;
        this.tecnicoRepository = tecnicoRepository;
        this.ordenMapper = ordenMapper;
    }

    public List<OrdenMantenimientoResponseDTO> obtenerTodas() {

        return ordenRepository.findAll()
                .stream()
                .map(ordenMapper::toResponseDTO)
                .toList();
    }

    public OrdenMantenimientoResponseDTO obtenerPorId(Long id) {

        OrdenMantenimiento orden = ordenRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Orden de mantenimiento no encontrada con id: " + id
                        )
                );

        return ordenMapper.toResponseDTO(orden);
    }

    public OrdenMantenimientoResponseDTO guardar(
            OrdenMantenimientoRequestDTO dto) {

        Maquina maquina = maquinaRepository.findById(dto.getMaquinaId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Máquina no encontrada con id: " + dto.getMaquinaId()
                        )
                );

        Tecnico tecnico = tecnicoRepository.findById(dto.getTecnicoId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Técnico no encontrado con id: " + dto.getTecnicoId()
                        )
                );

        OrdenMantenimiento orden = new OrdenMantenimiento();

        orden.setDescripcion(dto.getDescripcion());
        orden.setFecha(dto.getFecha());
        orden.setEstado(dto.getEstado());
        orden.setMaquina(maquina);
        orden.setTecnico(tecnico);

        OrdenMantenimiento guardada =
                ordenRepository.save(orden);

        return ordenMapper.toResponseDTO(guardada);
    }

    public OrdenMantenimientoResponseDTO actualizar(
            Long id,
            OrdenMantenimientoRequestDTO dto) {

        OrdenMantenimiento orden = ordenRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Orden de mantenimiento no encontrada con id: " + id
                        )
                );

        Maquina maquina = maquinaRepository.findById(dto.getMaquinaId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Máquina no encontrada con id: " + dto.getMaquinaId()
                        )
                );

        Tecnico tecnico = tecnicoRepository.findById(dto.getTecnicoId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Técnico no encontrado con id: " + dto.getTecnicoId()
                        )
                );

        orden.setDescripcion(dto.getDescripcion());
        orden.setFecha(dto.getFecha());
        orden.setEstado(dto.getEstado());
        orden.setMaquina(maquina);
        orden.setTecnico(tecnico);

        OrdenMantenimiento actualizada =
                ordenRepository.save(orden);

        return ordenMapper.toResponseDTO(actualizada);
    }

    public void eliminar(Long id) {

        OrdenMantenimiento orden = ordenRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Orden de mantenimiento no encontrada con id: " + id
                        )
                );

        ordenRepository.delete(orden);
    }
}
