package cat.paucasesnovescifp.spaad.DAO;

import cat.paucasesnovescifp.spaad.model.Aspirant;
import cat.paucasesnovescifp.spaad.ajudes.JPAUtiles;

import javax.persistence.EntityManager;

public class GenericDAOImp implements GenericDAO {
    @Override
    public void getAspirant(String nif) {
        EntityManager em = JPAUtiles.getEntityManager();
        Aspirant aspirant = em.find(Aspirant.class, nif);
        em.close();

        System.out.println(aspirant);;
    }

    @Override
    public void modifyAspirant(String nif, String llinatges) {
        EntityManager em = JPAUtiles.getEntityManager();
        em.getTransaction().begin();
        Aspirant aspirant = em.find(Aspirant.class, nif);
        aspirant.setLlinatges(llinatges);
        em.getTransaction().commit();
        em.close();

        System.out.println("S'han modificat els lliantges a \"" + aspirant.getLlinatges() + "\"");
    }

    @Override
    public void updateAspirant(Aspirant aspirant) {
        EntityManager em = JPAUtiles.getEntityManager();
        em.getTransaction().begin();
        em.merge(aspirant);
        em.getTransaction().commit();
        em.close();

        System.out.println("S'ha actualitzat l'aspirant: \n" + aspirant);
    }

    @Override
    public void createAspirant(Aspirant aspirant) {
        EntityManager em = JPAUtiles.getEntityManager();
        em.getTransaction().begin();
        em.persist(aspirant);
        em.getTransaction().commit();
        em.close();

        System.out.println("S'ha creat l'aspirant: \n" + aspirant);
    }

    @Override
    public void createObject(Object object) {
        EntityManager em = JPAUtiles.getEntityManager();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        em.close();

        System.out.println("S'ha creat l'objecte: \n" + object);
    }

    @Override
    public void updateObject(Object object) {
        EntityManager em = JPAUtiles.getEntityManager();
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
        em.close();

        System.out.println("S'ha actualitzat l'objecte: \n" + object);
    }

    @Override
    public void deleteObject(Object object) {

    }
}
