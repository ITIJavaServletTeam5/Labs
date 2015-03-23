/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.GenericHibernateDAO;
import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import pojo.Assignment;
import pojo.AssignmentId;
import pojo.MyGroup;
import pojo.Lab;
import pojo.Trainee;
import pojo.User;

/**
 *this class is made for customized queries
 * Each one is free to add his own queries here
 * 
 * @author root
 */
public class TraineeHibernateDao extends GenericHibernateDAO<Trainee, Long> implements TraineeDao{

    @Override
    public Trainee findByEmail(String email) {
        Query query = getSession().createQuery("from Trainee where email = ?");
        query.setString(0, email);

        return (Trainee) query.uniqueResult();
    }

    @Override
    public List<Trainee> findByAllActivated() {
        Query query = getSession().createQuery("from Trainee where activated = true ");
        return (List<Trainee>) query.list();
    }

    @Override
    public List<Trainee> findAllDeactivated() {
        Query query = getSession().createQuery("from Trainee where activated = false ");
        return (List<Trainee>) query.list();
    }

    @Override
    public List<Trainee> findAllNotInGroup(MyGroup myGroup) {
        Query query = getSession().createQuery("from Trainee t where activated = true and ? not member of t.groups").setEntity(0, myGroup);
        return (List<Trainee>) query.list();
    
    @Override
    public Trainee findByRole(User user) {
        Query query = getSession().createQuery("select t.id from Trainee t, User u where t.id = u.id ");
        
        return (Trainee) query.list().get(0);
    }
    
    @Override
    public Lab findByLabId(int labID){
        Query query = getSession().createQuery("from Lab where id=labID ");
        return (Lab) query.list().get(0);
    }
}
