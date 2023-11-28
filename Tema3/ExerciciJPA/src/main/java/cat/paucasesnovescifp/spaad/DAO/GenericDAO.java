package cat.paucasesnovescifp.spaad.DAO;

import cat.paucasesnovescifp.spaad.model.Aspirant;

public interface GenericDAO {
    void getAspirant(String nif);
    void modifyAspirant(String nif, String llinatges);

    void updateAspirant(Aspirant aspirant);
    void createAspirant(Aspirant aspirant);

    void createObject(Object object);
    void updateObject(Object object);
    void deleteObject(Object object);
}
