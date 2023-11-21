package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("default");

    public static EntityManager getEntityManagerFactory() {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }
}
