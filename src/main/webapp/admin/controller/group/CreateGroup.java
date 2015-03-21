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
@WebServlet(urlPatterns = {"/admin/group/create"})
public class CreateGroup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Group group = new Group();
        group.setName(request.getParameter("groupname"));
        group.setDescription(request.getParameter("description"));
        
        group.setActivated(true);

        // persist this group
        
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        GroupDao groupDao = daoFactory.getGroupDAO();
        groupDao.makePersistent(group);
 
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
        getServletContext().getRequestDispatcher("/admin/view/group/create_group.jsp").forward(request, response);
        
    }
}
