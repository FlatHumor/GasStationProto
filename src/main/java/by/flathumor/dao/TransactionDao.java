package by.flathumor.dao;

import by.flathumor.entity.Transaction;
import by.flathumor.repository.EntityManagerUtil;

import javax.persistence.EntityManager;
import java.util.function.Consumer;

public class TransactionDao extends ATransaction<Transaction, EntityManager>
{
    public TransactionDao() {
        this.manager = EntityManagerUtil.getEntityManager();
    }

    @Override
    public Transaction findById(Long id) {
        return manager.find(Transaction.class, id);
    }

    @Override
    public void save(Transaction transaction) {
        executeTransaction(manager::persist);
    }

    @Override
    public void update(Transaction transaction) {
        executeTransaction(manager::merge);
    }

    @Override
    public void delete(Transaction transaction) {
        executeTransaction(manager::remove);
    }

    @Override
    public void executeTransaction(Consumer<EntityManager> action)
    {
        try {
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
