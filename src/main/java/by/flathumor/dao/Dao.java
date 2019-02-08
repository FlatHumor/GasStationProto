package by.flathumor.dao;

import javax.persistence.EntityManager;
import java.util.function.Consumer;

public interface Dao<T>
{
    T findById(Long id);
    void save(T object);
    void update(T object);
    void delete(T object);
}
