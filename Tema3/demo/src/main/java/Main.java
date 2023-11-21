import entities.Rider;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
//            Rider rider = new Rider();
//            rider.setDorsal(300);
//            rider.setName("Pepito");
//            rider.setCountry("Spain");
//
//            transaction.begin();
//            em.persist(rider);
//            transaction.commit();

            TypedQuery<Rider> query = em.createQuery("FROM Rider", Rider.class);

            for (Rider r : query.getResultList()) {
                System.out.println(r);
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}
