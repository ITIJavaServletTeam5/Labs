/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.GenericHibernateDAO;
import java.io.Serializable;
import pojo.Assignment;
import pojo.AssignmentId;
import pojo.Lab;

/**
 *this class is made for customized queries
 * Each one is free to add his own queries here
 * 
 * @author root
 */
public class LabHibernateDao extends GenericHibernateDAO<Lab, Long> implements LabDao{
    
}
