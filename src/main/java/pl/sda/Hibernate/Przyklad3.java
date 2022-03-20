package pl.sda.Hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pl.sda.Hibernate.model.Address;

import java.util.List;

public class Przyklad3 {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Address> query = session.createQuery("select a from Address a where a.city = :city", Address.class).setParameter("city","Praga");
        List<Address> addressList = query.getResultList();

        addressList.forEach(System.out::println);

        //Query<Address> query1 = session.createQuery("select o from Order o join fetch o.user where  c.alias = :alias",Address.class).setParameter("alias","PL");
        //List<Address> addressList1 = query1.getResultList();

        session.beginTransaction();

        addressList.get(0).setPostalCode("00-284");
        session.getTransaction().commit();

        session.close();


    }
}
