/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller.group;

import java.io.IOException;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Group;

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
        List<Group> groups = new Vector<Group>();

        Group g = new Group();
        g.setName("First Group");
        groups.add(g);

        Group g2 = new Group();
        g2.setName("sec Group");
        groups.add(g2);

        request.setAttribute("groups", groups);
        getServletContext().getRequestDispatcher("/admin/view/group/group_list.jsp").forward(request, response);
    }

}
