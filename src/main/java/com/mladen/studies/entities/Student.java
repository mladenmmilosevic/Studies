package com.mladen.studies.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "student")
public class Student extends Osoba {


    @NotBlank(message = "Index must be set")
    @Size(min = 3, max = 50)
    private String indeks;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_predmet",
            joinColumns = {@JoinColumn(name = "idstudent")},
            inverseJoinColumns = {@JoinColumn(name = "idpredmet")})
    private List<Predmet> predmeti;


    public Student() {
        super();
    }

    public Student(String ime, String prezime, String email, String korisnickoIme, String sifra, int id,
                   String indeks) {
        super(id, ime, prezime, email, korisnickoIme, sifra);
        this.indeks = indeks;
    }

    public static class Builder {

        private Long id;
        private String ime;
        private String prezime;
        private String korisnickoIme;
        private String sifra;
        private String email;
        private String indeks;
        private Role role;
        private List<Predmet> predmeti;

        public Builder() {
        }


        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withPredmeti(List<Predmet> predmeti) {
            this.predmeti = predmeti;
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

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPassword(String sifra) {
            this.sifra = sifra;
            return this;
        }

        public Builder withInedex(String indeks) {
            this.indeks = indeks;
            return this;
        }

        public Builder withRole(Role role) {
            this.role = role;
            return this;
        }

        public Student build() {
            Student student = new Student();
            student.id = this.id;
            student.ime = this.ime;
            student.prezime = this.prezime;
            student.korisnickoIme = this.korisnickoIme;
            student.email = this.email;
            student.sifra = this.sifra;
            student.indeks = this.indeks;
            student.role = this.role;
            student.predmeti = this.predmeti;


            return student;
        }
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getIndeks() {
        return indeks;
    }

    public void setIndeks(String indeks) {
        this.indeks = indeks;
    }

    public List<Predmet> getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(List<Predmet> predmeti) {
        this.predmeti = predmeti;
    }


    @Override
    public String toString() {
        return "Student [ indeks=" + indeks + " " + super.toString() + "]";
    }


}
