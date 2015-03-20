/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller.course;

import dao.CourseDao;
import hibernate.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Course;

/**
 *
 * @author Marwa
 */
@WebServlet(name = "CreateCourse", urlPatterns = {"/CreateCourse"})
public class CreateCourse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory dAOFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        CourseDao courseDao = dAOFactory.getCourseDAO();
        Course c = new  Course();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/admin/view/create_course.jsp").forward(request, response);
    }
}
