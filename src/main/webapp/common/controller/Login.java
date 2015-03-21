package common.controller;

import dao.InstructorDao;
import dao.TraineeDao;
import dao.UserDao;
import hibernate.DAOFactory;
import pojo.Instructor;
import pojo.Trainee;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("loggedin") == null) {
            request.getRequestDispatcher("/common/view/login.jsp").forward(request, response);
        } else {
            User user = (User) request.getSession().getAttribute("user");
            switch (user.getRole()) {
                case "TRAINEE":
                    response.sendRedirect(request.getContextPath() + "/admin/trainee");
                    break;
                case "INSTRUCTOR":
                    response.sendRedirect(request.getContextPath() + "/admin/trainee");
                    break;
                case "ADMIN":
                    response.sendRedirect(request.getContextPath() + "/admin/trainee");
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User();
        user.setEmail(email);

        UserDao userDao = DAOFactory.instance(DAOFactory.HIBERNATE).getUserDAO();
        List users = userDao.findByExample(user, new String[0]);

        if (users.isEmpty() || !((User) users.get(0)).getPassword().equals(password)) {
            request.setAttribute("errorLogin", true);
            request.getRequestDispatcher("/common/view/login.jsp").forward(request, response);
        } else {
            User foundUser = (User) users.get(0);
            HttpSession session = request.getSession();

            session.setAttribute("user", foundUser);
            session.setAttribute("loggedin", true);

            doGet(request, response);

        }
    }
}
