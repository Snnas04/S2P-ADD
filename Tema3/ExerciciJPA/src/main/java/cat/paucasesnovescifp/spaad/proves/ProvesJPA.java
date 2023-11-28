package cat.paucasesnovescifp.spaad.proves;

import cat.paucasesnovescifp.spaad.ajudes.JPAException;
import cat.paucasesnovescifp.spaad.ajudes.JPAUtiles;
import cat.paucasesnovescifp.spaad.model.Aspirant;
import cat.paucasesnovescifp.spaad.model.Centre;
import cat.paucasesnovescifp.spaad.model.Localitat;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ProvesJPA {
    private String unitatPersistencia;

    public ProvesJPA(String unitatPersistencia) throws JPAException {
        if (unitatPersistencia == null || unitatPersistencia.isEmpty()) {
            throw new JPAException("La unitat de persistència no pot ser null");
        }
    }

    public String getUnitatPersistencia() {
        return unitatPersistencia;
    }

    public Centre tornaCentre(String idCentre) {
        EntityManager em = JPAUtiles.getEntityManagerFactory();
        Centre center = em.find(Centre.class, idCentre);
        em.close();
        return center;
    }

    public Aspirant modificaAdrecaAspirant(String nif, String adreca) {
        EntityManager em = JPAUtiles.getEntityManagerFactory();
        em.getTransaction().begin();
        Aspirant aspirant = em.find(Aspirant.class, nif);
        aspirant.setAdreca(adreca);
        em.getTransaction().commit();
        em.close();
        return aspirant;
    }

    public Centre actualitzaCentre(Centre centre) {
        EntityManager em = JPAUtiles.getEntityManagerFactory();
        em.getTransaction().begin();
        em.merge(centre);
        em.getTransaction().commit();
        em.close();
        return centre;
    }

    public Centre creaCentre(String idCentre, String nomCentre, String idLocalitat) {
        EntityManager em = JPAUtiles.getEntityManagerFactory();
        Centre centre = new Centre();
        centre.setIdCentre(idCentre);
        centre.setNomCentre(nomCentre);
        centre.setLocalitat(em.find(Localitat.class, idLocalitat));
        em.getTransaction().begin();
        em.persist(centre);
        em.getTransaction().commit();
        em.close();
        return centre;
    }

    public Object esborra(Object object) {
        EntityManager em = JPAUtiles.getEntityManagerFactory();
        em.getTransaction().begin();
        em.remove(em.merge(object));
        em.getTransaction().commit();
        em.close();
        return object;
    }
}
