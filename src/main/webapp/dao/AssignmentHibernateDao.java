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
import pojo.Assistancequeue;
import pojo.User;

/**
 *this class is made for customized queries
 * Each one is free to add his own queries here
 * 
 * @author root
 */
public class AssignmentHibernateDao extends GenericHibernateDAO<Assignment, AssignmentId> implements AssignmentDao{

    
    @Override
    public Assignment findByLabIdAndTraineeId(int labID, int traineeID){
        
        Query query = getSession().createQuery("from Assignment a where a.id=labID and a.lab=traineeID ");
        return (Assignment) query.list().get(0);
    }
    
    @Override
    public String findByName(int traineeID){
        
        Query query = getSession().createQuery("select username from User u where u.id=traineeID ");
        return (String)query.list().get(0);
    }
    
    @Override
    public List<Assignment> findByNameAndAssignment(){
        
        Query query = getSession().createQuery(" from Assignment ");
        return query.list();
    }
    
    public Assignment findByteById(int traineeId){
        Query query = getSession().createQuery("select a from Assignment a where a.trainee.id= :traineeId");
        query.setInteger("traineeId", traineeId);
        return (Assignment) query.list().get(0);
    }
}
