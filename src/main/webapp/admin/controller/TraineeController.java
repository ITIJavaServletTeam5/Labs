package admin.controller;

import org.hibernate.Session;
import hibernate.SessionUtil;
import pojo.Trainee;

import java.util.List;

/**
 * Created by sharno on 3/19/15.
 */
public class TraineeController {
    public List<Trainee> getAllTrainees() {
        Session session = SessionUtil.getSession();
//        session.get(Trainee.class, null);
        return null;
    }
}
