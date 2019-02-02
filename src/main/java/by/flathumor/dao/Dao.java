package by.flathumor.dao;

import java.util.function.Consumer;

public interface Dao<T, EM>
{
    T findById(Long id);
    void save(T object);
    void update(T object);
    void delete(T object);
    void executeTransaction(Consumer<EM> action);
}
