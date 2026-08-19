package com.diego.maintenance.repository;

import com.diego.maintenance.model.OrdenMantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenMantenimientoRepository
        extends JpaRepository<OrdenMantenimiento, Long> {
}
