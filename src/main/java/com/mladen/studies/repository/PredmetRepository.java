package com.mladen.studies.repository;

import com.mladen.studies.entities.Predmet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PredmetRepository extends JpaRepository<Predmet, Long> {
    List<Predmet> findPredmetByNazivContaining(String name);

    Predmet findPredmetByNazivEquals(String name);

}
