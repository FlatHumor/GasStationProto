package by.flathumor.repository;

import by.flathumor.entity.Role;

import javax.ejb.Stateless;

@Stateless
public class RoleRepository extends ARole<Role>
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
