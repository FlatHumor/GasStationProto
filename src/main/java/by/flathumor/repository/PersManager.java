package by.flathumor.repository;

import by.flathumor.model.User;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class PersManager
{
    @PersistenceContext
    private EntityManager manager;

    public void persist(User user) {
        manager.persist(user);
    }
}
