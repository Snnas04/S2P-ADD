package cat.paucasesnovescifp.spaad.dao;

import cat.paucasesnovescifp.spaad.auxiliars.JPAUtiles;
import cat.paucasesnovescifp.spaad.jpa.entitats.Category;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategoryDAOIplm implements CategoryDAO {

    @Override
    public List<Category> findAll() {
        EntityManager em = JPAUtiles.getEntityManager();

        TypedQuery<Category> query = em.createQuery("select c from Category c", Category.class);
        List<Category> categories = query.getResultList();

        em.close();

        return categories;
    }
}
