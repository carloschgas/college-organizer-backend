package com.carloschgas.college_organizer.repositories;

import com.carloschgas.college_organizer.domain.disciplinasPorPeriodo.DisciplinaPorPeriodo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface disciplinaPorPeriodoRepository extends JpaRepository<DisciplinaPorPeriodo, UUID> {
}
