package hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("test1");
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Planet.class)
                .buildSessionFactory();
        try {
            Session session = sessionFactory.openSession();
            // Insert
            /* Planet planet = new Planet("Test122", 110.05, 1, "\"url\"=>\"https://example.com\", \"status\"=>\"active\"", "{\"note\":\"test\"}");
            session.beginTransaction();
            session.save(planet);
            session.getTransaction().commit();
            System.out.println("Insert planet: " + planet); */

            //Select
            session.beginTransaction();
            Planet planet = session.get(Planet.class, 1);
            session.getTransaction().commit();
            System.out.println("Select planet: " + planet);

        } finally {
            sessionFactory.close();
        }
    }
}
