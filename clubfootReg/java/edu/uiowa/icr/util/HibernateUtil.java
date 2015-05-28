package edu.uiowa.icr.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

  
public class HibernateUtil {


    private static final SessionFactory sessionFactory = createSessionFactory();
    private static ServiceRegistry serviceRegistry;
    private static SessionFactory createSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        	//return new Configuration().configure().buildSessionFactory();
        	Configuration configuration = new Configuration();
            configuration.configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(
                    configuration.getProperties()). buildServiceRegistry();
            return configuration.buildSessionFactory(serviceRegistry);
      
            //return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
  
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
  
    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
  
}

