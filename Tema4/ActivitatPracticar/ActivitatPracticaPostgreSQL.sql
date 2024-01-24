\c institut;

-- crear taula activitat --
create type activitats as (
    titol varchar(200),
    enunciat varchar(2000),
    url varchar(200)
);

-- modificar taula assignatures --
alter table assignatures add column activitat activitats;
-- alter table assignatures alter column activitat type activitats;

-- crear una nova activitat --
update assignatures set activitat = ('Activitat ORDB', 'Activitat per practicar', 'http://www.google.com')
                    where id_assignatura = 2 and cicle = 1;


-- modificar una activitat --
-- add "BORRADOR" to the title --
update assignatures set activitat.titol = (activitat).titol || 'BORRADOR'
                    where id_assignatura = 2 and cicle = 1;

-- afegir una url --
update assignatures set activitat.url = 'https://aulavirtual.paucasesnovescifp.cat/mod/assign/view.php?id=6028'
                    where id_assignatura = 2 and cicle = 1;