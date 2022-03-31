package dao;

import models.Address;
import models.Arena;
import models.Concert;
import models.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

public class Data {

    private SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Address.class)
            .addAnnotatedClass(Arena.class)
            .addAnnotatedClass(Concert.class)
            .addAnnotatedClass(Customer.class)
            .buildSessionFactory();

    private Session session = null;

    public void addData(Object object){
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }

    public Object getData(Class<?> tableClass, int id){
        Object output = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            output = session.find(tableClass, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
        return output;
    }

    public Collection<Object> getDataList(Class<?> tableClass){
        Collection<Object> outputList = new ArrayList<>();
        try {
            session = factory.openSession();
            session.beginTransaction();
            switch (tableClass.getSimpleName().toLowerCase(Locale.ROOT)){
                case "address" -> outputList.addAll(session.createNativeQuery("SELECT * FROM wc.address", tableClass).getResultList());
                case "arena" -> outputList.addAll(session.createNativeQuery("SELECT * FROM wc.arena", tableClass).getResultList());
                case "concert" -> outputList.addAll(session.createNativeQuery("SELECT * FROM wc.concert", tableClass).getResultList());
                case "customer" -> outputList.addAll(session.createNativeQuery("SELECT * FROM wc.customer", tableClass).getResultList());
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
        return outputList;
    }

    public void deleteData(Class<?> tableClass, int id){
        //Collection<Object> outputList = new ArrayList<>();
        try {
            session = factory.openSession();
            session.beginTransaction();
            Object o = session.find(tableClass, id);
            session.delete(o);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }

    public void editData(Class<?> tableClass, Object object){
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }

}
