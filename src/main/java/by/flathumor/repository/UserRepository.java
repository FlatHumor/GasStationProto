package by.flathumor.repository;

import by.flathumor.entity.User;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class UserRepository extends AUser<User>
{
    @Override
    public User findById(Long id) {
        return manager.find(User.class, id);
    }

    @Override
    public User findByUsername(String username)
    {
        TypedQuery<User> query = manager.createNamedQuery("User.findByUsername", User.class);
        query.setParameter("username", username);
        try {
            return (User)query.getSingleResult();
        }
        catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public User findByIdentificator(String identificator)
    {
        TypedQuery<User> query = manager.createNamedQuery("User.findByIdent", User.class);
        query.setParameter("ident", identificator);
        try {
            return query.getSingleResult();
        }
        catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(User user) {
        executeTransaction(manager->manager.persist(user));
    }

    @Override
    public void update(User user) {
        executeTransaction(manager->manager.merge(user));
    }

    @Override
    public void delete(User user) {
        executeTransaction(manager->manager.remove(user));
    }
}
