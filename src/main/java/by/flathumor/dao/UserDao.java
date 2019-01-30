package by.flathumor.dao;

import by.flathumor.enity.User;
import by.flathumor.repository.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;

public class UserDao implements IUserDao<User, Long>
{
    public User findById(Long id) {
        return getSession().get(User.class, id);
    }

    public User findByUsername(String username)
    {
        Session session = getSession();
        Query query = session.createQuery("FROM User U WHERE U.username =: username");
        query.setParameter("username", username);
        return (User) query.getSingleResult();
    }

    private Session getSession() {
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
    }

    public void save(User user)
    {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void update(User user)
    {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public void delete(User user)
    {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }
}
