package com.mladen.springalica.dto;

public class ProfesorDTO {
    private Long id;
    private String ime;
    private String prezime;
    private String email;
    private String korisnickoIme;
    private String sifra;
    private String zvanje;

    public ProfesorDTO(){
    }

    public static class Builder{
        private Long id;
        private String ime;
        private String prezime;
        private String email;
        private String korisnickoIme;
        private String sifra;
        private String zvanje;

        public Builder(){
        }

        public ProfesorDTO.Builder withID(Long id){
            this.id = id;
            return this;
        }

        public ProfesorDTO.Builder withFirstName(String ime){
            this.ime = ime;
            return this;
        }

        public ProfesorDTO.Builder withLastName(String prezime ){
            this.prezime = prezime;
            return this;
        }

        public ProfesorDTO.Builder withUserName(String korisnickoIme){
            this.korisnickoIme = korisnickoIme;
            return this;
        }

        public ProfesorDTO.Builder withPassword(String sifra){
            this.sifra = sifra;
            return this;
        }

        public ProfesorDTO.Builder withEmail(String email){
            this.email = email;
            return this;
        }
        public ProfesorDTO.Builder withProfession(String zvanje){
            this.zvanje = zvanje;
            return this;
        }
        public ProfesorDTO build(){
            ProfesorDTO profesorDTO = new ProfesorDTO();
            profesorDTO.id = this.id;
            profesorDTO.ime  = this.ime;
            profesorDTO.prezime  = this.prezime;
            profesorDTO.korisnickoIme = this.korisnickoIme;
            profesorDTO.sifra = this.sifra;
            profesorDTO.email = this.email;
            profesorDTO.zvanje = this.zvanje;

            return profesorDTO;
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

    public void setZvanje(String zvanje) {
        this.zvanje = zvanje;
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

    public String getZvanje() {
        return zvanje;
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
                ", zvanje='" + zvanje + '\'' +
                '}';
    }
}
