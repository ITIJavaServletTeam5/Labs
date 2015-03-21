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
import pojo.Instructor;

/**
 *this class is made for customized queries
 * Each one is free to add his own queries here
 * 
 * @author root
 */
public class InstructorHibernateDao extends GenericHibernateDAO<Instructor, Long> implements InstructorDao{

    @Override
    public Instructor findByEmail(String email) {
        Query query = getSession().createQuery("from Instructor where email = :email");
        query.setEntity("email", email);

        return (Instructor) query.uniqueResult();
    }
}
