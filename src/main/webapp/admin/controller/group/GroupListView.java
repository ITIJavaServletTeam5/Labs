/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller.group;

import dao.GroupDao;
import hibernate.DAOFactory;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.MyGroup;

/**
 *
 * @author Marwa
 */
@WebServlet(urlPatterns = {"/admin/group"})

public class GroupListView extends javax.servlet.http.HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String group = request.getParameter("group");
        System.out.println("creating group " + group);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MyGroup> myGroups = new Vector<MyGroup>();
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        GroupDao groupDao = daoFactory.getGroupDAO();
        myGroups = groupDao.findAll();

        request.setAttribute("groups", myGroups);
        getServletContext().getRequestDispatcher("/admin/view/group/group_list.jsp").forward(request, response);
    }

}
