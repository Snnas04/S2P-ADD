// 1
db.movie.aggregate([
    {$group: {_id: "$type"}}
])

// 2
db.movie.aggregate([
    { $match:         {
            $and: [
                {type: "movie"},
                {"imdb.rating": {$gte: 9}}
            ]
        }
    }
])

// 3 -
// l'he fet de dues maneres i no se molt be perque no me mostra el runtime
db.movie.aggregate([
    {
        $project: {_id: 0, title: 1, runtime: 1, type: 1}
    },
    {
        $sort: {runtime: 1}
    }
])

db.movie.find({}, {
    _id: 0,
    title: 1,
    runtime: 1,
    type: 1
}).sort({
    runtime: 1,
})

// 4
db.movie.insertOne({
    _id: 1,
    title: "Recuperacio Mongo DB",
    runtime: 120
})

db.movie.find({
    _id: 1
})

// 5
db.movie.updateOne({_id: 1},{
    $set: {
        cast: ["Marc Sans", "Andreu Pons"]
    }
})

db.movie.find({
    _id: 1
})

// 6
db.movie.updateOne({_id: 1},{
    $addToSet: {
        cast: "Alicia"
    }
})

db.movie.find({
    _id: 1
})

// 7
db.movie.find().projection({runtime: 1})
db.movie.deleteMany({runtime: 1})
db.movie.find().projection({runtime: 1})

// 8
db.movie.aggregate([
    { $match: {type: "movie"} },
    { $match: {cast: null} }
])

// 9 -
db.movie.find({
    "imdb.rating": {$nin: [null, ""]}
}).sort({
    "imdb.votes": -1
}).limit(100)

// 10 -
db.movie.aggregate([
    { $match: {type: "movie"} },
    { $match: {year: 2000} },
    { $group: {_id: "$year",numYear: {$sum: 1}} },
])

// per qualque motiu no me funciona amb aquest match, nomes puc mostrar un any
// {
//     $match: {
//         $and: [
//             {year: 1990},
//             {year: 2000}
//         ]
//     }
// },