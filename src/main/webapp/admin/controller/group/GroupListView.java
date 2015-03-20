/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller.group;

import admin.controller.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Group;
import pojo.Trainee;

/**
 *
 * @author Marwa
 */
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
        getServletContext().getRequestDispatcher("/admin/view/group_list.jsp").forward(request, response);
    }

}
