package by.flathumor.dao;

import by.flathumor.entity.User;
import by.flathumor.repository.EntityManagerUtil;

import javax.persistence.EntityManager;
import java.util.function.Consumer;

public abstract class AUser<T extends User>
        extends DaoTransaction implements Dao<T>
{
    public abstract T findById(Long id);
    public abstract T findByUsername(String username);
    public abstract T findByIdentificator(String identificator);
    public abstract void save(T object);
    public abstract void update(T object);
    public abstract void delete(T object);
}
