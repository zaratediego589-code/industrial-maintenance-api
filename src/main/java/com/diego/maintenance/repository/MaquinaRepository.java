package com.diego.maintenance.repository;

import com.diego.maintenance.enums.EstadoMaquina;
import com.diego.maintenance.model.Maquina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaquinaRepository
        extends JpaRepository<Maquina, Long> {

    List<Maquina> findByEstado(EstadoMaquina estado);
}