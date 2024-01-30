drop database if exists distribuidora;
CREATE DATABASE distribuidora;

\c distribuidora;

create type address as (
    carrer varchar(50),
    localitate varchar(50),
    cp varchar(5),
    pais varchar(50)
);

create table magatzem (
    codi int,
    nom varchar(25),
    tel int,
    adresa address,

    primary key (codi)
);

create table jugueta (
    ref int,
    nom varchar(25),
    edad int,
    marca varchar(50),
    etiqueta varchar(25) array,
    codi_magatzem int,

    primary key (ref),
    foreign key (codi_magatzem) references magatzem(codi)
)

-- Insets
INSERT INTO magatzem (codi, nom, tel, adresa)
VALUES
    (1, 'test', 666999444, ('joan miro', 'inca', '07300', 'espanya')),
    (2, 'examen', 888333000, ('miro joan', 'palma', '07402', 'espanya')),
    (3, 'prova', 222333444, ('principal', 'sencelles', '07140', 'espanya'));

INSERT INTO jugueta (ref, nom, edad, marca, etiqueta, codi_magatzem)
VALUES
    (1, 'test', 12, 'sans', ARRAY['nins', 'test'], 1),
    (2, 'avaluacio', 8, 'postges', ARRAY['test'], 2),
    (3, 'java', 14, 'modul', ARRAY['jugar', 'aprenent'], 2);
