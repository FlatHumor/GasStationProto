package by.flathumor.dao;

import java.io.Serializable;

public interface IUserDao<T, PK extends Serializable>
{
    T findById(PK id);
    T findByUsername(String username);
    void save(T entity);
    void update(T entity);
    void delete(T entity);
}
