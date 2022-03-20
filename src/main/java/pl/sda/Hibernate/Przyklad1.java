package pl.sda.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.sda.Hibernate.model.Address;

public class Przyklad1 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

//        Address address = session.find(Address.class,1);
//        System.out.println(address.getCountry());
//        System.out.println(address);

        session.close();
        sessionFactory.close();

    }
}
