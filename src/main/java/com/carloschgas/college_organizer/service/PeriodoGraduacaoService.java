package com.carloschgas.college_organizer.service;



import com.carloschgas.college_organizer.domain.periodoGraduacao.PeriodoGraduacao;
import com.carloschgas.college_organizer.domain.periodoGraduacao.PeriodoGraduacaoRequestDTO;
import com.carloschgas.college_organizer.repositories.periodoGraduacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodoGraduacaoService {
    private final periodoGraduacaoRepository repository;

    public PeriodoGraduacaoService(periodoGraduacaoRepository repository){
        this.repository = repository;
    }

    public List<PeriodoGraduacao> findAll(){
        return repository.findAll();
    }

    public PeriodoGraduacao createPeriodo(PeriodoGraduacaoRequestDTO dto){
        PeriodoGraduacao newPeriodo = new PeriodoGraduacao(dto.nome_periodo());
        return repository.save(newPeriodo);
    }

    public Boolean deletePeriodo(String nome_periodo){
        if(repository.existsById(nome_periodo)){
            repository.deleteById(nome_periodo);
            return true;
        }
        return false;
    }

}
