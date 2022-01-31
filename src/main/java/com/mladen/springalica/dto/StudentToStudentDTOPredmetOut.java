package com.mladen.springalica.dto;

import com.mladen.springalica.entities.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentToStudentDTOPredmetOut  implements Converter<Student, StudentDTOPredmetOut> {
    @Override
    public StudentDTOPredmetOut convert(Student student) {
        return new StudentDTOPredmetOut.Builder()
                .withFirstName(student.getIme())
                .withLastName(student.getPrezime())
                .withEmail(student.getEmail())
                .withIndex(student.getIndeks())
                .build();
    }

    public List<StudentDTOPredmetOut> convert(List<Student> students){
        return students.stream().map(student -> convert(student)).collect(Collectors.toList());
    }
}
