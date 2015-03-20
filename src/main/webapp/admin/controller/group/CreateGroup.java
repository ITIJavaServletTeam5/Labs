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
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory dAOFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        GroupDao groupDao = dAOFactory.getGroupDAO();
        Group g = new Group("group1", "this is bishoy's", Boolean.TRUE, null, null);
        System.out.println(groupDao.getTrainees(g));
        
    }
}
