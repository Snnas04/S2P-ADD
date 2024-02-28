// 1
db.llibres.find().skip(49).limit(69);

// 2
db.llibres.find({}, {
    "titol": 1,
    "isbn": 1,
    "departament": 1
}).sort({
    "departament": 1
});

// 3
db.llibres.find({}, {
    "titol": 1,
    "autors.nomAut": "LLULL, RAMON"
}).sort({
    "titol": 1
});

// 4
db.llibres.insertOne({
    "isbn": "111111111",
    "titol": "Examen"
});

db.llibres.find({
    "isbn": "111111111"
})

// 5
db.llibres.updateOne({
    "isbn": "111111111"
}, {
    $set: {
        "titol": "ExamenMOD"
    }
});

db.llibres.find({
    "isbn": "111111111"
})

// 6
db.llibres.updateOne({
    "isbn": "111111111"
}, {
    $set: {
        "departament": "AAD",
        "autors.idAut": "11111111",
        "autors.nomAut": "Marc",
        "autors.idAut": "22222222",
        "autors.nomAut": "Alicia",
    }
});

db.llibres.find({
    "isbn": "111111111"
})

// 7
db.llibres.deleteOne({
    "isbn": "111111111"
});

// 8

// 9
