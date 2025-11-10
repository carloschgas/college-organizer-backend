package com.carloschgas.college_organizer.domain.disciplinasPorPeriodo;

import com.carloschgas.college_organizer.domain.disciplina.DisciplinaResponseDTO;
import com.carloschgas.college_organizer.domain.periodoGraduacao.PeriodoGraduacaoResponseDTO;

import java.util.UUID;

public record DisciplinaPorPeriodoResponseDTO (UUID id, DisciplinaResponseDTO disciplinaDTO, PeriodoGraduacaoResponseDTO periodoDTO){
}
