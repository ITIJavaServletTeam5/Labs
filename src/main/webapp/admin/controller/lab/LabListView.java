/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller.lab;

import dao.CourseDao;
import dao.GroupDao;
import dao.LabDao;
import hibernate.DAOFactory;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Course;

import pojo.Lab;

/**
 *
 * @author Marwa
 */
@WebServlet(urlPatterns = {"/admin/lab"})
public class LabListView extends javax.servlet.http.HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String group = request.getParameter("lab");
        System.out.println("creating labs " + group);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        CourseDao courseDao = daoFactory.getCourseDAO();
        LabDao labDao = daoFactory.getLabDAO();

        List<Lab> labs = new Vector<Lab>();
        int courseId = Integer.parseInt(request.getParameter("id"));

        Course course = courseDao.findById(courseId);
        labs = labDao.findlabsByCoursesByGroup(course);

        request.setAttribute("labs", labs);
        getServletContext().getRequestDispatcher("/admin/view/lab/lab_list.jsp").forward(request, response);
    }

}
