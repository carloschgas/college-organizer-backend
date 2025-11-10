package com.carloschgas.college_organizer.controller;

import com.carloschgas.college_organizer.domain.disciplina.DisciplinaResponseDTO;
import com.carloschgas.college_organizer.domain.disciplinasPorPeriodo.DisciplinaPorPeriodo;
import com.carloschgas.college_organizer.domain.disciplinasPorPeriodo.DisciplinaPorPeriodoRequestDTO;
import com.carloschgas.college_organizer.domain.disciplinasPorPeriodo.DisciplinaPorPeriodoResponseDTO;
import com.carloschgas.college_organizer.domain.periodoGraduacao.PeriodoGraduacaoResponseDTO;
import com.carloschgas.college_organizer.service.DisciplinaPorPeriodoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/disciplinaperiodo")
public class DisciplinaPorPeriodoController {

    @Autowired
    private DisciplinaPorPeriodoService service;

    @GetMapping
    public ResponseEntity<List<DisciplinaPorPeriodoResponseDTO>> findAll(){

        List<DisciplinaPorPeriodoResponseDTO> responseDTOS = service.findAll()
                .stream()
                .map(d-> new DisciplinaPorPeriodoResponseDTO(
                        d.getId(),
                        new DisciplinaResponseDTO(
                                d.getDisciplina().getId_disciplina(),
                                d.getDisciplina().getNome(),
                                d.getDisciplina().getSemestre(),
                                d.getDisciplina().getCreditos(),
                                d.getDisciplina().getRequisitos()

                        ),
                        new PeriodoGraduacaoResponseDTO(
                                d.getPeriodo().getNome_periodo()
                        )
                )).toList();

        return ResponseEntity.ok(responseDTOS);
    }

    @PostMapping
    public ResponseEntity<DisciplinaPorPeriodoResponseDTO> create(@RequestBody DisciplinaPorPeriodoRequestDTO requestDTO){

        DisciplinaPorPeriodo newEntry = service.create(requestDTO);

        DisciplinaPorPeriodoResponseDTO responseDTO = new DisciplinaPorPeriodoResponseDTO(
                newEntry.getId(),
                new DisciplinaResponseDTO(
                        newEntry.getDisciplina().getId_disciplina(),
                        newEntry.getDisciplina().getNome(),
                        newEntry.getDisciplina().getSemestre(),
                        newEntry.getDisciplina().getCreditos(),
                        newEntry.getDisciplina().getRequisitos()
                ),
                new PeriodoGraduacaoResponseDTO(
                        newEntry.getPeriodo().getNome_periodo()
                )
        );

        return ResponseEntity.created(URI.create("/api/disciplinaperiodo/" + newEntry.getId()))
                .body(responseDTO);
    }


}
