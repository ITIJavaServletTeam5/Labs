//package dao;
//
//import org.hibernate.Session;
//import pojo.Group;
//import pojo.NewHibernateUtil;
//import pojo.Trainee;
//
//import java.util.List;
//
///**
// * Created by sharno on 3/19/15.
// */
//public class TraineeController {
//    public static List<Trainee> getAllTrainees() {
//        Session session = NewHibernateUtil.getSession();
//        return session.createQuery("from Trainee t").list();
//    }
//
//    public static List<Trainee> getGroupTrainees(Group group) {
//        Session session = NewHibernateUtil.getSession();
//        return session.createQuery("from Trainee t where :group member of t.groups and t.activated = true ").list();
//    }
//
//    public static Trainee getTrainee(int id) {
//        Session session = NewHibernateUtil.getSession();
//        return (Trainee) session.load(Trainee.class, id);
//    }
//
//    public static void insertTrainee(Trainee trainee) {
//        Session session = NewHibernateUtil.getSession();
//        session.persist(trainee);
//    }
//
//    public static void updateTrainee(Trainee trainee) {
//        Session session = NewHibernateUtil.getSession();
//        session.update(trainee);
//    }
//
//    public static void deactivateTrainee(Trainee trainee) {
//        Session session = NewHibernateUtil.getSession();
//        trainee.setActivated(false);
//        session.update(trainee);
//    }
//}
