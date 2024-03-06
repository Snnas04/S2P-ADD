/* **********
*   FIND    *
********** */
// 1. Selecciona tots els aspirants
db.aspirants.find()

// 2. Selectiona els aspirants de nom Bartomeu.
db.aspirants.find({nom: "Bartomeu"})

// 3. Selecciona els aspirants que siguin de la localitat CALONGE.
db.aspirants.find({
    "localitat.nomLocalitat": "CALONGE"
})

// 4. Troba l'aspirnat amb NIF 47537490F
db.aspirants.find({
    nif: "47537490F"
})

// 5. Troba els aspirnats que siguin de Calonge i nomin Bartomeu. No utilizis and.
db.aspirants.find({
    nom: "Bartomeu",
    "localitat.nomLocalitat": "CALONGE"
})

// 6. Cerce els aspirants que siguin de Calonge i nomin Bartomeu. Utilitza and.
db.aspirants.find({
    $and: [
        {nom: "Bartomeu"},
        {"localitat.nomLocalitat": "CALONGE"}
    ]
})

// 7. Cerca els aspirants que siguin de la Calone o nomin Bartomeu
db.aspirants.find({
    $or: [
        {nom: "Bartomeu"},
        {"localitat.nomLocalitat": "CALONGE"}
    ]
})

// 8. MOstra els aspirants qeu siguin de Muro o de Sant Rafel. Utilitza or.
db.aspirants.find({
    $or: [
        {"localitat.nomLocalitat": "MURO"},
        {"localitat.nomLocalitat": "SANT RAFEL"}
    ]
})

// 9. Mostra els aspirants que siguin de Muro o de Sant Rafel. Utilitza in.
db.aspirants.find({
    "localitat.nomLocalitat": {
        $in: ["MURO", "SANT RAFEL"]
    }
})

// 10. Mostra els aspirants que no siguin de Muro o de Sant Rafel. Utilitza nin,
db.aspirants.find({
    "localitat.nomLocalitat": {
        $nin: ["MURO", "SANT RAFEL"]
    }
})

/* *********
*   SORT   *
********* */
// 11. Selectiona tots esl aspirants i ordena'ls alfabeticament per els llinatges i el nom.
db.aspirants.find().sort({
    llinatges: 1,
    nom: 1
})

// 12. Selecciona tot esl aspirants i ordena'ls akfabpeticament per els nom de la localitat llinatges i el nom.
db.aspirants.find().sort({
    "localitat.nomLocalitat": 1,
    llinatges: 1,
    nom: 1
})

// 13. Mostra el nif, el nom i els llinatges de tots els aspirants ordenats per llinatges i nom.
db.aspirants.find({}, {
    nif: 1,
    nom: 1,
    llinatges: 1,
    _id: 0
}).sort({
    llinatges: 1,
    nom: 1
})

// 14. Mostra tota la informacio dels aspirants sexecpte _id ordenats per llinatges i nom.
db.aspirants.find({}, {
    _id: 0
}).sort({
    llinatges: 1,
    nom: 1
})

// 15. Mostra el nif, el nom i els llinatges dels aspirants que tenguin alguna preferència de l'especialitat amb idCos=0590 i idEspecialitat=107 ordenats per llinatges i nom.
db.aspirants.find({
    "preferencies.especialitat.idCos": "0590",
    "preferencies.especialitat.idEspecialitat": "107"
}, {
    _id: 0,
    nif: 1,
    nom: 1,
    llinatges: 1
}).sort({
    llinatges: 1,
    nom: 1
})

/* ***************************
*   INSERT, UPDATE, DELETE   *
*************************** */
// 16. Insereix a la col·leccio Aspirnats un nou aspirant nomes amb el nif, nom i llinattges.
db.aspirants.insertOne({
    nif: "12345678A",
    nom: "Test",
    llinatges: "Prova"
})

db.aspirants.find({
    nif: "12345678A"
})

// 17. Modifica el nom de l'aspirant acaat d'insertar.
db.aspirants.updateOne({nif: "12345678A"},{
    $set: {
        nom: "Recu"
    }
})

db.aspirants.find({
    nif: "12345678A"
})

// 18. Afegeix el camp "adresa" a l'aspirant que estam manipulant
db.aspirants.updateOne({nif:"12345678A"},{
    $set: {
        adreça: "Sencelles"
    }
})

db.aspirants.find({
    nif: "12345678A"
})

// 19. Canvia el nom del camp de adresa per adreça amb tots el que contengui
db.aspirants.updateMany({}, {
    $rename: {"adresa" :"adreça"}
})

// 20. Afageix un camp telefons amb un array amb, de moment un sol telefon.
db.aspirants.updateOne({nif: "12345678A"},{
    $set: {
        telèfons: ["971238743"]
    }
})

db.aspirants.find({
    nif: "12345678A"
})

// 21. Utilitza push per afegir dos telefons mes a l'array de l'asirant utilizant each
db.aspirants.updateOne({nif: "12345678A"},{
    $push: {
        telèfons: {
            $each: ["222333444", "888444999"]
        }
    }
})

db.aspirants.find({
    nif: "12345678A"
})

// 22. Comprova que addToSet no permet duplicats.
db.aspirants.updateOne({nif: "12345678A"},{
    $addToSet: {
        telèfons: {
            $each: ["222333444"]
        }
    }
})

db.aspirants.find({
    nif: "12345678A"
})

// 23. Elimina el primer telefon de l'array amb pop.
db.aspirants.updateOne({nif: "12345678A"}, {
    $pop: {
        telèfons: -1
    }
})

db.aspirants.find({
    nif: "12345678A"
})

// 24. Elimina l'aspirnat amb el que hem estat treballant
db.aspirants.deleteOne({nif: "12345678A"})

db.aspirants.find({
    nif: "12345678A"
})

/* **************
*   AGGREGATE   *
************** */

// 25. Utilitza aggregate per filtrar i mostrar els aspirants amb nom Bartomeu