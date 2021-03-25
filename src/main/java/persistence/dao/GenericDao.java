package persistence.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import persistence.model.*;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

/**
 * @author Bogdan Brl
 * @created 21/03/2021 - 10:29 AM
 * @project CarRentalAppSDAProject
 */
public class GenericDao<T> {

    private SessionFactory sessionFactory;
    private static GenericDao genericDao;

    public GenericDao() {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.put(Environment.URL,
                "jdbc:mysql://localhost:3306/carRentalApp");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "root");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL57Dialect");
        properties.put(Environment.SHOW_SQL, "true");//
        properties.put(Environment.HBM2DDL_AUTO, "update");
//        properties.put(Environment.AUTOCOMMIT, false);

        configuration.setProperties(properties);


        configuration.addAnnotatedClass(Account.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(UserHistory.class);
        configuration.addAnnotatedClass(Administrator.class);
        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(Car.class);
        configuration.addAnnotatedClass(CarOptions.class);
        configuration.addAnnotatedClass(CarHistory.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static GenericDao getInstance() {
        if (genericDao == null) {
            GenericDao genericDao = new GenericDao();
        }
        return genericDao;
    }

    public void add(T object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        if (session != null) {
            session.close();
        }
    }

    public void update(T object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();

        if (session != null) {
            session.close();
        }
    }

    public List<T> getAll(T object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from " + object.getClass().getName());

        List<T> result = query.getResultList();
        transaction.commit();

        if (session != null) {
            session.close();
        }

        return result;
    }

    public void delete(T object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();

        if (session != null) {
            session.close();
        }
    }

    public T findById(T object, String id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from " + object.getClass().getName() + " where id='" + id + "'");
        T result = null;
        try {
            result = (T) query.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
        transaction.commit();

        if (session != null) {
            session.close();
        }
        return result;
    }

    public T findById(T object, int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from " + object.getClass().getName() + " where id='" + id + "'");
        T result = null;
        try {
            result = (T) query.getSingleResult();
        } catch (NoResultException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
        transaction.commit();

        if (session != null) {
            session.close();
        }
        return result;
    }


    public List<T> findByColumn(T object, String column, String value) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from " + object.getClass().getName() +
                " where " + column + " = '" + value + "'");
        List<T> result = null;
        try {
            result = query.getResultList();
        } catch (NoResultException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
        return result;
    }

    public List<T> searchByPeriodOrderedByVIN(T object, LocalDate startDate, LocalDate endDate) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from " + object.getClass().getName() +
                " where pickupDate>='" + startDate + "' and returnDate<='" + endDate + "' order by 'car_id' asc");

        List<T> result = null;
        try {
            result = query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
        return result;
    }

    // @Todo need to be rewritten - this deletes by column named firstName
    public void deleteByColumn(T object, String firstName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int result = session.createQuery("delete from " + object.getClass().getName() +
                " where firstName='" + firstName + "'").executeUpdate();
        transaction.commit();
    }


}


















