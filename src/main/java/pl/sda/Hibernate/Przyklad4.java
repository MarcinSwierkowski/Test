package pl.sda.Hibernate;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import pl.sda.Hibernate.model.Country;

public class Przyklad4 {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        NativeQuery<Country> nativeQuery = session.createNativeQuery(
                        "select * from Country where co_name=:name",
                        Country.class)
                .setParameter("name", "Japan");

        nativeQuery.getResultList().forEach(System.out::println);
        session.close();
    }
}
