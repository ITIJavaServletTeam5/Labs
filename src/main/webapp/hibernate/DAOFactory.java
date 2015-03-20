/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import dao.AssignmentDao;
import dao.AssistancequeueDao;
import dao.CourseDao;
import dao.DeliveryqueueDao;
import dao.GroupDao;
import dao.InstructorDao;
import dao.LabDao;
import dao.TraineeDao;
import dao.UserDao;
import pojo.Assignment;

/**
 *
 * @author root
 */
public abstract class DAOFactory {
    /**
     * Creates a standalone DAOFactory that returns unmanaged DAO
     * beans for use in any environment Hibernate has been configured
     * for. Uses HibernateUtil/SessionFactory and Hibernate context
     * propagation (CurrentSessionContext), thread-bound or transaction-bound,
     * and transaction scoped.
     */
    public static final Class HIBERNATE = DAOHibernateFactory.class;

    /**
     * Factory method for instantiation of concrete factories.
     */
    public static DAOFactory instance(Class factory) {
        try {
            return (DAOFactory)factory.newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Couldn't create DAOFactory: " + factory);
        }
    }

    // Add your DAO interfaces here
    public abstract AssignmentDao getAssignmentDAO() ;
    
    public abstract AssistancequeueDao getAssistancequeueDAO() ;
    
    public abstract CourseDao getCourseDAO() ;
    
    public abstract DeliveryqueueDao getDeliveryqueueDAO() ;
    
    public abstract GroupDao getGroupDAO() ;
    
    public abstract InstructorDao getInstructorDAO() ;
    
    public abstract LabDao getLabDAO() ;
    
    public abstract TraineeDao getTraineeDAO() ;
    
    public abstract UserDao getUserDAO() ;
}
