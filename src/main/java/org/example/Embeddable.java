package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Embeddable {
    public static void main(String[] args) {
        // Embeddable
//        Laptop l1 = new Laptop();
//        l1.setBrand("Asus");
//        l1.setModel("Vivobook");
//        l1.setRam(16);
//
//
//        Developers dev = new Developers();
//        dev.setId(101);
//        dev.setName("Aditya");
//        dev.setTech("Java");
//        dev.setLaptop(l1);
//
//
//        SessionFactory sf = new Configuration().addAnnotatedClass(Developers.class).configure().buildSessionFactory();
//
//        Session session = sf.openSession();
//
//        Transaction transaction = session.beginTransaction();
//        session.persist(dev);
//        transaction.commit();
//
//        Developers dev1 = session.get(Developers.class,101);
//        System.out.println(dev1);
//
//        session.close();
//        sf.close();
    }
}
