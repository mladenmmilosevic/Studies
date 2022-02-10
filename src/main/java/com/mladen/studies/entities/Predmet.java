package com.mladen.studies.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "predmet")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Predmet {

    @Id
    private long predmetid;
    @NotBlank(message = "NameClass must be set")
    @Size(min = 3, max = 50)
    private String naziv;

    @ManyToMany(mappedBy = "predmeti")
    @JsonbTransient
    private List<Student> studenti;

    public Predmet() {
        super();
    }

    public Predmet(long id, long predmetid, String naziv) {
        this.predmetid = predmetid;
        this.naziv = naziv;
    }

    public static class Builder {
        private int predmetid;
        private String naziv;
        private List<Student> studenti;

        public Builder() {
        }

        public Builder withId(int predmetid) {
            this.predmetid = predmetid;
            return this;
        }

        public Builder withNazivPredmeta(String nazivPredmeta) {
            this.naziv = nazivPredmeta;
            return this;
        }

        public Builder withStudenti(List<Student> studenti) {
            this.studenti = studenti;
            return this;
        }

        public Predmet build() {
            Predmet predmet = new Predmet();
            predmet.predmetid = this.predmetid;
            predmet.naziv = this.naziv;
            predmet.studenti = this.studenti;


            return predmet;
        }
    }

    public List<Student> getStudenti() {

        return this.studenti;
    }

    public void setStudenti(List<Student> studenti) {
        this.studenti = studenti;
    }

    public long getPredmetid() {
        return predmetid;
    }

    public void setPredmetid(long predmetid) {
        this.predmetid = predmetid;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "Predmet [sifra=" + predmetid + ", naziv=" + naziv + "]";
    }

}
