/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller.course;

import java.io.IOException;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Course;

/**
 *
 * @author Marwa
 */
public class CourseListView extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         List<Course> courses = new Vector<Course>();

        Course g = new Course();
        g.setName("First Course");
        courses.add(g);

        Course g2 = new Course();
        g2.setName("sec Course");
        courses.add(g2);

        request.setAttribute("courses", courses);
        request.getRequestDispatcher("/admin/view/course/course_list.jsp").forward(request, response);
    }
}
