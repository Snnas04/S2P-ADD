-- Crear una base de datos
db.coses.insertOne({"nom":"Marc","cognom":"Sasns"});
db.coses.insertMany([{"nom":"Andreu","cognom":"Garcia"},{"nom":"Joan","cognom":"Sanchez"}]);
db.coses.find();
db.coses.countDocuments();
db.coses.updateOne({nom:"Marc"},{$set:{cognom:"Sans"}});
db.coses.find();
db.coses.replaceOne({nom:"Joan"},{name:"John",cognom:"Sanchez"});
db.coses.find();
