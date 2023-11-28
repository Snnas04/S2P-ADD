package cat.paucasesnovescifp.spaad;

import cat.paucasesnovescifp.spaad.DAO.GenericDAOImp;
import cat.paucasesnovescifp.spaad.ajudes.JPAException;
import cat.paucasesnovescifp.spaad.ajudes.JPAUtiles;
import cat.paucasesnovescifp.spaad.model.*;
import cat.paucasesnovescifp.spaad.proves.ProvesJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
//        testProject();
//        ProvesCentre();
//        ProvesAdreca();
//        ProvesActualitzaCentre();
//        ProvesCreaCentre();
//        ProvesEsborra();
//        ProvesCreaCos();
//        ProvesCreaAspirant();
//        ProvesCreaCentre();
//        ProvesTornarAspirant();
//        ProvesModificaAspirant();
//        ProvesActualitzaAspirant();
//        ProvesCrearAspirant();
        ProvesCrearObjecte();
    }

    private static void ProvesCrearObjecte() {
        GenericDAOImp genericDAOImp = new GenericDAOImp();
        EntityManager em = JPAUtiles.getEntityManager();
        Cos cos = new Cos();
        cos.setIdCos("0600");
        cos.setDescripcio("Test");
        genericDAOImp.createObject(cos);
    }

    private static void ProvesCrearAspirant() {
        GenericDAOImp genericDAOImp = new GenericDAOImp();
        EntityManager em = JPAUtiles.getEntityManager();
        Aspirant aspirant = new Aspirant();
        aspirant.setNif("92324324F");
        aspirant.setNom("Test");
        aspirant.setLlinatges("Test");
        aspirant.setAdreca("Test");
        aspirant.setCodiPostal("Test");
        aspirant.setLocalitat(em.find(Localitat.class, "070470005"));
        genericDAOImp.createAspirant(aspirant);
    }

    private static void ProvesActualitzaAspirant() {
        GenericDAOImp genericDAOImp = new GenericDAOImp();
        EntityManager em = JPAUtiles.getEntityManager();
        Aspirant aspirant = new Aspirant();
        aspirant.setNif("12007493F");
        aspirant.setNom("Test");
        aspirant.setLlinatges("Test");
        aspirant.setAdreca("Test");
        aspirant.setCodiPostal("Test");
        aspirant.setLocalitat(em.find(Localitat.class, "070470005"));
        genericDAOImp.updateAspirant(aspirant);
    }

    private static void ProvesModificaAspirant() {
        GenericDAOImp genericDAOImp = new GenericDAOImp();
        genericDAOImp.modifyAspirant("12007493F", "Test Modificat");
    }

    private static void ProvesTornarAspirant() {
        GenericDAOImp genericDAOImp = new GenericDAOImp();
        genericDAOImp.getAspirant("12007493F");
    }

    private static void ProvesEsborra() {

        try {
            ProvesJPA provesJPA = new ProvesJPA("interins-pu");
            Centre centre = provesJPA.tornaCentre("08000022");
            provesJPA.esborra(centre);
        } catch (JPAException e) {
            System.out.println(e);
        }
    }

    private static void ProvesCreaCentre() {
        try {
            ProvesJPA provesJPA = new ProvesJPA("interins-pu");
            provesJPA.creaCentre("08000022", "IES INCA", "070470005");
        } catch (JPAException e) {
            System.out.println(e);
        }
    }

    private static void ProvesActualitzaCentre() {
        try {
            ProvesJPA provesJPA = new ProvesJPA("interins-pu");
            Centre centre = provesJPA.tornaCentre("07000081");
            centre.setNomCentre("CIFP PAU CASESNOVES");
            provesJPA.actualitzaCentre(centre);
        } catch (JPAException e) {
            System.out.println(e);
        }
    }

    private static void ProvesAdreca() {
        try {
            ProvesJPA provesJPA = new ProvesJPA("interins-pu");
            provesJPA.modificaAdrecaAspirant("12007493F", "Càrritx 5");
        } catch (JPAException e) {
            System.out.println(e);
        }
    }

    private static void ProvesCentre() {
        try {
            ProvesJPA provesJPA = new ProvesJPA("interins-pu");
            Centre centre = provesJPA.tornaCentre("07000030");
            System.out.println("centre = " + centre);

        } catch (JPAException e) {
            System.out.println(e);
        }

    }

    private static void testProject() {
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("interins-pu");
        EntityManager em = emf.createEntityManager();
        Illa mallorca=em.find(Illa.class,"071");
        System.out.println("mallorca = " + mallorca);
        Especialitat informatica=em.find(Especialitat.class,new EspecialitatPK("0590","107"));
        System.out.println("informatica = " + informatica);
        em.close();
        emf.close();
    }
}
