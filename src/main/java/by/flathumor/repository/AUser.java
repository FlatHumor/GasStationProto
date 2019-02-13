package by.flathumor.repository;

import by.flathumor.entity.User;

public abstract class AUser<T extends User>
        extends DaoTransaction implements Repository<T>
{
    public abstract T findById(Long id);
    public abstract T findByUsername(String username);
    public abstract T findByIdentificator(String identificator);
    public abstract void save(T object);
    public abstract void update(T object);
    public abstract void delete(T object);
}
