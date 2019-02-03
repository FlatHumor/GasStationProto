package by.flathumor.dao;

import by.flathumor.entity.Permission;
import by.flathumor.repository.EntityManagerUtil;

import javax.persistence.EntityManager;
import java.util.function.Consumer;

public class PermissionDao extends APermission<Permission, EntityManager>
{
    public PermissionDao() {
        this.manager = EntityManagerUtil.getEntityManager();
    }

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

    @Override
    public void executeTransaction(Consumer<EntityManager> action)
    {
        try {
            manager.getTransaction().begin();
            action.accept(manager);
            manager.getTransaction().commit();
        }
        catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        }
    }
}
