/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.GenericHibernateDAO;

import java.util.List;
import org.hibernate.Query;

import pojo.MyGroup;

/**
 * this class is made for customized queries Each one is free to add his own
 * queries here
 *
 * @author root
 */
public class GroupHibernateDao extends GenericHibernateDAO<MyGroup, Long> implements GroupDao {

    @Override
    public MyGroup findByName(String name) {
        Query query = getSession().createQuery("from MyGroup where name = :name");
        query.setString("name", name);
        query.setMaxResults(1);
        return (MyGroup) query.uniqueResult();
    }

    @Override
    public MyGroup findById(Long id) {
        Query query = getSession().createQuery("from MyGroup where id = :id");
        query.setLong("id", id);
        query.setMaxResults(1);
        return (MyGroup) query.uniqueResult();
    }

}
