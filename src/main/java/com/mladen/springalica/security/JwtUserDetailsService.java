package com.mladen.springalica.security;

import com.mladen.springalica.entities.Profesor;
import com.mladen.springalica.services.ProfesorService;
import com.mladen.springalica.services.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService  implements UserDetailsService {


    @Autowired
    private ProfesorServiceImpl profesorServiceImpl;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Profesor profesor = profesorServiceImpl.dajProfesoraZaKorisnickoIme(username);

        if (profesor!=null) {
            return new User(profesor.getKorisnickoIme(), profesor.getSifra(),new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
