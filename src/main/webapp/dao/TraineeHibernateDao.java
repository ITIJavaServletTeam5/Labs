/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.GenericHibernateDAO;
import java.io.Serializable;

import org.hibernate.Query;
import pojo.Assignment;
import pojo.AssignmentId;
import pojo.Trainee;

/**
 *this class is made for customized queries
 * Each one is free to add his own queries here
 * 
 * @author root
 */
public class TraineeHibernateDao extends GenericHibernateDAO<Trainee, Long> implements TraineeDao{

    @Override
    public Trainee findByEmail(String email) {
        Query query = getSession().createQuery("from Trainee where email = :email");
        query.setEntity("email", email);

        return (Trainee) query.uniqueResult();
    }
}
