\c institut;

-- crear taula activitat --
create type activitats as (
    titol varchar(200),
    enunciat varchar(2000),
    url varchar(200)
);

-- modificar taula assignatures --
alter table assignatures add column activitat activitats[];

-- crear una nova activitat --
update assignatures set activitat = array_append(activitat, ('Activitat ORDB', 'Activitat per practicar', null)::activitats)
                    where id_assignatura = 2 and cicle = 1;

-- modificar una activitat --
update assignatures set activitat[1].titol = activitat[1].titol || ' BORRADOR'
                    where id_assignatura = 2 and cicle = 1;

-- afegir una url --
update assignatures set activitat[1].url = 'https://aulavirtual.paucasesnovescifp.cat/mod/assign/view.php?id=6028'
                    where id_assignatura = 2 and cicle = 1;