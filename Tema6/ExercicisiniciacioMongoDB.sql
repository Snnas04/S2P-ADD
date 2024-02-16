-- FIND
-- Selecciona tots els aspirants
db.aspirants.find();

-- Selecciona els aspirants de nom Bartomeu
db.aspirants.find({
    "nom": "Bartomeu"
});

-- Selecciona els aspirants que siguin de la localitat
db.aspirants.find({
    "localitat.nomLocalitat": "CALONGE",
});

-- Troba l'aspirant amb NIF 47537490F
db.aspirants.find({
    "nif": "47537490F",
});

-- Troba els aspirants que siguin de Calonge i nomin Bartomeu.No utilitzis and
db.aspirants.find({
    "nom": "Bartomeu",
    "localitat.nomLocalitat": "CALONGE"
});

-- Troba els aspirants que siguin de Calonge i nomin Bartomeu.Utilitza and
db.aspirants.find({
    $and: [
        {"nom": "Bartomeu"},
        {"localitat.nomLocalitat": "CALONGE"}
    ]
});

-- Cerca els aspirants que siguin de Calonge o nomin Bartomeu
db.aspirants.find({
    $or: [
        {"nom": "Bartomeu"},
        {"localitat.nomLocalitat": "CALONGE"}
    ]
});

-- Mostra els aspirants que siguin de Muro o de Sant Rafel. Utilitza or
db.aspirants.find({
    $or: [
        {"localitat.nomLocalitat": "MURO"},
        {"localitat.nomLocalitat": "SANT RAFEL"}
    ]
});

-- Mostra els aspirants que siguin de Muro o de Sant Rafel. Utilitza in
db.aspirants.find({
    "localitat.nomLocalitat": {
        $in: ["MURO", "SANT RAFEL"]
    }
});

-- Mostra els aspirants que no siguin de Muro o de Sant Rafel. Utilitza nin
db.aspirants.find({
    "localitat.nomLocalitat": {
        $nin: ["MURO", "SANT RAFEL"]
    }
});

-- SORT
-- Selecciona tots els aspirants i ordena'ls alfabèticament per els llinatges i el nom
db.aspirants.find().sort({
    "llinatges": 1,
    "nom": 1
});

-- Selecciona tots els aspirants i ordena'ls alfabèticament per els nom de la localitat, llinatges i el nom
db.aspirants.find().sort({
    "localitat.nomLocalitat": 1,
    "llinatges": 1,
    "nom": 1
});

-- Mostra el nif, el nom i els llinatges de tots els aspirants ordenats per llinatges i nom.
db.aspirants.find({}, {
    "nif": 1,
    "nom": 1,
    "llinatges": 1
}).sort({
    "llinatges": 1,
    "nom": 1
});

-- Mostra tota la informació dels aspirants excepte _id ordenats per llinatges i nom.
db.aspirants.find({}, {
    "_id": 0
}).sort({
    "llinatges": 1,
    "nom": 1
});

-- Mostra el nif, el nom i els llinatges dels aspirants que tenguin alguna preferència de l'especialitat amb idCos=0590 i idEspecialitat=107 ordenats per llinatges i nom.
db.aspirants.find({
    "preferencies.especialitat.idEspecialitat": "107",
    "preferencies.especialitat.idCos": "0590"
}, {
    "nif": 1,
    "nom": 1,
    "llinatges": 1
}).sort({
    "llinatges": 1,
    "nom": 1
});

-- INSERT, UPDATE, DELETE
-- Insereix a la col·lecció AspirantsComplet un nou aspirant només amb el nif, nom i llinatges
db.aspirants.insertOne({
    "nif": "785493C",
    "nom": "Test",
    "llinatges": "Sans"
});

db.aspirants.find({
    "nif": "785493C"
});

-- Modifica el nom de l'aspirant acabat d'insertar
db.aspirants.updateOne({
    "nif": "785493C"
}, {
    $set: {
        "nom": "Marc"
    }
});

db.aspirants.find({
    "nif": "785493C"
})

-- Afegeix el camp "adresa" a l'aspirant que estam manipulant
db.aspirants.updateOne({
    "nif": "785493C"
}, {
    $set: {
        "adresa": "Carrer de la Rosa, 12"
    }
});


db.aspirants.find({
    "nif": "785493C"
});

-- Canvia el nom del camp adresa per adreça a tots el que el tenguin
db.aspirants.updateMany({}, {
    $rename: {
        "adresa": "adreça"
    }
});

db.aspirants.find({
    "nif": "785493C"
});

-- Afegeix a l'aspirant un camp telèfons amb un array amb, de moment un sol telèfon
db.aspirants.updateOne({
    "nif": "785493C"
}, {
    $set: {
        "telèfons": ["971123456"]
    }
});


db.aspirants.find({
    "nif": "785493C"
});

-- Utilitza push per afegir dos telèfons més a l'array de l'aspirant utilitzant each
db.aspirants.updateOne({
    "nif": "785493C"
}, {
    $push: {
        "telèfons": {
            $each: ["971123457", "971123458"]
        }
    }
});

db.aspirants.find({
    "nif": "785493C"
});

-- Comprova que addToSet no permet duplicats
db.aspirants.updateOne({
    "nif": "785493C"
}, {
    $addToSet: {
        "telèfons": "971123456"
    }
});

db.aspirants.find({
    "nif": "785493C"
});

-- Elimina el primer telèfon de l'array amb pop
db.aspirants.updateOne({
    "nif": "785493C"
}, {
    $pop: {
        "telèfons": -1
    }
});


db.aspirants.find({
    "nif": "785493C"
});

-- Elimina l'aspirant amb el que hem estat treballant
db.aspirants.deleteOne({
    "nif": "785493C"
});


db.aspirants.find({
    "nif": "785493C"
});

-- AGGREGATE

