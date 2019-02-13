package by.flathumor.repository;

import by.flathumor.entity.UserSession;

import javax.ejb.Stateless;

@Stateless
public class UserSessionRepository extends AUserSession<UserSession>
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
}
