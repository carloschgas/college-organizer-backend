package com.carloschgas.college_organizer.repositories;

import com.carloschgas.college_organizer.domain.periodoGraduacao.PeriodoGraduacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface periodoGraduacaoRepository extends JpaRepository<PeriodoGraduacao, String> {
}
