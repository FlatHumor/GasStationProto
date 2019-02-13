package by.flathumor.repository;

import by.flathumor.entity.UserSession;

public abstract class AUserSession<T extends UserSession>
        extends DaoTransaction implements Repository<T>
{
    public abstract T findById(Long id);
    public abstract void save(T object);
    public abstract void update(T object);
    public abstract void delete(T object);
}
