package com.mladen.studies.dto;

public class StudentDTO {
    private Long id;
    private String ime;
    private String prezime;
    private String email;
    private String korisnickoIme;
    private String sifra;
    private String indeks;

    public StudentDTO() {
    }

    public static class Builder {
        private Long id;
        private String ime;
        private String prezime;
        private String email;
        private String korisnickoIme;
        private String sifra;
        private String indeks;

        public Builder() {
        }

        public Builder withID(Long id) {
            this.id = id;
            return this;
        }


        public Builder withFirstName(String ime) {
            this.ime = ime;
            return this;
        }

        public Builder withLastName(String prezime) {
            this.prezime = prezime;
            return this;
        }

        public Builder withUserName(String korisnickoIme) {
            this.korisnickoIme = korisnickoIme;
            return this;
        }

        public Builder withPassword(String sifra) {
            this.sifra = sifra;
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

        public StudentDTO build() {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.id = this.id;
            studentDTO.ime = this.ime;
            studentDTO.prezime = this.prezime;
            studentDTO.korisnickoIme = this.korisnickoIme;
            studentDTO.email = this.email;
            studentDTO.indeks = this.indeks;

            return studentDTO;
        }

    }

    public void setId(Long id) {
        this.id = id;
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

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public void setIndeks(String indeks) {
        this.indeks = indeks;
    }

    public Long getId() {
        return id;
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

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public String getIndeks() {
        return indeks;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                ", korisnickoIme='" + korisnickoIme + '\'' +
                ", sifra='" + sifra + '\'' +
                ", indeks='" + indeks + '\'' +
                '}';
    }
}
