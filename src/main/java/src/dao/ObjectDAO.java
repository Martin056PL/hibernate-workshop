package src.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import src.configuration.HibernateSession;

public class ObjectDAO<T> {


    public void save(T element) {
        Session session = HibernateSession.INSTANCE.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            session.save(element);
            transaction.commit();
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
        }
        session.close();
    }

}
