package common.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sharno on 3/20/15.
 */
@WebServlet(name = "Logout", urlPatterns = "/logout")
public class Logout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // just in case it doesn't get invalidated
        request.getSession().invalidate();

        response.sendRedirect(request.getContextPath() + "/login");
    }
}
