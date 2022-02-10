package com.mladen.studies.entities;

import javax.validation.constraints.NotBlank;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class Osoba {

	@Id
	@NotNull(message = "ID must be set")
	protected Long id;
	@NotBlank(message = "FirstName must be set")
	@Size(min =	3, max = 30)
	protected String ime;
	@NotBlank(message = "LastName must be set")
	@Size(min =	3, max = 30)
	protected String prezime;
	@NotBlank(message = "Email must be set")
	@Size(min =	3, max = 50)
	protected String email;
	@NotBlank(message = "UserName must be set")
	@Size(min =	3, max = 50)
	protected String korisnickoIme;
	@NotBlank(message = "Password must be set")
	@Size(min =	3, max = 100)
	protected String sifra;
	
	public Osoba()
	{}

	public Osoba(long id, String ime, String prezime, String email, String korisnickoIme, String sifra) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.korisnickoIme = korisnickoIme;
		this.sifra = sifra;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	@Override
	public String toString() {
		return "  id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", email=" + email + ", korisnickoIme="
				+ korisnickoIme + ", sifra=" + sifra + "]";
	}

	
}
