package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Employees emp1 = new Employees();
        emp1.seteId(101);
        emp1.seteName("ADITYA");
        emp1.setDepartment("GRC");

        Employees emp2 = new Employees();
        emp2.seteId(102);
        emp2.seteName("Mihir");
        emp2.setDepartment("IT");

        Employees emp3 = new Employees();
        emp3.seteId(103);
        emp3.seteName("Ayush");
        emp3.setDepartment("UI/UX");

//        // Made for Update
//        Employees emp2 = new Employees();
//        emp2.seteId(103);
//        emp2.seteName("AYUSH");
//        emp2.setDepartment("IT");

        // **Refactor Code** //

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Employees.class)
//                .addAnnotatedClass(Students.class)
//                .addAnnotatedClass(Developers.class)
//                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();


//        Employees e1 = new Employees();
//        e1 = session.get(Employees.class,101);

//        Transaction transaction = session.beginTransaction();  //Transaction only for manipulation (Insert, Update and Delete)

        // Insert
//        session.persist(emp1);
//        session.persist(emp2);
//        session.persist(emp3);

        // Update
//        session.merge(emp2);   // Working as save or update

        // Delete
//        session.remove(e1);

//        transaction.commit();

        // Fetch
//        System.out.println(session.find(Employees.class, 101)); //find()- JPA method similar to get()
        Query q = session.createQuery("FROM Employees");
        Query q1 = session.createQuery("FROM Employees WHERE department='GRC'");

        String qStr = "GRC";
        Query q2 = session.createQuery("FROM Employees WHERE department=?1");
        Query q3 = session.createQuery("FROM Employees WHERE department Like ?1");

        q2.setParameter(1,qStr);
        q3.setParameter(1,qStr);

        List<Employees> dev1 = q1.getResultList();
        List<Employees> dev2 = q2.getResultList();
        List<Employees> dev3 = q3.getResultList();

        System.out.println(dev1);
        System.out.println(dev2);
        System.out.println(dev3);

        session.close();
        sf.close();

    }
}