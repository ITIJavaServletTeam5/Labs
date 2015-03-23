package admin.controller.instructor;

import dao.InstructorDao;
import hibernate.DAOFactory;
import pojo.Instructor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sharno on 3/20/15.
 */
@WebServlet(urlPatterns = "/admin/instructor/deactivate")
public class DeactivateInstructor extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));

        InstructorDao instructorDao = DAOFactory.instance(DAOFactory.HIBERNATE).getInstructorDAO();
        Instructor instructor = instructorDao.findById(id, false);
        instructor.setActivated(false);
        instructorDao.makePersistent(instructor);

        response.sendRedirect(request.getContextPath() + "admin/instructor");
    }
}
