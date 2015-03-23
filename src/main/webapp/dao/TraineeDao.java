/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.GenericDAO;
import pojo.MyGroup;
import pojo.Trainee;

import java.util.List;

/**
 *
 * @author root this interface no one allowed to add any code to if anyone wants
 * to add his own customized quarry please use XXXHibernateDao
 */
public interface TraineeDao extends GenericDAO<Trainee, Long> {
    public Trainee findByEmail (String email);

    public List<Trainee> findByAllActivated ();

    public List<Trainee> findAllDeactivated ();

    public List<Trainee> findAllNotInGroup (MyGroup myGroup);
}
