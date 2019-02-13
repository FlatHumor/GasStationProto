package by.flathumor.repository;

import by.flathumor.entity.Transaction;

import javax.ejb.Stateless;

@Stateless
public class TransactionRepository extends ATransaction<Transaction>
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
}
