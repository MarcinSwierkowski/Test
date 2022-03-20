package pl.sda.Hibernate;


import org.hibernate.Session;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import pl.sda.Hibernate.model.Address;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class Przyklad6 {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Address> criteriaQuery =criteriaBuilder.createQuery(Address.class);

        Root<Address> root = criteriaQuery.from(Address.class);

    }


}

