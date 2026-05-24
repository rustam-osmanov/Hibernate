package hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test2ManytoOne {
    public static void main(String[] args) {
        System.out.println("test1");
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(PlanethStore.class)
                .addAnnotatedClass(Government.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = sessionFactory.openSession();
            // Insert
            /* Government government = new Government("TestName223");
            PlanethStore planethStore1 = new PlanethStore("Planet_Test55",500,government,"\"url\"=>\"https://example.com\", \"status\"=>\"active\"");
            PlanethStore planethStore2 = new PlanethStore("Planet_Test65",800,government,"\"url\"=>\"https://example.com\", \"status\"=>\"active\"");
            government.addPlanethStoretoGovernment(planethStore1);
            government.addPlanethStoretoGovernment(planethStore2);
            session.beginTransaction();
            session.save(government);
            session.getTransaction().commit();
            System.out.println("Insert planet: " + government); */


            System.out.println("--------------------------------------");
            session.beginTransaction();
            Government government = (Government) session.get(Government.class, 3);
            System.out.println("Government planet: " + government);
            System.out.println(government.getPlanethStores());
            session.getTransaction().commit();

            System.out.println("--------------------------------------");
            session.beginTransaction();
            PlanethStore planethStore = (PlanethStore) session.get(PlanethStore.class, 11);
            System.out.println("PlanethStore : " + planethStore);
            System.out.println("getGovernment  " + planethStore.getGovernment());
            session.getTransaction().commit();

            System.out.println("--------------------------------------");
            session.beginTransaction();
            planethStore = (PlanethStore) session.get(PlanethStore.class, 24);
            session.delete(planethStore);
            session.getTransaction().commit();
            System.out.println("Success!!!");

        } catch (Exception e) {
            System.out.println( "Error = " + e.getMessage() + "  trace = " + e.getStackTrace());
        }finally {
            session.close();
            sessionFactory.close();
        }


    }
}
