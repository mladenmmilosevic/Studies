insert into student(id,ime,prezime,email,korisnicko_ime,sifra,indeks,role)values
(1,'Miljneko' ,'Cutuk', 'miljneko.cutuk@gmail.com', 'Miljneko@Cutuk','$2y$12$pt3b9lsi9Pu9d5QcC2bZDegHYMNBMXU2tmJneJeoafiRNBe2966n6', '20-2021','ADMIN'),--admin
(2,'Pera' ,'Cutuk', 'pera.cutuk@gmail.com','Pera@Cutuk', '$2y$12$7xGsRfmnTojYLY8gkUpvhuutxSc3/AaJ2YvkVWkUUVbmCI1MSgUXW', '21-2021','USER'),--helo
(3,'Zika' ,'Cutuk', 'zika.cutuk@gmail.com','Zika@Cutuk', '$2y$12$7xGsRfmnTojYLY8gkUpvhuutxSc3/AaJ2YvkVWkUUVbmCI1MSgUXW', '22-2021','USER');

insert into profesor(id,ime,prezime,email,korisnicko_ime,sifra,zvanje)values
(1,'Boban' ,'Stojanovic', 'boban.stojanovic@gmail.com','boban.stojanovic', 'boban123', 'dr'),
(2,'Ana' ,'Kaplarevic', 'ana.kaplarevic@gmail.com', 'ana.kaplarevic','ana123', 'mr'),
(3,'Milos' ,'Ivanovic', 'milos.ivanovic@gmail.com', 'milos.ivanovic','milos123', 'mr');


insert into predmet(predmetid,naziv)values(1,'Osnovi programiranja'),(2,'Spa1'),(3,'Spa2'),(4,'Algoritamske strategije');

insert into student_predmet(idStudent,idPredmet)values
(1,1),(1,2),(1,3),(2,1),(2,2),(2,3),(3,2),(3,3),(3,4);
