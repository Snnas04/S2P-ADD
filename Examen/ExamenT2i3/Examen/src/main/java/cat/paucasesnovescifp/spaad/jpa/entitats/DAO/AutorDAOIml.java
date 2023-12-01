package cat.paucasesnovescifp.spaad.jpa.entitats.DAO;

import cat.paucasesnovescifp.spaad.jpa.entitats.Autor;
import cat.paucasesnovescifp.spaad.jpa.entitats.Util.JPAUtil;

import javax.persistence.EntityManager;

public class AutorDAOIml implements AutorDAO {
    @Override
    public void findByID(int idAutor) {
        EntityManager em = JPAUtil.getEntityManager();

        Autor autor = em.find(Autor.class, idAutor);

        em.close();

        System.out.println(autor);
    }
}
