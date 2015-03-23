package admin.controller.trainee;

import dao.TraineeDao;
import hibernate.DAOFactory;
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
@WebServlet (name = "TraineeListView", urlPatterns = "/admin/trainee")
public class TraineeListView extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String trainee = request.getParameter("trainee");
        System.out.println("creating trainee " + trainee);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TraineeDao traineeDao = DAOFactory.instance(DAOFactory.HIBERNATE).getTraineeDAO();
        List<Trainee> trainees = traineeDao.findByAllActivated();

        request.setAttribute("trainees", trainees);
        getServletContext().getRequestDispatcher("/admin/view/trainee/trainee_list.jsp").forward(request, response);
    }
}
