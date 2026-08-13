package com.diego.maintenance.repository;

import com.diego.maintenance.model.Maquina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaquinaRepository extends JpaRepository<Maquina, Long> {
}
