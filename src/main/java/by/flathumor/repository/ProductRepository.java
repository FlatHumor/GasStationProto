package by.flathumor.repository;

import by.flathumor.entity.Product;

public class ProductRepository extends AProduct<Product>
{
    @Override
    public Product findById(Long id) {
        return manager.find(Product.class, id);
    }

    @Override
    public void save(Product product) {
        executeTransaction(manager->manager.persist(product));
    }

    @Override
    public void update(Product product) {
        executeTransaction(manager->manager.merge(product));
    }

    @Override
    public void delete(Product product) {
        executeTransaction(manager->manager.remove(product));
    }
}
