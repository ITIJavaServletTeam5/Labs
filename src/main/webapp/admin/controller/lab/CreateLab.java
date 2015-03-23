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
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
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

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");

        // String dates = formatter.format(mydate);
        DAOFactory dAOFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        CourseDao courseDao = dAOFactory.getCourseDAO();
        LabDao labDao = dAOFactory.getLabDAO();

        String courseName = request.getParameter("courseSelected");
        String labName = request.getParameter("labname");
        String startDate = request.getParameter("dateStart");
        String endDate = request.getParameter("dateEnd");

        Date startD = formatter.parse(startDate, new ParsePosition(0));
        Date endD = formatter.parse(endDate, new ParsePosition(0));

        System.out.println(startD);
        Lab lab = new Lab();

        Course course = courseDao.findByName(courseName);

        lab.setCourse(course);
        lab.setName(labName);
        lab.setActivated(true);
        lab.setStartTimeQueues(startD);
        lab.setEndTimeQueues(endD);
        
        Lab courseTest = labDao.findLabByNameAndCourseName(labName, course);

        if (courseTest == null && (startD.before(endD))) {
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
