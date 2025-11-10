package com.carloschgas.college_organizer.controller;

import com.carloschgas.college_organizer.domain.disciplina.DisciplinaResponseDTO;
import com.carloschgas.college_organizer.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/disciplinas")


public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;


    @GetMapping
    public ResponseEntity<List<DisciplinaResponseDTO>> getDisciplinas(){

        //service.findAll() retorna List<Disciplinas>
        //cria uma lista de responsesDTOS
        List<DisciplinaResponseDTO> disciplinaResponseDTOS = disciplinaService.findAll()
                //transforma em streamapi pra poder iterar
                .stream()
                //pra disciplina, faz uma iteracao pra gerar um novo objeto de responseDTO
                .map(d -> new DisciplinaResponseDTO(
                        d.getId_disciplina(),
                        d.getNome(),
                        d.getSemestre(),
                        d.getCreditos(),
                        d.getRequisitos()))
                .toList();

        return ResponseEntity.ok(disciplinaResponseDTOS);

    }


}
