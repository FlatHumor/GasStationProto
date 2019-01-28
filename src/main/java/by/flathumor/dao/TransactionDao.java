package by.flathumor.dao;

import by.flathumor.model.Transaction;
import by.flathumor.repository.HibernateSessionFactoryUtil;
import org.hibernate.Session;

public class TransactionDao implements Dao<Transaction>
{
    public Transaction findById(long id) {
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(Transaction.class, id);
    }

    public void save(Transaction transaction) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        org.hibernate.Transaction hTransaction = session.beginTransaction();
        session.save(transaction);
        hTransaction.commit();
        session.close();
    }

    public void update(Transaction transaction) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        org.hibernate.Transaction hTransaction = session.beginTransaction();
        session.update(transaction);
        hTransaction.commit();
        session.close();
    }

    public void delete(Transaction transaction) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        org.hibernate.Transaction hTransaction = session.beginTransaction();
        session.delete(transaction);
        hTransaction.commit();
        session.close();
    }
}