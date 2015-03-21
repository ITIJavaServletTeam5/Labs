package admin.controller.trainee;

//import dao.TraineeController;
import dao.TraineeDao;
import hibernate.DAOFactory;
import hibernate.SessionUtil;
import org.hibernate.Session;
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
@WebServlet(urlPatterns = "/admin/trainee/create")
public class CreateTrainee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Trainee trainee = new Trainee();
        trainee.setUsername(username);
        trainee.setEmail(email);
        trainee.setPassword(password);
        trainee.setActivated(true);

        TraineeDao traineeDao = DAOFactory.instance(DAOFactory.HIBERNATE).getTraineeDAO();

        if (traineeDao.findByEmail(email) == null) {
            request.setAttribute("emailError", true);
        } else {
            traineeDao.makePersistent(trainee);
            request.setAttribute("created", true);
        }

        // redirect the user
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/admin/view/trainee/create_trainee.jsp").forward(request, response);
    }
}
