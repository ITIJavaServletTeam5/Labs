package common.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            request.getRequestDispatcher("/common/view/login.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/admin/trainee");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email.equals("admin@gmail.com") && password.equals("admin")) {
            
           // request.getRequestDispatcher("/admin/trainee").forward(request, response);
            response.sendRedirect(request.getContextPath()+"/admin/trainee");
//            HttpSession session = request.getSession();
//            session.setAttribute("user", "admin");
        } else {
            response.sendRedirect(request.getContextPath()+"/Login");
        }
    }
}
