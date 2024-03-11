package lk.ijse.config;

import lk.ijse.entity.*;
import lk.ijse.util.PropertyInjector;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private static SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration().addProperties(PropertyInjector.injectProperties())
                .addAnnotatedClass(Admin.class)
                .addAnnotatedClass(Branch.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Transaction.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() {
        return factoryConfiguration == null ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public static Session getSession() {
        return sessionFactory.openSession();

    }
}
