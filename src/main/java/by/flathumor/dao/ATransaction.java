package by.flathumor.dao;

import by.flathumor.entity.Transaction;

import java.util.function.Consumer;

public abstract class ATransaction<T extends Transaction, EM> implements Dao<T, EM>
{
    protected EM manager;

    public abstract T findById(Long id);
    public abstract void save(T object);
    public abstract void update(T object);
    public abstract void delete(T object);
    public abstract void executeTransaction(Consumer<EM> action);
}
