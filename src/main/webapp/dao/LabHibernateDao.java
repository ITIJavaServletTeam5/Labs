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
import pojo.Course;
import pojo.Lab;

/**
 * this class is made for customized queries Each one is free to add his own
 * queries here
 *
 * @author root
 */
public class LabHibernateDao extends GenericHibernateDAO<Lab, Long> implements LabDao {

    @Override
    public Lab findLabByNameAndCourseName(String labName, Course course) {
        Query query = getSession().createQuery("from Lab where name = :name AND course = :course");
        query.setString("name", labName);
        query.setEntity("course", course);
        query.setMaxResults(1);
        return (Lab) query.uniqueResult();
    }

    @Override
    public List<Lab> findlabsByCoursesByGroup(Course course) {
         Query query = getSession().createQuery("from Lab where course= :course");
        query.setEntity("course", course);
        return query.list();
    }

}
