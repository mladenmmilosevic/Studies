package com.mladen.studies.dto;

public class ProfesorDTOOut {
    private String ime;
    private String prezime;
    private String email;
    private String zvanje;

    public ProfesorDTOOut(){
    }

    public static class Builder{

        private String ime;
        private String prezime;
        private String email;
        private String zvanje;

        public Builder(){
        }

        public ProfesorDTOOut.Builder withFirstName(String ime){
            this.ime = ime;
            return this;
        }

        public ProfesorDTOOut.Builder withLastName(String prezime ){
            this.prezime = prezime;
            return this;
        }

        public ProfesorDTOOut.Builder withEmail(String email){
            this.email = email;
            return this;
        }
        public ProfesorDTOOut.Builder withProfession(String zvanje){
            this.zvanje = zvanje;
            return this;
        }
        public ProfesorDTOOut build(){
            ProfesorDTOOut studentDTOOut = new ProfesorDTOOut();
            studentDTOOut.ime  = this.ime;
            studentDTOOut.prezime  = this.prezime;
            studentDTOOut.email = this.email;
            studentDTOOut.zvanje = this.zvanje;

            return studentDTOOut;
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

    public void setZvanje(String zvanje) {
        this.zvanje = zvanje;
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
    public String getZvanje() {return zvanje;}
    @Override
    public String toString() {
        return "StudentDTO{" +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                ", zvanje='" + zvanje + '\'' +
                '}';
    }

}
