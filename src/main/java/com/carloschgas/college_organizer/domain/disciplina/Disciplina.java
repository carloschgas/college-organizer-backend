package com.carloschgas.college_organizer.domain.disciplina;


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

@Table(name="disciplinas")
@Entity
public class Disciplina {
    @Id
    private String id_disciplina;

    private String nome;
    private int semestre;
    private int creditos;

    private String requisitos;
}
