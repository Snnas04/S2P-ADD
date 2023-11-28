package cat.paucasesnovescifp.spaad.proves;

import cat.paucasesnovescifp.spaad.ajudes.JPAException;
import cat.paucasesnovescifp.spaad.ajudes.JPAUtiles;
import cat.paucasesnovescifp.spaad.model.Aspirant;
import cat.paucasesnovescifp.spaad.model.Centre;
import cat.paucasesnovescifp.spaad.model.Cos;
import cat.paucasesnovescifp.spaad.model.Localitat;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
        EntityManager em = JPAUtiles.getEntityManager();
        Centre center = em.find(Centre.class, idCentre);
        em.close();
        return center;
    }

    public Aspirant modificaAdrecaAspirant(String nif, String adreca) {
        EntityManager em = JPAUtiles.getEntityManager();
        em.getTransaction().begin();
        Aspirant aspirant = em.find(Aspirant.class, nif);
        aspirant.setAdreca(adreca);
        em.getTransaction().commit();
        em.close();
        return aspirant;
    }

    public Centre actualitzaCentre(Centre centre) {
        EntityManager em = JPAUtiles.getEntityManager();
        em.getTransaction().begin();
        em.merge(centre);
        em.getTransaction().commit();
        em.close();
        return centre;
    }

    public Centre creaCentre(String idCentre, String nomCentre, String idLocalitat) {
        EntityManager em = JPAUtiles.getEntityManager();
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
        EntityManager em = JPAUtiles.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(object));
        em.getTransaction().commit();
        em.close();
        return object;
    }

    public void tornaCossos() {
        EntityManager em = JPAUtiles.getEntityManager();
        Query query = em.createQuery("SELECT c FROM Cos c");
        Cos cossos = (Cos) query.getResultList();
        em.close();
        System.out.println("cossos = " + cossos);
    }

    // Repeteix el mètode anterior utilitzant una Named Query (@NamedQuery(parametres),createNamedQuery)

    public void tornaCossos2() {
        EntityManager em = JPAUtiles.getEntityManager();
        Query query = em.createNamedQuery("Cos.findAll");
        Cos cossos = (Cos) query.getResultList();
        em.close();
        System.out.println("cossos = " + cossos);
    }

    // tornaCentresLocalitat(Localitat localitat): crea una consulta dinàmica que torni totes les localitats d'una illa determinada. (createQuery, setParameter, getResultList)
    public void tornaCentresLocalitat(Localitat localitat) {
        EntityManager em = JPAUtiles.getEntityManager();
        Query query = em.createQuery("SELECT c FROM Centre c WHERE c.localitat = :localitat");
        query.setParameter("localitat", localitat);
        Centre centres = (Centre) query.getResultList();
        em.close();
        System.out.println("centres = " + centres);
    }
}
