package com.diego.maintenance.repository;

import com.diego.maintenance.enums.EstadoOrden;
import com.diego.maintenance.model.OrdenMantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdenMantenimientoRepository
        extends JpaRepository<OrdenMantenimiento, Long> {

    List<OrdenMantenimiento> findByEstado(EstadoOrden estado);

    List<OrdenMantenimiento> findByTecnicoId(Long tecnicoId);

    List<OrdenMantenimiento> findByMaquinaId(Long maquinaId);
}
