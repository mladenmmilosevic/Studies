package com.mladen.studies.dto;

public class PredmetDTO {

    private String naziv;

    public PredmetDTO() {
        super();
    }

    public PredmetDTO(String naziv) {
        this.naziv = naziv;
    }

    public static class Builder {
        private String naziv;

        public Builder() {
        }

        public Builder withNaziv(String naziv) {
            this.naziv = naziv;
            return this;
        }


        public PredmetDTO build() {
            PredmetDTO predmet = new PredmetDTO();
            predmet.naziv = this.naziv;

            return predmet;
        }
    }


    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
