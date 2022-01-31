package com.mladen.springalica.services;


import com.mladen.springalica.entities.Predmet;
import com.mladen.springalica.entities.Student;

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
