-- Activitat enunciat: https://aulavirtual.paucasesnovescifp.cat/mod/assign/view.php?id=6022

-- 1. Crear la base de dades
drop database if exists Institut;
CREATE DATABASE Institut;

\c institut;

create type dades_contacte as (
    telefon varchar(9),
    email varchar(50),
    twitter varchar(15) -- el numero maxim d'un usuari de twitter es de 15 caracters
);

create table Alumnes (
    nif varchar(9),
    nom varchar(50),
    cognoms varchar(50),
    dades_alumne dades_contacte,

    primary key (nif)
);

create table Cicles (
    id_cicle int,
    nom varchar(25),

    primary key (id_cicle)
);

create table Assignatures (
    id_assignatura int,
    nom varchar(25),
    cicle int,

    primary key (id_assignatura),
    foreign key (cicle) references Cicles(id_cicle)
);

create table Matricula (
    alumne varchar(9),
    assignatura int,
    nota decimal(3,1) array,

    primary key (alumne, assignatura),
    foreign key (alumne) references Alumnes(nif),
    foreign key (assignatura) references Assignatures(id_assignatura)
);

-- 2. Insertar dades
-- Alumnes
INSERT INTO Alumnes (nif, nom, cognoms, dades_alumne)
VALUES
    ('12345678F', 'Joan', 'Sanchez', ('123456789', 'joan@example.com', 'joan')),
    ('98765432B', 'Josep Antoni', 'Aguilo', ('987654321', 'josepanotni@example.com', 'peptoni'));

-- Cicles
INSERT INTO Cicles (id_cicle, nom)
VALUES
    (1, 'DAM'),
    (2, 'DAW');

-- Assignatures
INSERT INTO Assignatures (id_assignatura, nom, cicle)
VALUES
    (1, 'Serveis i Porocessos', 1),
    (2, 'Acces a Dades', 1);

-- Notes
INSERT INTO Matricula (alumne, assignatura, nota)
VALUES
    ('12345678F', 1, ARRAY[8.5, 7.2]),
    ('98765432B', 2, ARRAY[9.0, 8.8]);

-- 3. Consultes

-- 1. Recupera tots els alumnes de la base de dades.
SELECT * FROM Alumnes;

-- 2. Mostra totes les assignatures d'un cicle determinat.
SELECT * FROM Assignatures WHERE cicle = 1;

-- 3. Recupera tots els alumnes d'un cicle determinat.
SELECT * FROM Alumnes a
JOIN Matricula m ON a.nif = m.alumne
JOIN Assignatures asg ON m.assignatura = asg.id_assignatura
WHERE asg.cicle = 1;

-- 4. Recupera totes les notes d'un alumne d'una assignatura determinada. (amb join)
SELECT a.nom, asg.nom, m.nota FROM Matricula m
JOIN Alumnes a ON m.alumne = a.nif
JOIN Assignatures asg ON m.assignatura = asg.id_assignatura
WHERE a.nif = '12345678F' AND asg.id_assignatura = 1;

-- 5. Afegeix una nota d'un alumne per una assignatura determinada
UPDATE Matricula SET nota = array_append(nota, 9.5) WHERE alumne = '12345678F' AND assignatura = 1;

-- 6. Mostra tots els alumnes que tenguin alguna nota inferior a 5 per una assignatura determinada.
SELECT DISTINCT s.*
FROM Matricula
JOIN Alumnes s ON Matricula.alumne = s.nif
WHERE 5 > ANY (nota) AND assignatura = 1;

-- 7.Cerca un alumne per el seu correu.
SELECT * FROM Alumnes
WHERE (dades_alumne).email = 'josepanotni@example.com';

-- 8. Mostra els alumnes que no tenguin twitter.
SELECT * FROM Alumnes
WHERE (dades_alumne).twitter IS NULL;

-- 9. Corregeix el telèfon d'un alumne.
UPDATE Alumnes
SET dades_alumne.telefon = '000000000'
WHERE nif = '12345678F';
