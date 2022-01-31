package com.mladen.springalica.dto;

import com.mladen.springalica.entities.Profesor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfesorToProfesorDTO implements Converter<Profesor,ProfesorDTO> {

    public ProfesorDTO convert(Profesor profesor) {
        return new ProfesorDTO.Builder()
                .withID(profesor.getId())
                .withFirstName(profesor.getIme())
                .withLastName(profesor.getPrezime())
                .withUserName(profesor.getKorisnickoIme())
                .withPassword(profesor.getSifra())
                .withEmail(profesor.getEmail())
                .withProfession(profesor.getZvanje())
                .build();
    }

    public List<ProfesorDTO> convert(List<Profesor> profesors) {
        return profesors.stream().map(this::convert).collect(Collectors.toList());
    }
}
