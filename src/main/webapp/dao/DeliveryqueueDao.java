/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.GenericDAO;
import pojo.Deliveryqueue;
import pojo.DeliveryqueueId;

import java.util.List;

/**
 *
 * @author root
 * this interface no one allowed to add any code to 
 * if anyone wants to add his own customized quarry 
 * please use XXXHibernateDao
 */
public interface DeliveryqueueDao extends GenericDAO<Deliveryqueue, DeliveryqueueId> {
    public List<Deliveryqueue> findDeliveryQueueOfLab (long labId);
}
