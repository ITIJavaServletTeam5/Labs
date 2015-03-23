package admin.controller.group.trainee;

import dao.GroupDao;
import hibernate.DAOFactory;
import pojo.MyGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sharno on 3/22/15.
 */
@WebServlet(urlPatterns = "/admin/group/trainee")
public class GroupTraineesList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long groupId = Long.parseLong(request.getParameter("groupId"));

        GroupDao groupDao = DAOFactory.instance(DAOFactory.HIBERNATE).getGroupDAO();
        MyGroup group = groupDao.findById(groupId, false);

        request.setAttribute("trainees", group.getTrainees());
        request.getRequestDispatcher("/admin/view/group/trainee/trainee_list_in_group.jsp").forward(request,response);
    }
}
