package admin.controller.trainee;

import dao.TraineeDao;
import hibernate.DAOFactory;
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
@WebServlet(urlPatterns = "/admin/trainee/deactivate")
public class DeactivateTrainee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        TraineeDao traineeDao = DAOFactory.instance(DAOFactory.HIBERNATE).getTraineeDAO();
        Trainee trainee = traineeDao.findById(id, false);
        trainee.setActivated(false);
        traineeDao.makePersistent(trainee);

        response.sendRedirect(request.getContextPath() + "/admin/trainee");
    }
}
