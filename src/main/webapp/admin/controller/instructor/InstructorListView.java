package admin.controller.instructor;

import dao.InstructorDao;
import dao.TraineeDao;
import hibernate.DAOFactory;
import pojo.Instructor;
import pojo.Trainee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

/**
 * Created by sharno on 3/16/15.
 */
@WebServlet (name = "InstructorListView", urlPatterns = "/admin/instructor")
public class InstructorListView extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String instructor = request.getParameter("instructor");
        System.out.println("creating instructor " + instructor);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        InstructorDao instructorDAO = DAOFactory.instance(DAOFactory.HIBERNATE).getInstructorDAO();
        List<Instructor> instructors = instructorDAO.findByAllActivated();

        request.setAttribute("instructors", instructors);
        getServletContext().getRequestDispatcher("/admin/view/instructor/instructor_list.jsp").forward(request, response);
    }
}
