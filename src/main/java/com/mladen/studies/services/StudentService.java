package com.mladen.studies.services;

import java.util.List;

import com.mladen.studies.entities.Student;


public interface StudentService {

    public List<Student> dajSveStudente();

    public Student dajStudentaZaID(long id);

    public List<Student> dajStudentePoImenu(String name);

    public Student dajStudentaPoImenu(String name);

    public Student dajStudentaPoKorisnickomImenu(String name);

    Student saveStudent(Student newStudent);

    void delete(Long id);
}
