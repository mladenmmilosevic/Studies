package com.mladen.studies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mladen.studies.entities.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentByImeContaining(String name);

    Student findStudentByImeEquals(String name);

    Student findStudentByKorisnickoImeEquals(String name);

    List<Student> findStudentByPredmetiPredmetid(Long id);

    Student getById(long id);

}
