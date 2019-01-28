package by.flathumor.dao;

public interface Dao<T>
{
    T findById(long id);
    void save(T object);
    void update(T object);
    void delete(T object);
}
