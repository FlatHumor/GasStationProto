package by.flathumor.repository;

public interface Repository<T>
{
    T findById(Long id);
    void save(T object);
    void update(T object);
    void delete(T object);
}
