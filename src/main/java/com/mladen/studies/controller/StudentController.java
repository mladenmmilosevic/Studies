package com.mladen.studies.controller;

import java.util.List;

import com.mladen.studies.dto.*;
import com.mladen.studies.entities.User;
import com.mladen.studies.repository.StudentRepository;
import com.mladen.studies.security.JwtTokenUtil;
import com.mladen.studies.security.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.mladen.studies.entities.Student;
import com.mladen.studies.services.StudentService;


@RestController
@RequestMapping(value = "/student")
public class StudentController {

    private final StudentToStudentDTOOut studentToStudentDTOOut;
    private final StudentService service;
    private final StudentDTOToStudent studentDTOToStudent;
    private final StudentRepository studentRepository;
    private final StudentToStudentDTO studentToStudentDTO;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

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
        return ResponseEntity.ok(studentToStudentDTOOut.convert(service.dajSveStudente()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StudentDTOOut> findStudentByID(@PathVariable Long id) {
        return ResponseEntity.ok(studentToStudentDTOOut.convert(service.dajStudentaZaID(id)));
    }

    @GetMapping(value = "name/{name}")
    public ResponseEntity<List<StudentDTOOut>> findStudentByNameContaining(@PathVariable String name) {
        return ResponseEntity.ok(studentToStudentDTOOut.convert(service.dajStudentePoImenu(name)));
    }

    @GetMapping(value = "fullname/{name}")
    public ResponseEntity<StudentDTOOut> findStudentByNameEquals(@PathVariable String name) {
        return ResponseEntity.ok(studentToStudentDTOOut.convert(service.dajStudentaPoImenu(name)));
    }


    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(token);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @PostMapping
    public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO newStudent) {

        Student convertStudent = studentDTOToStudent.convert(newStudent);
        Student savedStudent = service.saveStudent(convertStudent);
        StudentDTO student = studentToStudentDTO.convert(savedStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<StudentDTO> editUser(@RequestBody StudentDTO studentDTO, @PathVariable Long id) {
		/*if(!id.equals(userDTO.getId())){// ovo ide u servis pregled Studenta
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}@Valid dodaj dipendensi
*/
        Student editedStudent = service.saveStudent(studentDTOToStudent.convert(studentDTO));
        StudentDTO convertedStudent = studentToStudentDTO.convert(editedStudent);
        return ResponseEntity.ok(convertedStudent);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
