package by.flathumor.dao;

import by.flathumor.entity.Transaction;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import java.util.function.Consumer;

@Stateless
public class TransactionDao extends ATransaction<Transaction>
{
    @Override
    public Transaction findById(Long id) {
        return manager.find(Transaction.class, id);
    }

    @Override
    public void save(Transaction transaction) {
        executeTransaction(manager->manager.persist(transaction));
    }

    @Override
    public void update(Transaction transaction) {
        executeTransaction(manager->manager.merge(transaction));
    }

    @Override
    public void delete(Transaction transaction) {
        executeTransaction(manager->manager.remove(transaction));
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
