import cat.paucasesnovescifp.spaad.jpa.entitats.Autor;
import cat.paucasesnovescifp.spaad.jpa.entitats.DAO.AutorDAO;
import cat.paucasesnovescifp.spaad.jpa.entitats.DAO.AutorDAOIml;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AutorTest {
    AutorDAO autor;

    @BeforeEach
    void setUp() {
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        autor = new AutorDAOIml();
    }

    @Test
    void findAutorByID() {
        autor.findByID(1);
    }
}
