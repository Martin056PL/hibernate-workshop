package src.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import src.configuration.HibernateSession;

public class ObjectDAO<T> {


    public void save(T element) {
        Session session = HibernateSession.INSTANCE.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.save(element);
            transaction.commit();
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
        }
        session.close();
    }

}
