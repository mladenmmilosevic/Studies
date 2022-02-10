package com.mladen.studies.dto;

import com.mladen.studies.entities.Predmet;

import java.util.List;

public class StudentDTOOut {

    private String ime;
    private String prezime;
    private String email;
    private String indeks;
    List<Predmet> predmeti;

    PredmetToPredmetDTO predmetToPredmetDTO = new PredmetToPredmetDTO();

    public StudentDTOOut() {
    }

    public static class Builder {

        private String ime;
        private String prezime;
        private String email;
        private String indeks;
        List<Predmet> predmeti;

        public Builder() {
        }

        public Builder withFirstName(String ime) {
            this.ime = ime;
            return this;
        }

        public Builder withPredmeti(List<Predmet> predmeti) {
            this.predmeti = predmeti;
            return this;
        }

        public Builder withLastName(String prezime) {
            this.prezime = prezime;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withIndex(String indeks) {
            this.indeks = indeks;
            return this;
        }

        public StudentDTOOut build() {
            StudentDTOOut studentDTOOut = new StudentDTOOut();
            studentDTOOut.ime = this.ime;
            studentDTOOut.prezime = this.prezime;
            studentDTOOut.email = this.email;
            studentDTOOut.indeks = this.indeks;
            studentDTOOut.predmeti = this.predmeti;

            return studentDTOOut;
        }

    }

    public List<PredmetDTO> getPredmeti() {
        return predmetToPredmetDTO.convert(predmeti);
    }

    public void setPredmeti(List<Predmet> predmeti) {
        this.predmeti = predmeti;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIndeks(String indeks) {
        this.indeks = indeks;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getEmail() {
        return email;
    }

    public String getIndeks() {
        return indeks;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                ", indeks='" + indeks + '\'' +
                '}';
    }

}
