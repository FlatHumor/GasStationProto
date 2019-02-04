package by.flathumor.dao;

import by.flathumor.entity.UserSession;
import by.flathumor.repository.EntityManagerUtil;

import javax.persistence.EntityManager;
import java.util.function.Consumer;

public abstract class AUserSession<T extends UserSession> implements Dao<T>
{
    protected EntityManager manager = EntityManagerUtil.getEntityManager();

    public abstract T findById(Long id);
    public abstract void save(T object);
    public abstract void update(T object);
    public abstract void delete(T object);
    public abstract void executeTransaction(Consumer<EntityManager> action);
}
