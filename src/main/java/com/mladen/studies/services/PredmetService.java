package com.mladen.studies.services;


import com.mladen.studies.entities.Predmet;
import com.mladen.studies.entities.Student;

import java.util.List;

public interface PredmetService {
    public List<Predmet> dajSvePredmete();

    public Predmet dajPredmetZaID(long id);

    public List<Predmet> dajPredmetePoImenu(String name);

    public Predmet dajPredmetPoImenu(String name);

    Predmet savePredmet(Predmet newPredmet);

    List<Student> getStudentsByCLass(Long id);

    void delete(Long id);
}
