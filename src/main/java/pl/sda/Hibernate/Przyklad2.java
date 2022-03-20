package pl.sda.Hibernate;

import org.hibernate.Session;
import pl.sda.Hibernate.model.Address;
import pl.sda.Hibernate.model.Country;

public class Przyklad2 {

    public static void main(String[] args) {

        //usePersist();
        //useMerge();
        //useUpdate();
        //useDelete();
        //usePersistCascade();

    }

    private static void useMerge() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Country country = new Country();
        //country.setId(9);                                 // bez id robi insert  z id update
        country.setName("Mozambik");
        session.beginTransaction();
        country = (Country) session.merge(country);            // po transakcji nie dostaniesz sie do country i nie zmienisz pola
        country.setAlias("MO");                                //
        session.getTransaction().commit();
        session.close();
    }

    private static void usePersist() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Country country = new Country();
        country.setAlias("JP");
        session.beginTransaction();
        session.persist(country);
        country.setName("Japan");
        session.getTransaction().commit();
        session.close();

    }

    private static void useUpdate() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Country country = new Country();
        country.setId(3);
        country.setName("France");
        session.update(country);
        country.setAlias("FR");
        session.getTransaction().commit();
        session.close();
    }

    private static void useDelete() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Country country = new Country(); //session.find(Country.class, 4);
        country.setId(4);
        session.delete(country);
        session.getTransaction().commit();
        session.close();
    }

    public static void usePersistCascade() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Country country = new Country();
        country.setAlias("CZ");
        country.setName("Czech Republic");

        Address address = new Address();
        address.setStreet("Hawla");
        address.setCity("Praga");
        address.setBuildingNo("10");
        address.setApartmentNo("14a");
        address.setPostalCode("02-043");
        address.setCountry(country);

        session.beginTransaction();
        session.persist(address);
        session.getTransaction().commit();
        session.close();
    }

}
