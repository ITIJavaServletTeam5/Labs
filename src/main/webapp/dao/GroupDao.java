/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.GenericDAO;
import java.util.List;
import pojo.MyGroup;

/**
 *
 * @author root
 * this interface no one allowed to add any code to 
 * if anyone wants to add his own customized quarry 
 * please use XXXHibernateDao
 */
public interface GroupDao extends GenericDAO <MyGroup, Long>{
    public MyGroup findByName (String name);
    public MyGroup findById(Long id);
}
