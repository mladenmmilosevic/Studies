package com.mladen.springalica.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.mladen.springalica.entities.Student;
import com.mladen.springalica.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> dajSveStudente() {
		return studentRepository.findAll();
	}

	@Override
	public Student dajStudentaZaID(long id) {
		return studentRepository.getById(id);
	}

	@Override
	public List<Student> dajStudentePoImenu(String name) {
		return studentRepository.findStudentByImeContaining(name);
	}

	@Override
	public Student dajStudentaPoImenu(String name) {
		return studentRepository.findStudentByImeEquals(name);
	}

	@Override
	public Student dajStudentaPoKorisnickomImenu(String name) {
		return studentRepository.findStudentByKorisnickoImeEquals(name);
	}

	@Override
	public Student saveStudent(Student newStudent) { return studentRepository.save(newStudent);}

	@Override
	public void delete(Long id) {
		studentRepository.deleteById(id);
	}

}
