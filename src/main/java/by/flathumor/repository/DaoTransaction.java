package by.flathumor.repository;

import by.flathumor.datasource.EntityManagerUtil;

import javax.persistence.EntityManager;
import java.util.function.Consumer;

public class DaoTransaction
{
    protected EntityManager manager = EntityManagerUtil.getEntityManager();

    protected void executeTransaction(Consumer<EntityManager> action)
    {
        try
        {
            manager.getTransaction().begin();
            action.accept(manager);
            manager.getTransaction().commit();
        }
        catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        }
    }
}
