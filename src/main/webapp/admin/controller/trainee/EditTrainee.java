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
@WebServlet (urlPatterns = "/admin/trainee/edit")
public class EditTrainee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        String email = request.getParameter("email");

        Long id = Long.parseLong(request.getParameter("id"));
        TraineeDao traineeDao = DAOFactory.instance(DAOFactory.HIBERNATE).getTraineeDAO();
        Trainee trainee = traineeDao.findById( id, false);

//        trainee.setEmail(email);
        trainee.setPassword(password);
        trainee.setUsername(username);

        traineeDao.makePersistent(trainee);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        TraineeDao traineeDao = DAOFactory.instance(DAOFactory.HIBERNATE).getTraineeDAO();
        Trainee trainee = traineeDao.findById(id, false);

        request.setAttribute("trainee", trainee);
        request.getRequestDispatcher("/admin/view/trainee/edit_trainee.jsp").forward(request, response);
    }
}
