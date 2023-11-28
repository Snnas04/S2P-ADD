package cat.paucasesnovescifp.spaad;

import cat.paucasesnovescifp.spaad.ajudes.JPAException;
import cat.paucasesnovescifp.spaad.model.Centre;
import cat.paucasesnovescifp.spaad.model.Especialitat;
import cat.paucasesnovescifp.spaad.model.EspecialitatPK;
import cat.paucasesnovescifp.spaad.model.Illa;
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
        ProvesEsborra();
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
