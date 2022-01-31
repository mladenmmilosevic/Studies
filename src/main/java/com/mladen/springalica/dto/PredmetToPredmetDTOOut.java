package com.mladen.springalica.dto;

import com.mladen.springalica.entities.Predmet;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

public class PredmetToPredmetDTOOut implements Converter<Predmet,PredmetDTOOut> {
    public PredmetDTOOut convert(Predmet predmet) {
        return new PredmetDTOOut.Builder()
                .withNaziv(predmet.getNaziv())
                .withStudents(predmet.getStudenti())
                .build();
    }

    public List<PredmetDTOOut> convert(List<Predmet> predmeti){
        return predmeti.stream().map(this::convert).collect(Collectors.toList());
    }
}
