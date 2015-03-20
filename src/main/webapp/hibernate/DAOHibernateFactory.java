/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import dao.AssignmentDao;
import dao.AssignmentHibernateDao;
import dao.AssistancequeueDao;
import dao.AssistancequeueHibernateDao;
import dao.CourseDao;
import dao.CourseHibernateDao;
import dao.DeliveryqueueDao;
import dao.DeliveryqueueHibernateDao;
import dao.GroupDao;
import dao.GroupHibernateDao;
import dao.InstructorDao;
import dao.InstructorHibernateDao;
import dao.LabDao;
import dao.LabHibernateDao;
import dao.TraineeDao;
import dao.TraineeHibernateDao;
import dao.UserDao;
import dao.UserHibernateDao;
import org.hibernate.Session;

/**
 *
 * @author root
 */
public class DAOHibernateFactory extends DAOFactory{
    
    private GenericHibernateDAO instantiateDAO(Class daoClass) {
        try {
            GenericHibernateDAO dao = (GenericHibernateDAO)daoClass.newInstance();
            dao.setSession(getCurrentSession());
            return dao;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Can not instantiate DAO: " + daoClass, ex);
            
        }
    }
    protected Session getCurrentSession() {
        return SessionUtil.getSessionFactory().getCurrentSession();
    }
    
    //Dao interfaces
    public AssignmentDao getAssignmentDAO() {
		return (AssignmentDao)instantiateDAO(AssignmentHibernateDao.class);
	}
    public AssistancequeueDao getAssistancequeueDAO() {
		return (AssistancequeueDao)instantiateDAO(AssistancequeueHibernateDao.class);
	}
    public CourseDao getCourseDAO() {
		return (CourseDao)instantiateDAO(CourseHibernateDao.class);
	}
    public DeliveryqueueDao getDeliveryqueueDAO() {
		return (DeliveryqueueDao)instantiateDAO(DeliveryqueueHibernateDao.class);
	}
    public GroupDao getGroupDAO() {
		return (GroupDao)instantiateDAO(GroupHibernateDao.class);
	}
    public InstructorDao getInstructorDAO() {
		return (InstructorDao)instantiateDAO(InstructorHibernateDao.class);
	}
    public LabDao getLabDAO() {
		return (LabDao)instantiateDAO(LabHibernateDao.class);
	}
    public TraineeDao getTraineeDAO() {
		return (TraineeDao)instantiateDAO(TraineeHibernateDao.class);
	}
    public UserDao getUserDAO() {
		return (UserDao)instantiateDAO(UserHibernateDao.class);
	}
}
