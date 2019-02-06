package by.flathumor.dao;

import by.flathumor.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.function.Consumer;

public class UserDao extends AUser<User>
{
    @Override
    public User findById(Long id) {
        return manager.find(User.class, id);
    }

    @Override
    public User findByUsername(String username)
    {
        TypedQuery<User> query = manager.createNamedQuery("User.findByUsername", User.class);
        query.setParameter("username", username);
        try {
            return (User)query.getSingleResult();
        }
        catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public User findByIdentificator(String identificator)
    {
        TypedQuery<User> query = manager.createNamedQuery("User.findByIdent", User.class);
        query.setParameter("ident", identificator);
        try {
            return query.getSingleResult();
        }
        catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(User user) {
        executeTransaction(manager->manager.persist(user));
    }

    @Override
    public void update(User user) {
        executeTransaction(manager->manager.merge(user));
    }

    @Override
    public void delete(User user) {
        executeTransaction(manager->manager.remove(user));
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
