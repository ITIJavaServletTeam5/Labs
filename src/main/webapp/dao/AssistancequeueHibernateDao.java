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
import pojo.Assistancequeue;
import pojo.AssistancequeueId;

/**
 * this class is made for customized queries Each one is free to add his own
 * queries here
 *
 * @author root
 */
public class AssistancequeueHibernateDao extends GenericHibernateDAO<Assistancequeue, AssistancequeueId> implements AssistancequeueDao {

    public List<Assistancequeue> getTrainees(Assistancequeue g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Assistancequeue> findAssistanceQueueOfLab(long labId) {
        //To change body of generated methods, choose Tools | Templates.

        Query query = getSession().createQuery("from Assistancequeue aq where aq.lab.id =?");
        query.setString(0, String.valueOf(labId));
        return query.list();
    }

}
