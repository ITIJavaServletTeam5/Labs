package trainee.controller;

import dao.LabDao;
import hibernate.DAOFactory;
import pojo.Lab;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 * Created by sharno on 3/24/15.
 */
@WebServlet(urlPatterns = "/trainee/view/navigation")
public class TraineeNavigation extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        LabDao labDao = DAOFactory.instance(DAOFactory.HIBERNATE).getLabDAO();
        List<Lab> labs = labDao.findLabsOfTraineeId(user.getId());

        List<Lab> activeLabs = new Vector<>();
        Date now = new Date();
        System.out.println(now);

        for (Lab lab : labs) {
            if (now.after(lab.getStartTimeQueues()) && now.before(lab.getEndTimeQueues())) {
                activeLabs.add(lab);
                System.out.println("a lab");
            }
        }

        request.setAttribute("activeLabs", activeLabs);
    }
}
