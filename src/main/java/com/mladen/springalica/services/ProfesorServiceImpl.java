package com.mladen.springalica.services;

import com.mladen.springalica.entities.Profesor;
import com.mladen.springalica.repository.ProfesorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService{

    private final ProfesorRepository profesorRepository;

    public ProfesorServiceImpl(ProfesorRepository profesorRepository) {
        super();
        this.profesorRepository = profesorRepository;
    }

    @Override
    public List<Profesor> dajSveProfesore() { return profesorRepository.findAll();}

    @Override
    public Profesor dajProfesoraZaID(long id) {return profesorRepository.getOne(id);}

    @Override
    public Profesor dajProfesoraZaKorisnickoIme(String username) {
        return profesorRepository.findProfesorByKorisnickoImeEquals(username);
    }

    @Override
    public List<Profesor> dajProfesorePoImenu(String name) {return profesorRepository.findProfesorByImeContaining(name);}

    @Override
    public Profesor dajProfesoraPoImenu(String name) {return profesorRepository.findProfesorByImeEquals(name);}

    @Override
    public Profesor saveProfesor(Profesor newProfesor) {return profesorRepository.save(newProfesor);}

    @Override
    public void delete(Long id) {profesorRepository.deleteById(id);}
}
