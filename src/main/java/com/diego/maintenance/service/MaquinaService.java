package com.diego.maintenance.service;

import com.diego.maintenance.model.Maquina;
import com.diego.maintenance.repository.MaquinaRepository;
import org.springframework.stereotype.Service;
import com.diego.maintenance.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class MaquinaService {

    private final MaquinaRepository maquinaRepository;

    public MaquinaService(MaquinaRepository maquinaRepository) {
        this.maquinaRepository = maquinaRepository;
    }

    public List<Maquina> obtenerTodas() {
        return maquinaRepository.findAll();
    }

    public Maquina guardar(Maquina maquina) {
        return maquinaRepository.save(maquina);
    }

    public Maquina obtenerPorId(Long id) {

        return maquinaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Máquina no encontrada con id: " + id
                        )
                );
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

    public Maquina actualizar(Long id, Maquina datosActualizados) {

        Maquina maquinaExistente = maquinaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Máquina no encontrada con id: " + id
                        )
                );

        maquinaExistente.setNombre(datosActualizados.getNombre());
        maquinaExistente.setTipo(datosActualizados.getTipo());
        maquinaExistente.setEstado(datosActualizados.getEstado());

        return maquinaRepository.save(maquinaExistente);
    }
}