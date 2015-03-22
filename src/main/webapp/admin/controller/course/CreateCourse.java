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
@WebServlet(urlPatterns = {"/admin/course/create"})
public class CreateCourse extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory dAOFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        CourseDao courseDao = dAOFactory.getCourseDAO();
        Course course = new Course();

        // find the group id for the selected one
        GroupDao groupDao = dAOFactory.getGroupDAO();
        MyGroup group = groupDao.findByName(request.getParameter("groupSelected"));

        course.setMyGroup(group);

        course.setName(request.getParameter("coursename"));
        course.setDescription(request.getParameter("coursedecription"));
        course.setActivated(true);

        Course courseTest = courseDao.findCourseByNameAndGroupName(request.getParameter("coursename"), group);

        if (courseTest == null) {
            request.setAttribute("created", true);
            courseDao.makePersistent(course);
        } else {
            request.setAttribute("nameError", true);
        }
        request.setAttribute("group", getGroupList());
        request.getRequestDispatcher("/admin/view/course/create_course.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("group", getGroupList());
        request.getRequestDispatcher("/admin/view/course/create_course.jsp").forward(request, response);
    }
    

    public List<MyGroup> getGroupList() {
        List<MyGroup> groupList = new Vector<MyGroup>();
        // persist this group
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        GroupDao groupDao = daoFactory.getGroupDAO();
        groupList = groupDao.findAll();

        return groupList;
    }
}
