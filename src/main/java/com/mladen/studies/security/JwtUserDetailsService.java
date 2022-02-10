package com.mladen.studies.security;


import com.mladen.studies.entities.Student;
import com.mladen.studies.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {


    @Autowired
    private StudentService studentService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Student student = studentService.dajStudentaPoKorisnickomImenu(username);

        return new User(student.getKorisnickoIme(), student.getSifra(), new ArrayList<>());

    }
}
