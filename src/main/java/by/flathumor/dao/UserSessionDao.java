package by.flathumor.dao;

import by.flathumor.model.UserSession;
import by.flathumor.repository.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserSessionDao implements Dao<UserSession>
{
    public UserSession findById(long id) {
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(UserSession.class, id);
    }

    public void save(UserSession userSession) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(userSession);
        transaction.commit();
        session.close();
    }

    public void update(UserSession userSession) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(userSession);
        transaction.commit();
        session.close();
    }

    public void delete(UserSession userSession) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(userSession);
        transaction.commit();
        session.close();
    }
}
