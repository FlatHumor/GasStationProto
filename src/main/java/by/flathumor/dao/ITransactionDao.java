package by.flathumor.dao;

import java.io.Serializable;

public interface ITransactionDao<T, PK extends Serializable>
{
    T findById(PK pk);
    void save(T entity);
    void update(T entity);
    void delete(T entity);
}
