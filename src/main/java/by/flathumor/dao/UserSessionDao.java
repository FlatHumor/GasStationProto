package by.flathumor.dao;

import by.flathumor.entity.UserSession;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import java.util.function.Consumer;

@Stateless
public class UserSessionDao extends AUserSession<UserSession>
{
    @Override
    public UserSession findById(Long id) {
        return manager.find(UserSession.class, id);
    }

    @Override
    public void save(UserSession userSession) {
        executeTransaction(manager->manager.persist(userSession));
    }

    @Override
    public void update(UserSession userSession) {
        executeTransaction(manager->manager.merge(userSession));
    }

    @Override
    public void delete(UserSession userSession) {
        executeTransaction(manager->manager.remove(userSession));
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
