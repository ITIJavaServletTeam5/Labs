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
import pojo.Deliveryqueue;
import pojo.DeliveryqueueId;

/**
 *this class is made for customized queries
 * Each one is free to add his own queries here
 * 
 * @author root
 */
public class DeliveryqueueHibernateDao extends GenericHibernateDAO<Deliveryqueue, DeliveryqueueId> implements DeliveryqueueDao{

    @Override
    public List<Deliveryqueue> findDeliveryQueueOfLab(long labId) {
        Query query = getSession().createQuery("from Deliveryqueue dq where dq.id.labId =?");
        query.setString(0, String.valueOf(labId));
        return query.list();
    }
}
