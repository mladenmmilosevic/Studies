package com.mladen.springalica.controller;

import java.util.List;

import com.mladen.springalica.dto.*;
import com.mladen.springalica.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mladen.springalica.entities.Student;
import com.mladen.springalica.services.StudentService;


@RestController
@CrossOrigin
@RequestMapping(value = "/student")
public class StudentController {

	private final StudentToStudentDTOOut studentToStudentDTOOut;
	private final StudentService service;
	private final StudentDTOToStudent studentDTOToStudent;
	private final StudentRepository studentRepository;
	private final StudentToStudentDTO studentToStudentDTO;


	public StudentController(StudentToStudentDTOOut studentToStudentDTOOut, StudentService serviceStudentService, StudentDTOToStudent studentDTOToStudent, StudentRepository studentRepository, StudentToStudentDTO studentToStudentDTO) {
		super();
		this.studentToStudentDTOOut = studentToStudentDTOOut;
		this.service = serviceStudentService;
		this.studentDTOToStudent = studentDTOToStudent;
		this.studentRepository = studentRepository;
		this.studentToStudentDTO = studentToStudentDTO;
	}
	
    @GetMapping
    public ResponseEntity<List<StudentDTOOut>> getAllStudents() {
        return ResponseEntity.ok(studentToStudentDTOOut.convert(service.dajSveStudente()) );
    }

	@GetMapping(value = "/{id}")
	public ResponseEntity<StudentDTOOut> findStudentByID(@PathVariable Long id){
		return ResponseEntity.ok(studentToStudentDTOOut.convert(service.dajStudentaZaID(id)));
	}
	
	@GetMapping(value = "name/{name}")
	public ResponseEntity<List<StudentDTOOut>> findStudentByNameContaining(@PathVariable String name){
		return ResponseEntity.ok( studentToStudentDTOOut.convert(service.dajStudentePoImenu(name)));
	}

	@GetMapping(value = "fullname/{name}")
	public ResponseEntity<StudentDTOOut> findStudentByNameEquals(@PathVariable String name){
		return ResponseEntity.ok(studentToStudentDTOOut.convert(service.dajStudentaPoImenu(name)));
	}


	@PostMapping
	public ResponseEntity<StudentDTO> saveStudent( @RequestBody StudentDTO newStudent){

		Student convertStudent = studentDTOToStudent.convert(newStudent);
		Student savedStudent = service.saveStudent(convertStudent);
		StudentDTO student =studentToStudentDTO.convert(savedStudent);
		return ResponseEntity.status(HttpStatus.CREATED).body(student);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<StudentDTO> editUser( @RequestBody StudentDTO studentDTO, @PathVariable Long id){
		/*if(!id.equals(userDTO.getId())){// ovo ide u servis pregled Studenta
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}@Valid dodaj dipendensi
*/
		Student editedStudent = service.saveStudent(studentDTOToStudent.convert(studentDTO));
		StudentDTO convertedStudent = studentToStudentDTO.convert(editedStudent);
		return ResponseEntity.ok(convertedStudent);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
