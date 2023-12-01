CREATE PROCEDURE countCentresIlla(IN illa INT, OUT total INT)
BEGIN
    DECLARE totalCentres INT;

    SELECT count(*) into totalCentres FROM Centres C
    Join Localitats L on C.idLocalitat = L.idLocalitat
    join Illes I on L.idIlla = I.idIlla
    where I.idIlla = illa;

    SET total = totalCentres;
END;
