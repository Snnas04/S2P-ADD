package cat.paucasesnovescifp.spaad.dao;

import cat.paucasesnovescifp.spaad.auxiliars.JPAUtiles;
import cat.paucasesnovescifp.spaad.jpa.entitats.Language;

import javax.persistence.EntityManager;

public class LanguageDAOIplm implements LanguageDAO {

    @Override
    public boolean deleteById(int id) {
        EntityManager em = JPAUtiles.getEntityManager();

        try {
            em.getTransaction().begin();
            Language language = em.find(Language.class, id);
            Language merged = em.merge(language);
            em.remove(merged);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }

        return true;
    }
}
