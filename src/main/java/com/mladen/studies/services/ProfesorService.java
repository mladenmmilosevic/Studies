package com.mladen.studies.services;

import com.mladen.studies.entities.Profesor;

import java.util.List;

public interface ProfesorService {

    public List<Profesor> dajSveProfesore();

    public Profesor dajProfesoraZaID(long id);

    public Profesor dajProfesoraZaKorisnickoIme(String username);

    public List<Profesor> dajProfesorePoImenu(String name);

    public Profesor dajProfesoraPoImenu(String name);

    Profesor saveProfesor(Profesor newProfesor);

    void delete(Long id);
}
