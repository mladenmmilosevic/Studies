package com.mladen.studies.dto;

public class StudentDTOPredmetOut {
    private String ime;
    private String prezime;
    private String email;
    private String indeks;

    public StudentDTOPredmetOut() {

    }

    public StudentDTOPredmetOut(String ime, String prezime, String email, String indeks) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.indeks = indeks;
    }


    public static class Builder {
        private String ime;
        private String prezime;
        private String email;
        private String indeks;

        public Builder() {
        }

        public Builder withFirstName(String ime) {
            this.ime = ime;
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

        public StudentDTOPredmetOut build() {
            StudentDTOPredmetOut studentDTO = new StudentDTOPredmetOut();
            studentDTO.ime = this.ime;
            studentDTO.prezime = this.prezime;
            studentDTO.email = this.email;
            studentDTO.indeks = this.indeks;

            return studentDTO;
        }

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
}
