package by.flathumor.repository;

import by.flathumor.entity.Transaction;

public abstract class ATransaction<T extends Transaction>
        extends DaoTransaction implements Repository<T>
{
    public abstract T findById(Long id);
    public abstract void save(T object);
    public abstract void update(T object);
    public abstract void delete(T object);
}
