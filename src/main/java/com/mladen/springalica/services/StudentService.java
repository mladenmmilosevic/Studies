package com.mladen.springalica.services;

import java.util.List;
import com.mladen.springalica.entities.Student;


public interface StudentService {

	public List<Student> dajSveStudente();

	public Student dajStudentaZaID(long id);

	public List<Student> dajStudentePoImenu(String name);

	public Student dajStudentaPoImenu(String name);

	public Student dajStudentaPoKorisnickomImenu(String name);

	Student saveStudent(Student newStudent);

	void delete(Long id);
}
