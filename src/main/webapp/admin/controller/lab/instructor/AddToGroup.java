package admin.controller.lab.instructor;

import dao.GroupDao;
import dao.InstructorDao;
import dao.LabDao;
import dao.TraineeDao;
import hibernate.DAOFactory;
import pojo.Instructor;
import pojo.Lab;
import pojo.MyGroup;
import pojo.Trainee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by sharno on 3/22/15.
 */
@WebServlet(urlPatterns = "/admin/group/course/lab/instructor/add")
public class AddToGroup extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long labId = Long.parseLong(request.getParameter("labId"));
        LabDao labDao = DAOFactory.instance(DAOFactory.HIBERNATE).getLabDAO();
        Lab lab = labDao.findById(labId, false);

        InstructorDao instructorDao = DAOFactory.instance(DAOFactory.HIBERNATE).getInstructorDAO();
        List<Instructor> instructors = instructorDao.findAll();

        request.setAttribute("instructors", instructors);
        request.setAttribute("labId", labId);
        request.getRequestDispatcher("/admin/view/lab/instructor/add_instructor_to_lab.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long labId = Long.parseLong(request.getParameter("labId"));
        String[] instructorIds = request.getParameterValues("instructors");

        if (instructorIds == null) {
            instructorIds = new String[0];
        }

        InstructorDao instructorDao = DAOFactory.instance(DAOFactory.HIBERNATE).getInstructorDAO();
        LabDao labDao = DAOFactory.instance(DAOFactory.HIBERNATE).getLabDAO();

        Lab lab = labDao.findById(labId, true);

        for (String instructorId : instructorIds) {
            Instructor instructor = instructorDao.findById(Long.parseLong(instructorId), true);
            lab.addInstructor(instructor);
        }

        labDao.makePersistent(lab);

        response.sendRedirect(request.getContextPath() + "/admin/group");
    }
}
