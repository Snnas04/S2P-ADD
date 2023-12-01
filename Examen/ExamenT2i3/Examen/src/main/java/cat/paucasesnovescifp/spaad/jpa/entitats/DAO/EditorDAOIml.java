package cat.paucasesnovescifp.spaad.jpa.entitats.DAO;

import cat.paucasesnovescifp.spaad.jpa.entitats.Editor;
import cat.paucasesnovescifp.spaad.jpa.entitats.Util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class EditorDAOIml implements EditorDAO {

    @Override
    public List<Editor> findAll() {
        EntityManager em = JPAUtil.getEntityManager();

        List<Editor> editors = em.createQuery("select e from Editor e", Editor.class).getResultList();

        em.close();

        return editors;
    }
}
