import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by sharno on 3/20/15.
 */
public class Test {
    public static void main (String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();


        session.beginTransaction();
        session.getTransaction().commit();
        System.out.println("inserted");
    }
}
