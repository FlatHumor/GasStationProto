package by.flathumor.repository;

import by.flathumor.entity.Permission;

import javax.ejb.Stateless;

@Stateless
public class PermissionRepository extends APermission<Permission>
{
    @Override
    public Permission findById(Long id) {
        return manager.find(Permission.class, id);
    }

    @Override
    public void save(Permission permission) {
        executeTransaction(manager->manager.persist(permission));
    }

    @Override
    public void update(Permission permission) {
        executeTransaction(manager->manager.merge(permission));
    }

    @Override
    public void delete(Permission permission) {
        executeTransaction(manager->manager.remove(permission));
    }
}
