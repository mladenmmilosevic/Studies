package com.mladen.studies.repository;

import com.mladen.studies.entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

    List<Profesor> findProfesorByImeContaining(String name);

    Profesor findProfesorByImeEquals(String name);

    Profesor findProfesorByKorisnickoImeEquals(String name);
}
