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
import pojo.Trainee;

/**
 *
 * @author Marwa
 */
public class CourseListView extends javax.servlet.http.HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String group = request.getParameter("group");
        System.out.println("creating group " + group);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Course> courses = new Vector<Course>();

       Course c = new Course();
        c.setName("First Course");
        courses.add(c);

        Course c2 = new Course();
        c2.setName("sec Course");
        courses.add(c2);

        request.setAttribute("courses", courses);
        getServletContext().getRequestDispatcher("/admin/view/create_course_list.jsp").forward(request, response);
    }

}
