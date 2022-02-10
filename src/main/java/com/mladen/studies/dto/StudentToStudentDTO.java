package com.mladen.studies.dto;

import com.mladen.studies.entities.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentToStudentDTO implements Converter<Student, StudentDTO> {

    public StudentDTO convert(Student student) {
        return new StudentDTO.Builder()
                .withID(student.getId())
                .withFirstName(student.getIme())
                .withLastName(student.getPrezime())
                .withUserName(student.getKorisnickoIme())
                .withPassword(student.getSifra())
                .withEmail(student.getEmail())
                .withIndex(student.getIndeks())
                .build();
    }

    public List<StudentDTO> convert(List<Student> students) {
        return students.stream().map(this::convert).collect(Collectors.toList());
    }
}
