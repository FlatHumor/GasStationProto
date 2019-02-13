package by.flathumor.datasource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil
{
    private static final EntityManagerFactory factory;
    private static final String PERSISTENCE_UNIT_NAME = "user-unit";

    static {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
