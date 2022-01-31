package com.mladen.springalica.dto;


import com.mladen.springalica.entities.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentToStudentDTOOut implements Converter<Student, StudentDTOOut>{
    @Override
    public StudentDTOOut convert(Student student) {
        return new StudentDTOOut.Builder()
                .withFirstName(student.getIme())
                .withLastName(student.getPrezime())
                .withEmail(student.getEmail())
                .withIndex(student.getIndeks())
                .withPredmeti(student.getPredmeti())
                .build();
    }

    public List<StudentDTOOut> convert(List<Student> students){
        return students.stream().map(student -> convert(student)).collect(Collectors.toList());
    }
}
