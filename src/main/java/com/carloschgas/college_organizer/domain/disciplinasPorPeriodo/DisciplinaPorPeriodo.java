package com.carloschgas.college_organizer.domain.disciplinasPorPeriodo;


import com.carloschgas.college_organizer.domain.disciplina.Disciplina;
import com.carloschgas.college_organizer.domain.periodoGraduacao.PeriodoGraduacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "disciplinasPorPeriodo")
public class DisciplinaPorPeriodo {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_disciplina")
    private Disciplina id_disciplina;

    @ManyToOne
    @JoinColumn(name = "nome_periodo")
    private PeriodoGraduacao nome_periodo;
}
