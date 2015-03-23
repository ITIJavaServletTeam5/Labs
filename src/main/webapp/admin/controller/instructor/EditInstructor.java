package admin.controller.instructor;

import dao.InstructorDao;
import dao.TraineeDao;
import hibernate.DAOFactory;
import pojo.Instructor;
import pojo.Trainee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sharno on 3/20/15.
 */
@WebServlet (urlPatterns = "/admin/instructor/edit")
public class EditInstructor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        String email = request.getParameter("email");

        int id = Integer.parseInt(request.getParameter("id"));
        InstructorDao instructorDAO = DAOFactory.instance(DAOFactory.HIBERNATE).getInstructorDAO();
        Instructor instructor = instructorDAO.findById((long) id, false);

//        instructor.setEmail(email);
        instructor.setPassword(password);
        instructor.setUsername(username);

        instructorDAO.makePersistent(instructor);

        response.sendRedirect(request.getContextPath() + "/admin/instructor");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));

        InstructorDao instructorDAO = DAOFactory.instance(DAOFactory.HIBERNATE).getInstructorDAO();
        Instructor instructor = instructorDAO.findById(id, false);

        request.setAttribute("instructor", instructor);
        request.getRequestDispatcher("/admin/view/instructor/edit_instructor.jsp").forward(request, response);
    }
}
