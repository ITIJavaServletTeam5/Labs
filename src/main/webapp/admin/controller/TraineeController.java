package admin.controller;

import org.hibernate.Session;
import pojo.NewHibernateUtil;
import pojo.Trainee;

import java.util.List;

/**
 * Created by sharno on 3/19/15.
 */
public class TraineeController {
    public List<Trainee> getAllTrainees() {
        Session session = NewHibernateUtil.getSession();
//        session.get(Trainee.class, null);
        return null;
    }
}
