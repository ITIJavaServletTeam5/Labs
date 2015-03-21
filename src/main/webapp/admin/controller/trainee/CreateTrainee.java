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
@WebServlet(name = "CreateTrainee")
public class CreateTrainee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Trainee trainee = new Trainee();
        trainee.setUsername(request.getParameter("username"));
        trainee.setEmail(request.getParameter("email"));

        System.out.println(request.getParameter("password"));
        trainee.setPassword(request.getParameter("password"));
        trainee.setActivated(true);

        // persist this trainee
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        TraineeDao traineeDao = daoFactory.getTraineeDAO();
        traineeDao.makePersistent(trainee);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/admin/view/trainee/create_trainee.jsp").forward(request, response);
    }
}
