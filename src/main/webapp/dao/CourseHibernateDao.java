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
import pojo.MyGroup;

/**
 * this class is made for customized queries Each one is free to add his own
 * queries here
 *
 * @author root
 */
public class CourseHibernateDao extends GenericHibernateDAO<Course, Long> implements CourseDao {

    @Override
    public Course findCourseByNameAndGroupName(String courseName, MyGroup group) {
        Query query = getSession().createQuery("from Course where name = :name AND myGroup = :group");
        query.setString("name", courseName);
        query.setEntity("group", group);
        query.setMaxResults(1);
        return (Course) query.uniqueResult();
    }

    @Override
    public Course findByName(String name) {
        Query query = getSession().createQuery("from Course where name = :name");
        query.setString("name", name);
        query.setMaxResults(1);
        return (Course) query.uniqueResult();
    }

    @Override
    public List<Course> findCoursesByGroup(MyGroup group) {
        Query query = getSession().createQuery("from Course where myGroup= :group");
        query.setEntity("group", group);
        return query.list();
    }

    @Override
    public Course findById(int courseId) {
        Query query = getSession().createQuery("from Course  where id = :id");
        query.setInteger("id", courseId);
        query.setMaxResults(1);
        return (Course) query.uniqueResult();
    }
}
