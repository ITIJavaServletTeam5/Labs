package admin.controller.instructor;

//import dao.TraineeController;
import dao.InstructorDao;
import hibernate.DAOFactory;
import hibernate.SessionUtil;
import org.hibernate.Session;
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
@WebServlet(name = "CreateInstructor", urlPatterns = "/admin/instructor/create")
public class CreateInstructor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Instructor instructor = new Instructor();
        instructor.setUsername(username);
        instructor.setEmail(email);
        instructor.setPassword(password);
        instructor.setActivated(true);

        InstructorDao instructorDao = DAOFactory.instance(DAOFactory.HIBERNATE).getInstructorDAO();

        if (instructorDao.findByEmail(email) != null) {
            request.setAttribute("emailError", true);
        } else {
            instructorDao.makePersistent(instructor);
            request.setAttribute("created", true);
        }

        // redirect the user
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/admin/view/instructor/create_instructor.jsp").forward(request, response);
    }
}
