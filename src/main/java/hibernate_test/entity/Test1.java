package hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("test1");
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Planet.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = sessionFactory.openSession();
            // Insert
            /* Planet planet = new Planet("Test122", 110.05, 1, "\"url\"=>\"https://example.com\", \"status\"=>\"active\"", "{\"note\":\"test\"}");
            session.beginTransaction();
            session.save(planet);
            session.getTransaction().commit();
            System.out.println("Insert planet: " + planet); */

            //Select
            System.out.println("--------------------------------------" );
            session.beginTransaction();
            Planet planet = session.get(Planet.class, 1);
            session.getTransaction().commit();
            System.out.println("Select planet: " + planet);

            //Select v2
            System.out.println("--------------------------------------" );
            session.beginTransaction();
            String planetName = session.createQuery("Select name from Planet where name like 'Test%'").list().toString();
            System.out.println("Select toString planetName: " + planetName);
            session.getTransaction().commit();



            //HQL
            System.out.println("--------------------------------------" );
            session.beginTransaction();
            List<Planet> planets = session.createQuery("from Planet where name like 'Test%'").getResultList();
            for (Planet lplanet : planets) {
                System.out.println(lplanet);
            }
            session.getTransaction().commit();

            //UPDATE
            System.out.println("--------------------------------------" );
            session.beginTransaction();
            planet = session.get(Planet.class, 111);
            planet.setName("Test22");
            planet.setDistance(155.50);
            session.getTransaction().commit();
            System.out.println("UPDATE planet: " + planet);

            //Update v2
            System.out.println("--------------------------------------" );
            session.beginTransaction();
            session.createQuery("update from Planet set distance = 200.00 where id = 112").executeUpdate();
            session.getTransaction().commit();

            //DELETE
           /* System.out.println("--------------------------------------" );
            session.beginTransaction();
            planet = session.get(Planet.class, 113);
            session.delete(planet);
            session.getTransaction().commit(); */

            //DELETE v2
            System.out.println("--------------------------------------" );
            session.beginTransaction();
            session.createQuery("delete from Planet where id = 113").executeUpdate();
            session.getTransaction().commit();





        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
