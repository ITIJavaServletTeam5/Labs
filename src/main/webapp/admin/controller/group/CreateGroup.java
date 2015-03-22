/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller.group;

import dao.GroupDao;
import hibernate.DAOFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.MyGroup;

/**
 *
 * @author Marwa
 */
@WebServlet(urlPatterns = {"/admin/group/create"})
public class CreateGroup extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("groupname");

        MyGroup myGroup = new MyGroup();
        myGroup.setName(request.getParameter("groupname"));
        myGroup.setDescription(request.getParameter("description"));
        myGroup.setActivated(true);

        // persist this group
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        GroupDao groupDao = daoFactory.getGroupDAO();

        if (groupDao.findByName(name) == null) {
            request.setAttribute("created", true);
            groupDao.makePersistent(myGroup);
        } else {
            request.setAttribute("nameError", true);
        }

        getServletContext().getRequestDispatcher("/admin/view/group/create_group.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/admin/view/group/create_group.jsp").forward(request, response);

    }
}
