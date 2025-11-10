package com.carloschgas.college_organizer.service;

import com.carloschgas.college_organizer.domain.disciplina.Disciplina;
import com.carloschgas.college_organizer.repositories.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {


    private final DisciplinaRepository repository;

    public DisciplinaService(DisciplinaRepository repository){
        this.repository = repository;
    }

    public List<Disciplina> findAll(){
        return repository.findAll();
    }
}
