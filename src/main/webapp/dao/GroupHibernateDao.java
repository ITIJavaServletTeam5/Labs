/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.GenericHibernateDAO;
import java.io.Serializable;
import java.util.List;
import pojo.Assignment;
import pojo.AssignmentId;
import pojo.Group;
import pojo.Trainee;

/**
 *this class is made for customized queries
 * Each one is free to add his own queries here
 * 
 * @author root
 */
public class GroupHibernateDao extends GenericHibernateDAO<Group, Long> implements GroupDao{
    public List<Group> getTrainees(Group g){
        return (List<Group>) getSession().createQuery("from Group ").list();
        
    }
}
