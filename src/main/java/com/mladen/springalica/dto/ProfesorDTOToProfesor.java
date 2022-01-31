package com.mladen.springalica.dto;

import com.mladen.springalica.entities.Profesor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfesorDTOToProfesor  implements Converter<ProfesorDTO, Profesor> {
    @Override
    public Profesor convert(ProfesorDTO profesorDTO) {

        return new Profesor.Builder()
                .withId(profesorDTO.getId())
                .withFirstName(profesorDTO.getIme())
                .withLastName(profesorDTO.getPrezime())
                .withUserName(profesorDTO.getKorisnickoIme())
                .withPassword(profesorDTO.getSifra())
                .withEmail(profesorDTO.getEmail())
                .withProfession(profesorDTO.getZvanje())
                .build();
    }

    public List<Profesor> convert(List<ProfesorDTO> profesorDTOS){
        return profesorDTOS.stream().map(profesorDTO -> convert(profesorDTO)).collect(Collectors.toList());

    }
}
