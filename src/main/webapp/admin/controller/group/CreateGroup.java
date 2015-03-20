/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller.group;

import dao.CourseDao;
import dao.GroupDao;
import hibernate.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Group;

/**
 *
 * @author Marwa
 */
@WebServlet(name = "CreateGroup", urlPatterns = {"/CreateGroup"})
public class CreateGroup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        DAOFactory dAOFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        GroupDao groupDao = dAOFactory.getGroupDAO();
        Group g = new Group("group1", "this is bishoy's", Boolean.TRUE, null, null);
        groupDao.makePersistent(g);
        
        DAOFactory dAOFactory1 = DAOFactory.instance(DAOFactory.HIBERNATE);
        GroupDao groupDao1 = dAOFactory1.getGroupDAO();
        Group g1 = new Group("group1", "this is bishoy's", Boolean.TRUE, null, null);
        groupDao.makePersistent(g1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory dAOFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        GroupDao groupDao = dAOFactory.getGroupDAO();
        
        Group g = new Group("group1", "this is bishoy's", Boolean.TRUE, null, null);
        g.setId(1);
        groupDao.makePersistent(g);
        
        DAOFactory dAOFactory1 = DAOFactory.instance(DAOFactory.HIBERNATE);
        GroupDao groupDao1 = dAOFactory1.getGroupDAO();
        Group g1 = new Group("group2", "this is BAD", Boolean.TRUE, null, null);
       
        g.setId(1);
        groupDao1.makePersistent(g1);
        
    }
}
