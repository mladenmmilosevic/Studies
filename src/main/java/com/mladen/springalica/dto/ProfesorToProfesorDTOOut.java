package com.mladen.springalica.dto;

import com.mladen.springalica.entities.Profesor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfesorToProfesorDTOOut implements Converter<Profesor, ProfesorDTOOut> {
    @Override
    public ProfesorDTOOut convert(Profesor profesor) {
        return new ProfesorDTOOut.Builder()
                .withFirstName(profesor.getIme())
                .withLastName(profesor.getPrezime())
                .withEmail(profesor.getEmail())
                .withProfession(profesor.getZvanje())
                .build();
    }

    public List<ProfesorDTOOut> convert(List<Profesor> profesors){
        return profesors.stream().map(profesor -> convert(profesor)).collect(Collectors.toList());
    }
}
