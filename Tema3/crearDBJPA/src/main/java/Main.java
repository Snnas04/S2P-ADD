import Entitats.Curs;
import Entitats.Estudiant;
import Entitats.Professor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            // Inserir registres a la taula Estudiant
            Curs curs1 = new Curs();
            curs1.setNomCurs("Matemàtiques");

            Curs curs2 = new Curs();
            curs2.setNomCurs("Física");

            em.persist(curs1);
            em.persist(curs2);

            Estudiant estudiant1 = new Estudiant();
            estudiant1.setNom("Anna");
            estudiant1.setCurs(curs1);

            Estudiant estudiant2 = new Estudiant();
            estudiant2.setNom("David");
            estudiant2.setCurs(curs1);

            Estudiant estudiant3 = new Estudiant();
            estudiant3.setNom("Laura");
            estudiant3.setCurs(curs2);

            em.persist(estudiant1);
            em.persist(estudiant2);
            em.persist(estudiant3);

            // Inserir registres a la taula Professor
            Professor professor1 = new Professor();
            professor1.setNom("Dr. Smith");
            professor1.setCursos(Arrays.asList(curs1, curs2));

            Professor professor2 = new Professor();
            professor2.setNom("Dra. Johnson");
            professor2.setCursos(Arrays.asList(curs1));

            em.persist(professor1);
            em.persist(professor2);

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
