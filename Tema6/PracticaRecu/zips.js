/* ****************************************************************************************************************
*   https://docs.google.com/document/d/13ur_Zen5qnZoHHLdGqd1Al6Q3W3dKqny2555zTUf5Ww/edit#heading=h.382jcjdlgihq   *
**************************************************************************************************************** */

// 1. Mostra el nombre dâ€™estats.
db.zips.distinct("state").length // 51

db.zips.aggregate([
    {$group: {_id: "$state"}},
    {$count: "numEstats"}
])

// 2. Mostra la poblaciÃ³ total de cada estat.
db.zips.aggregate([
    {$group: {_id: "$state",poblacio: {$sum: "$pop"}}}
])

// 3. Mostra el nombre de ciutats agrupades per estat.
db.zips.find().sort({state:1,city:1})

db.zips.aggregate([
    {$group: {_id: {estat: "$state", ciutat: "$city"}}},
    {$group: {_id: "$_id.estat",numCiutats: {$count: {}}}}
])

db.zips.aggregate([
    {$group: {_id: {estat: "$state", ciutat: "$city"}}},
    {$group: {_id: "$_id.estat",numCiutats: {$sum: 1}}}
])

// 4. Mostra per cada estat, el conjunt de ciutats que es troben en aquest estat.
db.zips.aggregate([
    {$group: {_id: "$state", ciutats: {$addToSet: "$city"}}},
])


// 5. Mostra el nombre de codis postals per cada ciutat de cada estat.
db.zips.aggregate([
    {$group: {_id: {estat: "$state",ciutat:"$city"},numZips: {$count: {}}}},
    {$sort: {numZips:-1}}
])

// 6. Mostra el nom de la ciutat mÃ©s poblada d'Alabama.
db.zips.aggregate([
    {$match: {state:"AL"}},
    {$group: {_id: "$city",poblacio: {$sum: "$pop"}}},
    {$sort: {poblacio:-1}},
    {$limit: 1}
])

// 7. Mostra el nombre de ciutats de Washington (WA) situades al nord del paral·lel 46.
db.zips.aggregate([
    {$match: {state:"WA","loc.1":{$gt: 46}}},
    {$group: {_id:"$city"}},
    {$count: "numCiutats"}
])

// 8. Mostra el nom i la poblacio de la ciutat mÃ©s poblada de cada estat.
db.zips.aggregate([
    {$group: {_id: {estat: "$state",ciutat: "$city"},poblacio:{$sum: "$pop"}}},
    {$sort: {"_id.estat":1,poblacio:-1}},
    {$group: {_id: "$_id.estat",ciutat: {$first:"$_id.ciutat"},pobla: {$first: "$poblacio"}}},
    {$sort: {pobla:-1}}
])