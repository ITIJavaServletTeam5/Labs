/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.GenericDAO;
import java.util.List;
import pojo.Course;
import pojo.Lab;

/**
 *
 * @author root
 * this interface no one allowed to add any code to 
 * if anyone wants to add his own customized quarry 
 * please use XXXHibernateDao
 */
public interface LabDao extends GenericDAO <Lab, Long>{
     public Lab findLabByNameAndCourseName(String labName,Course course);

    public List<Lab> findlabsByCoursesByGroup(Course course);

    
}
