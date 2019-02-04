package by.flathumor.dao;

import by.flathumor.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
        Query query = manager.createNamedQuery("User.findByUsername", User.class);
//        Query query = manager.createQuery("select u from User u where u.username = :username");
        query.setParameter("username", username);
        return (User)query.getSingleResult();
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
