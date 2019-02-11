package by.flathumor.dao;

public interface Dao<T>
{
    T findById(Long id);
    void save(T object);
    void update(T object);
    void delete(T object);
}
