// comptar quants de departaments hi ha de cada tipus i ordernar de foram descencent
db.llibres.aggregate([
    {$group: {_id: "$departament",numDepartaments: {$sum: 1}}},
    {$sort: {numDepartaments: -1}}
])

// comptar quants de departaments hi ha
db.llibres.aggregate([
    { $group: {_id: "$departament"} },
    { $count: "numDepartaments" }
])

// mostrar entre dos numeros incolosos
db.llibres.find({_id: {$gte: 50, $lte: 120}})

// entre dos numeros exclusos
db.llibres.find({_id: {$gt: 50, $lt: 120}})

// afegir dos autors a un llibre
db.llibres.updateOne({
    "isbn": "84-01-3811"
}, {
    $push: {
        "autors": {
            "idAut": 3,
            "nomAut": "Marc, Sans"
        },
        "autors": {
            "idAut": 4,
            "nomAut": "Pere, Sans"
        }
    }
});

// mirar si un llibre te un autor
db.llibres.find({
    "isbn": "84-01-3811"
}, {
    "isbn": 1,
    "autors.idAut": 1,
    "autors.nomAut": 1
});