package pl.sda.Hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pl.sda.Hibernate.model.Country;

import java.util.List;

public class Przyklad5 {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Country> query = session.createNamedQuery("country.select.all", Country.class);
        List<Country> countryList = query.getResultList();
        countryList.forEach(System.out::println);


        //Set<Address> addressSet = countryList.get(2).getAddresses();
        //addressSet.forEach(System.out::println);
        //session.close();
        //System.out.println(addressSet);

    }
}
