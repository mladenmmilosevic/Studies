package com.mladen.springalica.repository;

import com.mladen.springalica.entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    List<Profesor> findProfesorByImeContaining(String name);
    Profesor findProfesorByImeEquals(String name);
    Profesor findProfesorByKorisnickoImeEquals(String name);
}
