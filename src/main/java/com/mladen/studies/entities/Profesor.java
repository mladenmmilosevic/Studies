package com.mladen.studies.entities;


import javax.validation.constraints.NotBlank;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "profesor")
public class Profesor extends Osoba {

    @NotBlank(message = "Profession must be set")
    @Size(min = 3, max = 50)
    private String zvanje;

    public Profesor() {
        super();
    }

    public Profesor(String ime, String prezime, String email, String korisnickoIme, String sifra, int id,
                    String zvanje) {
        super(id, ime, prezime, email, korisnickoIme, sifra);

        this.zvanje = zvanje;
    }


    public static class Builder {

        private Long id;
        private String ime;
        private String prezime;
        private String korisnickoIme;
        private String sifra;
        private String email;
        private String zvanje;


        public Builder() {
        }

        public Profesor.Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Profesor.Builder withFirstName(String ime) {
            this.ime = ime;
            return this;
        }

        public Profesor.Builder withLastName(String prezime) {
            this.prezime = prezime;
            return this;
        }

        public Profesor.Builder withUserName(String korisnickoIme) {
            this.korisnickoIme = korisnickoIme;
            return this;
        }

        public Profesor.Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Profesor.Builder withPassword(String sifra) {
            this.sifra = sifra;
            return this;
        }

        public Profesor.Builder withProfession(String zvanje) {
            this.zvanje = zvanje;
            return this;
        }

        public Profesor build() {
            Profesor profesor = new Profesor();
            profesor.id = this.id;
            profesor.ime = this.ime;
            profesor.prezime = this.prezime;
            profesor.korisnickoIme = this.korisnickoIme;
            profesor.email = this.email;
            profesor.sifra = this.sifra;
            profesor.zvanje = this.zvanje;

            return profesor;
        }
    }

    public String getZvanje() {
        return zvanje;
    }

    public void setZvanje(String zvanje) {
        this.zvanje = zvanje;
    }

    @Override
    public String toString() {
        return "Profesor [zvanje= " + zvanje + " " + super.toString() + "]";
    }

}
