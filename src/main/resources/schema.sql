
create table student(
	id long primary key,
	ime varchar(50),
	prezime varchar(50),
	email varchar(50),
	korisnicko_ime varchar(50),
	sifra varchar(150),
	indeks varchar(50),
	role varchar(10)
);

create table profesor(
	id long primary key,
	ime varchar(50),
	prezime varchar(50),
	email varchar(50),
	korisnicko_ime varchar(50),
	sifra varchar(100),
	zvanje varchar(50)
);

create table predmet(
	predmetid long primary key,
	naziv varchar(50)
);
create table student_predmet(
	idStudent long ,
	idPredmet long ,
	PRIMARY KEY (idStudent,idPredmet),
	FOREIGN KEY (idStudent) REFERENCES student(id),
	FOREIGN KEY (idPredmet) REFERENCES predmet(predmetid)
);