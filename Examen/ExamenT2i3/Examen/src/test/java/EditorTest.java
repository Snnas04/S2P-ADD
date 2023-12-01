import cat.paucasesnovescifp.spaad.jpa.entitats.DAO.EditorDAO;
import cat.paucasesnovescifp.spaad.jpa.entitats.DAO.EditorDAOIml;
import cat.paucasesnovescifp.spaad.jpa.entitats.Editor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditorTest {
    EditorDAO dao;

    @BeforeEach
    void setUp() {
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        dao = new EditorDAOIml();
    }

    @Test
    void findEditor() {
        List<Editor> editors = dao.findAll();

        System.out.println(editors);
    }
}
