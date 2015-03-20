package admin.controller.trainee;

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
        trainee.setPassword(request.getParameter("password"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/admin/view/create_trainee.jsp").forward(request, response);
    }
}
