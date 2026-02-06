package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class OneToManyMapping {
    public static void main(String[] args) {

        Laptop lap1 = new Laptop();
        lap1.setlId(1);
        lap1.setBrand("Asus");
        lap1.setModel("Vivobook");
        lap1.setRam(16);

        Laptop lap2 = new Laptop();
        lap2.setlId(2);
        lap2.setBrand("Dell");
        lap2.setModel("XPS");
        lap2.setRam(32);


        Developers dev = new Developers();
        dev.setId(101);
        dev.setName("Aditya");
        dev.setTech("Java");
        dev.setLaptops(Arrays.asList(lap1,lap2));


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Developers.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction trans = session.beginTransaction();

        session.persist(lap1);
        session.persist(lap2);
        session.persist(dev);

        trans.commit();

        System.out.println(session.get(Developers.class,101));

        session.close();
        sf.close();


    }
}
