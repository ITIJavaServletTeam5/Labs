package admin.controller.group.trainee;

import dao.GroupDao;
import dao.TraineeDao;
import hibernate.DAOFactory;
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
@WebServlet(urlPatterns = "/admin/group/trainee/add")
public class AddToGroup extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long groupId = Long.parseLong(request.getParameter("groupId"));
        GroupDao groupDao = DAOFactory.instance(DAOFactory.HIBERNATE).getGroupDAO();
        MyGroup myGroup = groupDao.findById(groupId, false);

        TraineeDao traineeDao = DAOFactory.instance(DAOFactory.HIBERNATE).getTraineeDAO();
        List<Trainee> traineesNotInGroup = traineeDao.findAllNotInGroup(myGroup);

        request.setAttribute("trainees", traineesNotInGroup);
        request.setAttribute("groupId", groupId);
        request.getRequestDispatcher("/admin/view/group/trainee/add_trainee_to_group.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long groupId = Long.parseLong(request.getParameter("groupId"));
        String[] traineeIds = request.getParameterValues("trainees");

        if (traineeIds == null) {
            traineeIds = new String[0];
        }

        TraineeDao traineeDao = DAOFactory.instance(DAOFactory.HIBERNATE).getTraineeDAO();
        GroupDao groupDao = DAOFactory.instance(DAOFactory.HIBERNATE).getGroupDAO();

        MyGroup myGroup = groupDao.findById(groupId, true);

        for (String traineeId : traineeIds) {
            Trainee trainee = traineeDao.findById(Long.parseLong(traineeId), true);
            myGroup.addTrainee(trainee);
        }

        groupDao.makePersistent(myGroup);

        response.sendRedirect(request.getContextPath() + "/admin/group/trainee?groupId=" + groupId);
    }
}
