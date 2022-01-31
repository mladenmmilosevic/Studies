package com.mladen.springalica.dto;

import com.mladen.springalica.entities.Student;

import java.util.List;

public class PredmetDTOOut {
    private String naziv;
    private List<Student> studenti;
    private StudentToStudentDTOPredmetOut studentToStudentDTOPredmetOut = new StudentToStudentDTOPredmetOut();

    public PredmetDTOOut() {
        super();
    }

    public PredmetDTOOut(String naziv, List<Student> studenti) {
        this.naziv = naziv;
        this.studenti = studenti;
    }

    public static class Builder {
        private String naziv;
        private List<Student> studenti;
        public Builder() {}

        public Builder withStudents(List<Student> studenti) {
            this.studenti = studenti;
            return this;
        }

        public Builder withNaziv(String naziv) {
            this.naziv = naziv;
            return this;
        }

        public PredmetDTOOut build() {
            PredmetDTOOut predmet = new PredmetDTOOut();
            predmet.naziv = this.naziv;
            predmet.studenti = this.studenti;

            return predmet;
        }
    }

    public List<StudentDTOPredmetOut> getStudenti() {
        return studentToStudentDTOPredmetOut.convert(studenti);
    }

    public void setStudenti(List<Student> studenti) {
        this.studenti = studenti;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
