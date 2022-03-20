package pl.sda.Hibernate.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.sda.Hibernate.HibernateUtil;
import pl.sda.Hibernate.model.Address;

import java.util.List;

public class GenericDaoImp<T> implements GenericDao<T> {

    private Class<T> entityClass;

    public GenericDaoImp(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T findById(int id) throws RuntimeException {
        Session session = openSession();
        T result = session.find(this.entityClass,id);
        session.close();
        return result;
    }

    @Override
    public void insertObject(T t) {
        Session session = openSession();
        session.beginTransaction();
        session.persist(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteObject(T t) {
        Session session = openSession();
        session.beginTransaction();
        session.delete(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteObject(int id) {
        T t = findById(id);
        if (t != null){
            deleteObject(id);
        }
    }

    @Override
    public List<T> findAll() {
        try (Session session = openSession()) {
            return session.createQuery("from "+entityClass.getName(),entityClass).getResultList();
        }
    }

    @Override
    public List<T> findAll(int maxResults, int firstResult) {
        try (Session session = openSession()) {
            return session.createQuery("from "+entityClass.getName(),entityClass)
                    .setFirstResult(firstResult)
                    .setMaxResults(maxResults)
                    .getResultList();
        }
    }


    private Session openSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
}
