package by.flathumor.dao;

import by.flathumor.enity.UserSession;
import by.flathumor.repository.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserSessionDao implements IUserSessionDao<UserSession, Long>
{
    public UserSession findById(Long id) {
        return getSession().get(UserSession.class, id);
    }

    private Session getSession() {
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
    }

    public void save(UserSession userSession)
    {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.save(userSession);
        transaction.commit();
        session.close();
    }

    public void update(UserSession userSession)
    {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.update(userSession);
        transaction.commit();
        session.close();
    }

    public void delete(UserSession userSession)
    {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(userSession);
        transaction.commit();
        session.close();
    }
}
