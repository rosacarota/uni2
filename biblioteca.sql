create database biblioteca;

use biblioteca;

create table Socio (
    Matricola char(10),
    Nome varchar(30),
    Cognome varchar(30),
    Data_nascita date,
    Data_iscrizione date,
    primary key(Matricola)
);

create table Rivista (
    Codice int,
    Titolo varchar(50),
    Anno int,
    Mese int,
    Volume int,
    Issue int, 
    primary key(Codice)
);

create table Libro (
    Codice int,
    Titolo varchar(50),
    Copie_Disponibili int,
    primary key(Codice)
);

create table Edizione (
    ISBN char(13), 
    Anno_Stampa int,
    Edizione varchar(20) 
);

create table Copia (
    Codice_Catalogazione int,
    Stato varchar(10),
    Codice_Libro int, 
    ISBN char(13),

    primary key(Codice_Catalogazione),
    foreign key(Codice_Libro) references Libro(Codice),
    foreign key(ISBN) references Edizione(ISBN)
);

