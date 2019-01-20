package by.flathumor.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.inject.Singleton;

@Singleton
public class DatabaseRepository
{
    private SessionFactory sessionFactory;

    private void init()
    {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.hbm.xml").build();
        try {
            sessionFactory = new MetadataSources(registry)
                    .buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            System.out.println(e.getMessage());
            for (StackTraceElement s : e.getStackTrace())
                System.out.println(s.toString());
        }
    }

    public Session getSession()
    {
        if (sessionFactory == null)
            init();
        return sessionFactory.openSession();
    }
}
