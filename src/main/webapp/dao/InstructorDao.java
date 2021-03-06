/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.GenericDAO;
import pojo.Instructor;

import java.util.List;

/**
 *
 * @author root
 * this interface no one allowed to add any code to 
 * if anyone wants to add his own customized quarry 
 * please use XXXHibernateDao
 */
public interface InstructorDao extends GenericDAO <Instructor, Long>{
    public Instructor findByEmail (String email);


    public List<Instructor> findByAllActivated ();

    public List<Instructor> findAllDeactivated ();
}
