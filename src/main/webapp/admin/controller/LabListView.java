/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Course;
import pojo.Group;
import pojo.Lab;
import pojo.Trainee;

/**
 *
 * @author Marwa
 */
public class LabListView extends javax.servlet.http.HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String group = request.getParameter("lab");
        System.out.println("creating labs " + group);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Lab> labs = new Vector<Lab>();

        Lab c = new Lab();
        c.setName("First Lab");
        labs.add(c);

        Lab c2 = new Lab();
        c2.setName("sec Course");
        labs.add(c2);

        request.setAttribute("labs", labs);
        getServletContext().getRequestDispatcher("/admin/view/create_lab_list.jsp").forward(request, response);
    }

}
