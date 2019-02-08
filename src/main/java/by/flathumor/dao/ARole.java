package by.flathumor.dao;

import by.flathumor.entity.Role;
import by.flathumor.repository.EntityManagerUtil;

import javax.persistence.EntityManager;
import java.util.function.Consumer;

public abstract class ARole<T extends Role>
        extends DaoTransaction implements Dao<T>
{
    public abstract T findById(Long id);
    public abstract void save(T object);
    public abstract void update(T object);
    public abstract void delete(T object);
}
