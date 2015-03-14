package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


import java.sql.Date;

/**
 * Created by bishoy on 12/03/15.
 */
public class Main {
    public static  void main(String [] args){
        Configuration configuration = new Configuration();
        configuration.configure("dao/hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        Teacher teacher = new Teacher();
        teacher.setFirstName("Medhat");
        teacher.setHireDate(Date.valueOf("2012-06-9"));
        teacher.setLastName("ahmed");
        Student s = new Student();
        s.setLastName("shaheer");
        s.setFirstName("bishoy");
        s.setDepartment("EWD");


        session.beginTransaction();
        session.persist(teacher);
        session.persist(s);
        session.getTransaction().commit();

    }
}
