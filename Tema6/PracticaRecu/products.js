/* ****************************************************************************************************************
*   https://docs.google.com/document/d/13ur_Zen5qnZoHHLdGqd1Al6Q3W3dKqny2555zTUf5Ww/edit#heading=h.382jcjdlgihq   *
**************************************************************************************************************** */

db.products.find()

// 1. Afegeix un document amb les dades del teu telefon mobil.
db.products.insertOne({
    available: false,
    color: "blue",
    price: 850,
    brand: "Apple",
    name: "iPhone 13",
    type: "phone"
})

// 2. Mostrar els documents corresponents a productes amb un preu de 200
db.products.aggregate([
    { $match: {price: 200} },
    { $project: {
        _id: 0,
        name: 1,
        price: 1,
    }}
])

// 3. Mostrar els productes del tipus "case" que tenguin un color verd i un preu de 10 a 15
db.products.aggregate([
    { $match:
        {
            $and: [
                {type: "case"},
                {color: "green"},
                {price: { $gte: 10, $lte: 15 }}
            ]
        }
    },
    { $project: {
        _id: 0,
        name: 1,
        type: 1,
        color: 1,
        price: 1,
    }}
])

// 4. Mostrar el nombre de productes de preu menor o igual que 15
db.products.aggregate([
    { $match: {price: {$lte: 15}}}
])

// 5. Mostra el nom i preu dels productes amb un tipus de telefon
db.products.aggregate([
    { $match: {type: "phone"} },
    { $project: { _id: 0, name: 1, price: 1 } }
])

// 6. Mostra les dades dels carregadors que serveixen perl telefon "AC3"
db.products.aggregate([
    { $match: {type: "limits.data", name: "AC3"} } // No se on esta la informacio del carregador
])

// 7. Mostra les tarifes que permeten un trpafic de dades il·limitat
// NO FUNCIONA
db.products.aggregate([
    { $match: {
        $and: [
            {type: "service"},
            {"limits.data": "unlimited"}
        ]
    } }
])

// 8. Mostra el nom i preu dels dos telefons mes cars
db.products.aggregate([
    { $match: {type: "phone"} },
    { $project: {_id: 0, name: 1, price: 1} },
    { $sort: {price: -1} },
    { $limit: 2 }
])

// 9. Mostra els productes que serveixen per almenys 3 preoductes diferents
db.products.aggregate([
    { $group: {
        _id: "$type",
        count: { $sum: 1 }
    } },
    { $match: {count: {$gte: 3}} }
])