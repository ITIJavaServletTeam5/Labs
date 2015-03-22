/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller.lab;

import dao.CourseDao;
import dao.LabDao;
import hibernate.DAOFactory;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Course;
import pojo.Lab;
import pojo.MyGroup;

/**
 *
 * @author Marwa
 */
@WebServlet(urlPatterns = {"/admin/lab/create"})
public class CreateLab extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DAOFactory dAOFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        CourseDao courseDao = dAOFactory.getCourseDAO();
        LabDao labDao = dAOFactory.getLabDAO();

        String courseName = request.getParameter("courseSelected");
        String labName = request.getParameter("labname");

        Lab lab = new Lab();

        Course course = courseDao.findByName(courseName);

        lab.setCourse(course);
        lab.setName(labName);
        lab.setActivated(true);

        Lab courseTest = labDao.findLabByNameAndCourseName(labName, course);

        if (courseTest == null) {
            request.setAttribute("created", true);
            labDao.makePersistent(lab);
        } else {
            request.setAttribute("nameError", true);
        }
        request.setAttribute("course", getCourseList());
        request.getRequestDispatcher("/admin/view/lab/create_lab.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("course", getCourseList());
        request.getRequestDispatcher("/admin/view/lab/create_lab.jsp").forward(request, response);
    }

    public List<Course> getCourseList() {
        List<Course> courseList = new Vector<Course>();
        // persist this group
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        CourseDao courseDao = daoFactory.getCourseDAO();
        courseList = courseDao.findAll();

        return courseList;
    }
}
