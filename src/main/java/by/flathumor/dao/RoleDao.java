package by.flathumor.dao;

import by.flathumor.entity.Role;
import by.flathumor.repository.EntityManagerUtil;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import java.util.function.Consumer;

@Stateless
public class RoleDao extends ARole<Role>
{
    @Override
    public Role findById(Long id) {
        return manager.find(Role.class, id);
    }

    @Override
    public void save(Role role) {
        executeTransaction(manager->manager.persist(role));
    }

    @Override
    public void update(Role role) {
        executeTransaction(manager->manager.merge(role));
    }

    @Override
    public void delete(Role role) {
        executeTransaction(manager->manager.remove(role));
    }
}
