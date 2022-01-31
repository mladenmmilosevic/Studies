package com.mladen.springalica.controller;

import com.mladen.springalica.dto.*;
import com.mladen.springalica.entities.Profesor;
import com.mladen.springalica.entities.User;
import com.mladen.springalica.security.JwtTokenUtil;
import com.mladen.springalica.security.JwtUserDetailsService;
import com.mladen.springalica.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLOutput;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/profesor")
public class ProfesorController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;


    private final ProfesorToProfesorDTOOut profesorToProfesorDTOOut;
    private final ProfesorService profesorService;
    private final ProfesorDTOToProfesor profesorDTOToProfesor;

    public ProfesorController(ProfesorToProfesorDTOOut profesorToProfesorDTOOut, ProfesorService profesorService, ProfesorDTOToProfesor profesorDTOToProfesor) {
        this.profesorToProfesorDTOOut = profesorToProfesorDTOOut;
        this.profesorService = profesorService;
        this.profesorDTOToProfesor = profesorDTOToProfesor;
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User authenticationRequest) throws Exception {
        System.out.println(
                "uso sam u createAuthenticationToken sifra je " + authenticationRequest.getPassword() + " a name je " + authenticationRequest.getUsername()
        );

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
