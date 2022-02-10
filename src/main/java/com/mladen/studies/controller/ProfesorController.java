package com.mladen.studies.controller;

import com.mladen.studies.dto.*;
import com.mladen.studies.entities.Profesor;
import com.mladen.studies.entities.User;
import com.mladen.studies.security.JwtTokenUtil;
import com.mladen.studies.security.JwtUserDetailsService;
import com.mladen.studies.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profesor")
public class ProfesorController {

    private final ProfesorToProfesorDTOOut profesorToProfesorDTOOut;
    private final ProfesorService profesorService;
    private final ProfesorDTOToProfesor profesorDTOToProfesor;

    public ProfesorController(ProfesorToProfesorDTOOut profesorToProfesorDTOOut, ProfesorService profesorService, ProfesorDTOToProfesor profesorDTOToProfesor) {
        this.profesorToProfesorDTOOut = profesorToProfesorDTOOut;
        this.profesorService = profesorService;
        this.profesorDTOToProfesor = profesorDTOToProfesor;
    }

    @GetMapping
    public ResponseEntity<List<ProfesorDTOOut>> getAllTeachers() {
        return ResponseEntity.ok(profesorToProfesorDTOOut.convert(profesorService.dajSveProfesore()) );
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProfesorDTOOut> findTeacherByID(@PathVariable Long id){
        return ResponseEntity.ok(profesorToProfesorDTOOut.convert(profesorService.dajProfesoraZaID(id)));
    }

    @GetMapping(value = "name/{name}")
    public ResponseEntity<List<ProfesorDTOOut>> findTeacherByNameContaining(@PathVariable String name){
        return ResponseEntity.ok( profesorToProfesorDTOOut.convert(profesorService.dajProfesorePoImenu(name)));
    }

    @GetMapping(value = "fullname/{name}")
    public ResponseEntity<ProfesorDTOOut> findTeacherByNameEquals(@PathVariable String name){
        return ResponseEntity.ok(profesorToProfesorDTOOut.convert(profesorService.dajProfesoraPoImenu(name)));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id){
        profesorService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<ProfesorDTOOut> saveTeacher( @RequestBody ProfesorDTO newProfesor){

        Profesor convertProfesor = profesorDTOToProfesor.convert(newProfesor);
        Profesor savedProfesor = profesorService.saveProfesor(convertProfesor);
        ProfesorDTOOut convertedDTOProfesorDTOOut = profesorToProfesorDTOOut.convert(savedProfesor);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertedDTOProfesorDTOOut);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProfesorDTOOut> editTeacher( @RequestBody ProfesorDTO profesorDTO, @PathVariable Long id){

        Profesor editedProfesor = profesorService.saveProfesor(profesorDTOToProfesor.convert(profesorDTO));
        ProfesorDTOOut convertedProfesor = profesorToProfesorDTOOut.convert(editedProfesor);
        return ResponseEntity.ok(convertedProfesor);
    }

}
