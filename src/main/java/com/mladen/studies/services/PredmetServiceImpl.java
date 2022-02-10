package com.mladen.studies.services;

import com.mladen.studies.entities.Predmet;
import com.mladen.studies.entities.Student;
import com.mladen.studies.repository.PredmetRepository;
import com.mladen.studies.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredmetServiceImpl implements PredmetService {

    private final PredmetRepository predmetRepository;
    private final StudentRepository studentRepository;

    public PredmetServiceImpl(PredmetRepository predmetRepository, StudentRepository studentRepository) {
        this.predmetRepository = predmetRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Predmet> dajSvePredmete() {
        return predmetRepository.findAll();
    }

    @Override
    public Predmet dajPredmetZaID(long id) {
        return predmetRepository.getOne(id);
    }

    @Override
    public List<Predmet> dajPredmetePoImenu(String name) {
        return predmetRepository.findPredmetByNazivContaining(name);
    }

    @Override
    public Predmet dajPredmetPoImenu(String name) {
        return predmetRepository.findPredmetByNazivEquals(name);
    }

    @Override
    public Predmet savePredmet(Predmet newPredmet) {
        predmetRepository.save(newPredmet);
        return newPredmet;
    }

    @Override
    public List<Student> getStudentsByCLass(Long id) {
        return studentRepository.findStudentByPredmetiPredmetid(id);
    }

    @Override
    public void delete(Long id) {
        predmetRepository.deleteById(id);
    }
}
