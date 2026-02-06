package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class ManyToOneMapping {
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

        Laptop lap3 = new Laptop();
        lap3.setlId(3);
        lap3.setBrand("Apple");
        lap3.setModel("Macbook Pro");
        lap3.setRam(32);

        Developers dev1 = new Developers();
        dev1.setId(101);
        dev1.setName("Aditya");
        dev1.setTech("Java");

        Developers dev2 = new Developers();
        dev2.setId(102);
        dev2.setName("Mihir");
        dev2.setTech("Python");

        Developers dev3 = new Developers();
        dev3.setId(103);
        dev3.setName("Ayush");
        dev3.setTech(".NET");

        dev1.setLaptops(Arrays.asList(lap1,lap3));
        dev2.setLaptops(Arrays.asList(lap2,lap3));
        dev3.setLaptops(Arrays.asList(lap1,lap2));

        lap1.setDevelopers(Arrays.asList(dev1,dev3));
        lap2.setDevelopers(Arrays.asList(dev2,dev3));
        lap3.setDevelopers(Arrays.asList(dev1,dev2));

//        lap1.setDevelopers(dev);
//        lap2.setDevelopers(dev);


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Developers.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction trans = session.beginTransaction();

        session.persist(lap1);
        session.persist(lap2);
        session.persist(lap3);

        session.persist(dev1);
        session.persist(dev2);
        session.persist(dev3);

        trans.commit();

//        System.out.println(session.get(Developers.class,101));

        session.close();
        sf.close();


    }
}
