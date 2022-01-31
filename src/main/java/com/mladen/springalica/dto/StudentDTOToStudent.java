package com.mladen.springalica.dto;

import com.mladen.springalica.entities.Student;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentDTOToStudent implements  Converter<StudentDTO, Student> {

    @Override
    public Student convert(StudentDTO studentDTO) {

        return new Student.Builder()
                .withId(studentDTO.getId())
                .withFirstName(studentDTO.getIme())
                .withLastName(studentDTO.getPrezime())
                .withUserName(studentDTO.getKorisnickoIme())
                .withPassword(studentDTO.getSifra())
                .withEmail(studentDTO.getEmail())
                .withInedex(studentDTO.getIndeks())
                .build();
    }

    public List<Student> convert(List<StudentDTO> StudentDTOS){
        return StudentDTOS.stream().map(studentDTO -> convert(studentDTO)).collect(Collectors.toList());

    }

}
