/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.GenericDAO;
import java.util.List;
import pojo.Assignment;
import pojo.AssignmentId;
import pojo.Assistancequeue;
import pojo.User;

/**
 *
 * @author root this interface no one allowed to add any code to if anyone wants
 * to add his own customized quarry please use XXXHibernateDao
 */
public interface AssignmentDao extends GenericDAO<Assignment, AssignmentId> {

    public Assignment findByLabIdAndTraineeId(int labID, int traineeID);
    public String findByName(int traineeID);
    public List<Assignment>  findByNameAndAssignment();
}

