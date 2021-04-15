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
 * @project CarRentalAppTerminalProject
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
        Session session = null;
        Transaction transaction;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void update(T object) {
        Transaction transaction;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<T> getAll(T object) {
        Session session = null;
        Transaction transaction;
        List<T> result = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from " + object.getClass().getName());

            result = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    public void delete(T object) {
        Transaction transaction;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public T findById(T object, String id) {

        T result;

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from " + object.getClass().getName() + " where id=:id");
            query.setParameter("id", id);
            result = (T) query.getSingleResult();
            transaction.commit();
        } catch (NoResultException e) {

            System.out.println(e.getMessage());
            return null;
        }

        return result;
    }

    public T findById(T object, int id) {

        T result;

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from " + object.getClass().getName() + " where id=:id");
            query.setParameter("id", id);
            result = (T) query.getSingleResult();
            transaction.commit();
        } catch (NoResultException e) {

            System.out.println(e.getMessage());
            return null;
        }

        return result;
    }

    public List<T> findByColumnLessOrEqualThanValue(T object, String column, String value) {

        List<T> result = null;
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from " + object.getClass().getName() + " where " + column + " <= '" + value + "'");
            result = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }


    public List<T> findByColumn(T object, String column, String value) {

        List<T> result = null;
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from " + object.getClass().getName() + " where " + column + " = '" + value + "'");
            result = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

//    public List<T> findByColumn(T object, String column, String value) {
//
//        List<T> result = null;
//
//        try (Session session = sessionFactory.openSession()) {
//
//            Transaction transaction = session.beginTransaction();
//            Query query = session.createQuery("from " + object.getClass().getName() + " where " + column + "=:value");
//
//            // from Car where carClass=ECONOMY
//            query.setParameter("value", value);
//            result =query.getResultList();
//            transaction.commit();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
//
//        return result;
//    }

    public List<T> searchByPeriodOrderedByVIN(T object, LocalDate startDate, LocalDate endDate) {

        List<T> result;

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("from " + object.getClass().getName() +
                    " where pickupDate>=:startDate and returnDate<=:endDate order by 'car_id' asc");
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);

            result = query.getResultList();
            transaction.commit();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return result;
    }

    public void deleteByColumn(T object, String column, String value) {

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("delete from " + object.getClass().getName() + " where " + column + "=:value");
            query.setParameter("value", value);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}

















