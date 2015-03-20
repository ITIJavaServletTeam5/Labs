package admin.controller.instructor;

//import dao.TraineeController;
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
@WebServlet(name = "CreateTrainee")
public class CreateInstructor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Instructor instructor = new Instructor();
        instructor.setUsername(request.getParameter("username"));
        instructor.setEmail(request.getParameter("email"));
        instructor.setPassword(request.getParameter("password"));
        instructor.setActivated(true);

        Session session = SessionUtil.getSessionFactory().getCurrentSession();
        session.persist(instructor);

        // TODO
        // persist this instructor
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/admin/view/create_instructor.jsp").forward(request, response);
    }
}
