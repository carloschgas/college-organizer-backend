package com.carloschgas.college_organizer.controller;


import com.carloschgas.college_organizer.domain.periodoGraduacao.PeriodoGraduacao;
import com.carloschgas.college_organizer.domain.periodoGraduacao.PeriodoGraduacaoRequestDTO;
import com.carloschgas.college_organizer.domain.periodoGraduacao.PeriodoGraduacaoResponseDTO;
import com.carloschgas.college_organizer.service.PeriodoGraduacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/periodos")
public class PeriodoGraduacaoController {

    @Autowired
    private  PeriodoGraduacaoService service;

    @PostMapping
    public ResponseEntity<PeriodoGraduacaoResponseDTO> createPeriodo(@RequestParam("nome_periodo") String nome_periodo){

        PeriodoGraduacaoRequestDTO requestDTO = new PeriodoGraduacaoRequestDTO(nome_periodo);
        PeriodoGraduacao newPeriodoGraduacao = service.createPeriodo(requestDTO);
        PeriodoGraduacaoResponseDTO responseDTO = new PeriodoGraduacaoResponseDTO(newPeriodoGraduacao.getNome_periodo());

        return ResponseEntity.created(URI.create("api/periodos/" + newPeriodoGraduacao.getNome_periodo())).body(responseDTO);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletePeriodo(@RequestParam("nome_periodo") String nome_periodo){
        boolean periodoDeleted = service.deletePeriodo(nome_periodo);

        if(periodoDeleted){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PeriodoGraduacaoResponseDTO>> findAll(){

        List<PeriodoGraduacaoResponseDTO> responseDTO = service.findAll()
                .stream()
                .map(p -> new PeriodoGraduacaoResponseDTO(
                        p.getNome_periodo()
                )).toList();
        return ResponseEntity.ok(responseDTO);

    }
}
