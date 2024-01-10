-- fet  a la terminal

create type t_contacte as (
    cif_nif varchar(9),
    telefon varchar(15),
    email varchar(100)
);

create table usuaris (
    id_user int,
    naom varchar(80),
    contacte t_contacte,

    primary key (id_user)
);

create table categories (
    codi int,
    nom char(40),

    primary key (codi)
);

create table llibres (
    codi int,
    titol varchar(100),
    categoria int,

    primary key (codi),

    foreign key (categoria) references categories(codi)
);

create table compres (
    llibre int,
    client int,
    quantitats int[],

    primary key (llibre, client),

    foreign key (llibre) references llibres(codi),
    foreign key (client) references usuaris(id_user)
);

-- fet  a la terminal

-- usuaris
insert into usuaris values (1, 'Pep', row('12345678A', '123456789', 'pep@cifp.cat'));
insert into usuaris values (2, 'Aina', row('87654321Z', '987654321', 'aina@cifp.cat'));

-- categories
insert into categories values (1, 'Bases de Dades');

-- llbres
insert into llibres values (1, 'PostgesSQL for everybody', 1);
insert into llibres values (2, 'PostgesSQL advanced', 1);

-- compres
insert into compres values (1, 1, '{10, 5, 123}');
insert into compres values (1, 2, '{12, 20, 100, 3}');