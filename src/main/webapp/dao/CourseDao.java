/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.GenericDAO;
import java.util.List;
import pojo.Course;
import pojo.MyGroup;

/**
 *
 * @author root this interface no one allowed to add any code to if anyone wants
 * to add his own customized quarry please use XXXHibernateDao
 */
public interface CourseDao extends GenericDAO<Course, Long> {

    public Course findByName(String name);

    public Course findCourseByNameAndGroupName(String courseName, MyGroup group);

    public List<Course> findCoursesByGroup(MyGroup group);

    public Course findById(int courseId);
}
