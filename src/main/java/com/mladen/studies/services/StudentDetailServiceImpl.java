package com.mladen.studies.services;

import com.mladen.studies.entities.Student;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;


public class StudentDetailServiceImpl implements UserDetailsService {
    private final StudentService studentService;

    public StudentDetailServiceImpl(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentService.dajStudentaPoKorisnickomImenu(username);

        return new org.springframework.security.core.userdetails.User(
                student.getKorisnickoIme(),
                student.getSifra(),
                Collections.singletonList(new SimpleGrantedAuthority(student.getRole().toString()))
        );
    }
}