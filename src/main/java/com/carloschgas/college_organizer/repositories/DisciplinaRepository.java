package com.carloschgas.college_organizer.repositories;

import com.carloschgas.college_organizer.domain.disciplina.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, String> {
}
