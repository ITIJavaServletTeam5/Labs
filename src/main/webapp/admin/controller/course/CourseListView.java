/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller.course;

import dao.CourseDao;
import dao.GroupDao;
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
import pojo.MyGroup;

/**
 *
 * @author Marwa
 */
@WebServlet(urlPatterns = {"/admin/course"})
public class CourseListView extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        CourseDao courseDao = daoFactory.getCourseDAO();
        GroupDao groupDao = daoFactory.getGroupDAO();

        List<Course> courses = new Vector<>();
        int groupId = Integer.parseInt(request.getParameter("id"));
        
        MyGroup mygroup = groupDao.findById(groupId);
        
        courses = courseDao.findCoursesByGroup(mygroup);

        request.setAttribute("courses", courses);
        request.getRequestDispatcher("/admin/view/course/course_list.jsp").forward(request, response);
    }

    public List<Course> getCourseList() {
        List<Course> courses = new Vector<Course>();
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        CourseDao courseDao = daoFactory.getCourseDAO();
        courses = courseDao.findAll();

        return courses;
    }
}
