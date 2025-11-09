package com.carloschgas.college_organizer.domain.periodoGraduacao;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "periodoGraduacao")
public class PeriodoGraduacao {
    @Id
    private String nome_periodo;
}
