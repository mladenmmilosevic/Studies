package com.mladen.studies.dto;

import com.mladen.studies.entities.Predmet;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

public class PredmetToPredmetDTO implements Converter<Predmet, PredmetDTO> {
    public PredmetDTO convert(Predmet predmet) {
        return new PredmetDTO.Builder()
                .withNaziv(predmet.getNaziv())
                .build();
    }

    public List<PredmetDTO> convert(List<Predmet> predmeti) {
        return predmeti.stream().map(this::convert).collect(Collectors.toList());
    }
}
