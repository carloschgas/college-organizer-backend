package com.carloschgas.college_organizer.service;

import com.carloschgas.college_organizer.domain.disciplina.Disciplina;
import com.carloschgas.college_organizer.domain.disciplinasPorPeriodo.DisciplinaPorPeriodo;
import com.carloschgas.college_organizer.domain.disciplinasPorPeriodo.DisciplinaPorPeriodoRequestDTO;
import com.carloschgas.college_organizer.domain.periodoGraduacao.PeriodoGraduacao;
import com.carloschgas.college_organizer.repositories.DisciplinaRepository;
import com.carloschgas.college_organizer.repositories.disciplinaPorPeriodoRepository;
import com.carloschgas.college_organizer.repositories.periodoGraduacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DisciplinaPorPeriodoService {

    private final disciplinaPorPeriodoRepository repository;
    private final DisciplinaRepository disciplinaRepository;
    private final periodoGraduacaoRepository periodoRepository;

    public DisciplinaPorPeriodoService(
            disciplinaPorPeriodoRepository repository,
            DisciplinaRepository disciplinaRepository,
            periodoGraduacaoRepository periodoRepository)

    {
        this.repository = repository;
        this.disciplinaRepository = disciplinaRepository;
        this.periodoRepository = periodoRepository;

    }

    public DisciplinaPorPeriodo create(DisciplinaPorPeriodoRequestDTO dto){

        Disciplina disciplina = disciplinaRepository.findById(dto.id_disciplina())
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

        PeriodoGraduacao periodo = periodoRepository.findById(dto.nome_periodo())
                .orElseThrow(() -> new RuntimeException("Período não encontrado"));


        DisciplinaPorPeriodo newEntry = new DisciplinaPorPeriodo(null, disciplina, periodo);

        return repository.save(newEntry);
    }

    public List<DisciplinaPorPeriodo> findAll(){
        return repository.findAll();
    }

    public boolean delete(UUID id){
        if(repository.existsById(id)){

            repository.deleteById(id);
            return true;
        }

        return false;
    }


}
