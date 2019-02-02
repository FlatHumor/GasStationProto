package by.flathumor.dao;

import by.flathumor.entity.User;
import by.flathumor.repository.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.function.Consumer;

public class UserDao extends AUser<User, EntityManager>
{
    public UserDao() {
        this.manager = EntityManagerUtil.getEntityManager();
    }

    @Override
    public User findById(Long id) {
        return manager.find(User.class, id);
    }

    @Override
    public User findByUsername(String username)
    {
        EntityManager manager = EntityManagerUtil.getEntityManager();
        Query query = manager.createNamedQuery("User.findByUsername", User.class);
        query.setParameter("username", username);
        return (User)query.getSingleResult();
    }

    @Override
    public void save(User user) {
        executeTransaction(manager::persist);
    }

    @Override
    public void update(User user) {
        executeTransaction(manager::merge);
    }

    @Override
    public void delete(User user) {
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
